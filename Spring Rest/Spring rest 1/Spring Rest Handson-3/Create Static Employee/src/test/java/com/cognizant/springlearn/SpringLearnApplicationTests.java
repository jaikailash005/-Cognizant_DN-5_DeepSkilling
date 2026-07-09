package com.cognizant.springlearn;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringLearnApplicationTests {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void contextLoads() {
        assertNotNull(employeeDao, "EmployeeDao bean should be loaded");
        List<Employee> employees = employeeDao.getAllEmployees();
        assertNotNull(employees, "Employee list should not be null");
        assertEquals(4, employees.size(), "Employee list should contain 4 employees");
        
        System.out.println("--- Loaded Employees from employee.xml ---");
        employees.forEach(emp -> System.out.println(emp.toString() + " - Permanent: " + emp.isPermanent() + " - Dept: " + emp.getDepartment()));
        System.out.println("------------------------------------------");
    }
}
