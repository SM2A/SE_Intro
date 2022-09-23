package com.example.payroll;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Employee {

    private @Id
    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC) @GeneratedValue Long id;
    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC) private String name;
    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC) private String role;

    @Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC) private int workingHours;

    private static final int DUTY_HOURS = 200;

    Employee() {
    }

    Employee(String name, String role, int workingHours) {

        this.name = name;
        this.role = role;
        this.workingHours = workingHours;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
                && Objects.equals(this.role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
    }

    public OvertimeEmployee toOvertimeEmployee(){
        int overtime = workingHours > DUTY_HOURS ? workingHours - DUTY_HOURS : 0;
        return new OvertimeEmployee(id, name, overtime);
    }

    class OvertimeEmployee {

        @Getter
        private final long id;

        @Getter private final String name;

        @Getter private final int overtime;

        public OvertimeEmployee(long id, String name, int overtime) {
            this.id = id;
            this.name = name;
            this.overtime = overtime;
        }
    }
}