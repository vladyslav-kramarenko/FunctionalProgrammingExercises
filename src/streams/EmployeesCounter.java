/*
Your task is to implement a method that calculates the total number of employees
with salary >= threshold for all departments whose code starts with the string "111-" (without "").
Try to apply your knowledge of the Stream API and especially the flatMap method to provide the implementation.

An example: there is a list containing two departments and the threshold is 20 000.
 */

package streams;

import java.util.*;
import java.util.stream.Collectors;

class EmployeesCounter {

    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     * @param departments are list of departments
     * @param threshold   is lower edge of salary
     * @return the number of employees
     */
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments
                .stream()
                .filter(department -> department.getCode().startsWith("111-"))
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= threshold)
                .count();
    }

    public static void main(String[] args) {
        List<Department> departments = List.of(
                new Department("dep-1", "111-1", List.of(
                        new Employee("William", 15000L),
                        new Employee("Sophia", 22000L),
                        new Employee("John", 20000L)
                )),
                new Department("dep-2", "222-1", List.of(
                        new Employee("Victor", 25000L)
                ))
        );
        System.out.println(calcNumberOfEmployees(departments, 20000));
    }
}

class Employee {
    private final String name;
    private final Long salary;

    public Employee(String name, Long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class Department {
    private final String name;
    private final String code;
    private final List<Employee> employees;

    public Department(String name, String code, List<Employee> employees) {
        this.name = name;
        this.code = code;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", employees=" + employees +
                '}';
    }
}