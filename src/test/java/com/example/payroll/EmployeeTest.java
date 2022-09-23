package com.example.payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class EmployeeTest {

    @Test
    void testOvertimeHours1() {
        Employee employee = new Employee("a", "b", 230);
        employee.setId(1L);
        assertEquals(employee.toOvertimeEmployee().getOvertime(), 30);
    }

    @Test
    void testOvertimeHours2() {
        Employee employee = new Employee("a", "b", 190);
        employee.setId(1L);
        assertEquals(employee.toOvertimeEmployee().getOvertime(), 0);
    }

    @Test
    void testOvertimeHours3() {
        Employee employee = new Employee("a", "b", 230);
        employee.setId(1L);
        assertNotEquals(employee.toOvertimeEmployee().getOvertime(), 0);
    }

    @Test
    void testOvertimeHours4() {
        Employee employee = new Employee("a", "b", 190);
        employee.setId(1L);
        assertNotEquals(employee.toOvertimeEmployee().getOvertime(), 30);
    }

    @Test
    void noIdEmployee() {
        Employee employee = new Employee("a", "b", 214);
        assertThrowsExactly(NullPointerException.class, () -> employee.toOvertimeEmployee().getOvertime());
    }

    @Test
    void testNameOvertimeEmployee() {
        Employee employee = new Employee("a", "b", 190);
        employee.setId(1L);
        assertEquals(employee.toOvertimeEmployee().getName(), employee.getName());
    }

    @Test
    void testIdOvertimeEmployee() {
        Employee employee = new Employee("a", "b", 190);
        employee.setId(1L);
        assertEquals(employee.toOvertimeEmployee().getId(), employee.getId());
    }
}
