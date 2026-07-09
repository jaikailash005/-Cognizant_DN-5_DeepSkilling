package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees() {

        LOGGER.info("START");

        ArrayList<Employee> employees =
                employeeService.getAllEmployees();

        LOGGER.info("END");

        return employees;
    }
}
