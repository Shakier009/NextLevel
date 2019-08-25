package Service.User.Impl;

import Domain.User.Employee;
import Factory.User.EmployeeFactory;
import Service.User.EmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class EmployeeServiceImplTest {

    private EmployeeService service;
    private Employee employee;

    private Employee getSavedEmployee(){
        Set<Employee> savedEmployees = this.service.getAll();
        return savedEmployees.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = EmployeeServiceImpl.getService();
        this.employee = EmployeeFactory.buildEmployee("Kelvin", "Van Sittert");
    }

    @Test
    public void create() {

        Employee testCreate = this.service.create(this.employee);
        Assert.assertSame(testCreate, this.employee);

    }

    @Test
    public void update() {
        String newEmployeeName = "Application Development Theory 3";
        Employee updated = new Employee.Builder().copy(getSavedEmployee()).employeeFirstName(newEmployeeName).build();
        this.service.update(updated);
        Assert.assertSame(newEmployeeName, updated.getEmployeeFirstName());
    }

    @Test
    public void delete() {
        int startingSize = this.service.getAll().size();
        Employee savedEmployee = getSavedEmployee();
        this.service.delete(savedEmployee.getEmployeeId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another employee after deleting so that Read() has something to read.
        this.service.create(this.employee);
    }

    @Test
    public void read() {
        Employee savedEmployee = getSavedEmployee();
        String id = savedEmployee.getEmployeeId();
        Employee readEmployee = this.service.read(id);
        Assert.assertEquals(savedEmployee, readEmployee);
    }

    @Test
    public void getAll() {
        Set<Employee> all = this.service.getAll();
        Assert.assertNotNull(all);
    }
}