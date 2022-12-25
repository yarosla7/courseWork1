package pro.sky.java.course1.courseWork1;

import java.util.Objects;

public class Employee {
    private final String fullName;
    private int department;
    private int salary;
    private static int counterId;
    private final int id;

    public Employee(String fullName, int department, int salary) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Не существующий отдел.");
        }
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = ++counterId;
    }
    public String getFullName() {
        return fullName;
    }
    public int getDepartment() {
        return department;
    }
    public int getSalary() {
        return salary;
    }
    public int getId() {
        return this.id;
    }
    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "\nФИО сотрудника: " + getFullName() + "\nОтдел: " + getDepartment() + "\nЗарплата: " + getSalary() + "\nID: " + getId();

    }
    public String printExceptDepartment(int department) {
        return "\nФИО сотрудника: " + getFullName() + "\nЗарплата: " + getSalary() + "\nID: " + getId();
    }

    public String printForSearch() {
        return "ID: " + getId() + "\nФИО сотрудника: " + getFullName() + "\nЗарплата: " + getSalary();
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Employee employee = (Employee) other;
        return id == employee.id && Objects.equals(fullName, employee.fullName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(fullName, id);
    }
}