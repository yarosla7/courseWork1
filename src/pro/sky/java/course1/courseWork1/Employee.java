package pro.sky.java.course1.courseWork1;

import java.util.Objects;

public class Employee {

    private String fullName;

    private int department;

    private int salary;

    private final int id;

    private int counterId;

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
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", id=" + id +
                ", counterId=" + counterId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, id);
    }
}

