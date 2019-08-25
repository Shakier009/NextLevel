package Repository.User.Impl;

import Domain.User.Employee;
import Factory.User.EmployeeFactory;
import Repository.User.EmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class EmployeeRepositoryImplTest {

    private EmployeeRepository repository;
    private Employee employee;

    private Employee getSavedEmployee(){
        Set<Employee> savedEmployees = this.repository.getAll();
        return savedEmployees.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository =  EmployeeRepositoryImpl.getRepository();
        this.employee = EmployeeFactory.buildEmployee("Kelvin","Van Sittert");
    }

    @Test
    public void getAll() {
        Set<Employee> all = this.repository.getAll();
        Assert.assertNotNull(all);
    }

    @Test
    public void create() {
        Employee created = this.repository.create(this.employee);
        getAll();
        Assert.assertSame(created, this.employee);
    }

    @Test
    public void update() {
        String newName = "New Name";
        Employee employee = new Employee.Builder().copy(getSavedEmployee()).employeeFirstName(newName).build();
        Employee updated = this.repository.update(employee);
        Assert.assertSame(newName, updated.getEmployeeFirstName());
        getAll();
    }

    @Test
    public void read() {
        Employee savedEmployee = getSavedEmployee();
        Employee read = this.repository.read(savedEmployee.getEmployeeId());
        getAll();
        Assert.assertEquals(savedEmployee, read);
    }

    @Test
    public void delete() {
        Employee savedEmployee = getSavedEmployee();
        this.repository.delete(savedEmployee.getEmployeeId());
        getAll();

        //Create another Employee after deleting so that Read() has something to read.
        this.repository.create(this.employee);
    }
}