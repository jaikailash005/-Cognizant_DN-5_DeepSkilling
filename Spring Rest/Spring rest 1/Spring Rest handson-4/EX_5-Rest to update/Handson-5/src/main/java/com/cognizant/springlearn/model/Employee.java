package com.cognizant.springlearn.model;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {

    @NotNull(message = "Id cannot be null")
    private Integer id;

    @NotBlank(message = "Employee name cannot be blank")
    private String name;

    @NotNull(message = "Salary should be zero or above")
    @Min(value = 0, message = "Salary should be zero or above")
    private Double salary;

    private boolean permanent;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT+5:30")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    private Department department;

    private List<Skill> skillList;

    public Employee() {
    }

    public Employee(Integer id, String name, Double salary, boolean permanent, Date dateOfBirth, Department department, List<Skill> skillList) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.permanent = permanent;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.skillList = skillList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfBirthStr(String dateOfBirthStr) {
        try {
            this.dateOfBirth = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirthStr);
        } catch (java.text.ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
                + ", dateOfBirth=" + dateOfBirth + ", department=" + department + ", skillList=" + skillList + "]";
    }
}
