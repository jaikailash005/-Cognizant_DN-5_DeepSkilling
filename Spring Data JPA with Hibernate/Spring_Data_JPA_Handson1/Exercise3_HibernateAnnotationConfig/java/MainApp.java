package com.cognizant.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration()
                        .configure()
                        .buildSessionFactory();

        Session session =
                factory.openSession();

        Transaction tx = null;

        try {

            tx = session.beginTransaction();

            Employee emp = new Employee();

            emp.setFirstName("John");
            emp.setLastName("David");
            emp.setSalary(5000);

            session.save(emp);

            tx.commit();

            System.out.println("Employee Saved");

            List<Employee> employees =
                    session.createQuery("FROM Employee",
                            Employee.class)
                            .list();

            System.out.println("\nAll Employees");

            for(Employee e : employees) {
                System.out.println(e);
            }

            Employee employee =
                    session.get(Employee.class, 3);

            System.out.println("\nEmployee By Id");
            System.out.println(employee);

            tx = session.beginTransaction();

            session.delete(employee);

            tx.commit();

            System.out.println("\nEmployee Deleted");

        }
        catch(Exception e) {

            if(tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        }

        session.close();
        factory.close();
    }
}