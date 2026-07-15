package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;

@Service
public class EmployeeService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public void updateEmployee(Employee employee)
            throws EmployeeNotFoundException {

        LOGGER.info("START");

        employeeDao.updateEmployee(employee);

        LOGGER.info("END");
    }

    public ArrayList<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}
