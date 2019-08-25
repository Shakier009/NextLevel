package Service.User.Impl;

import Domain.User.EmployeeGender;
import Factory.User.EmployeeGenderFactory;
import Service.User.EmployeeGenderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class EmployeeGenderServiceImplTest {

    private EmployeeGenderService service;
    private EmployeeGender employeeGender;

    private EmployeeGender getSavedEmployeeGender(){
        Set<EmployeeGender> savedEmployeeGenders = this.service.getAll();
        return savedEmployeeGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = EmployeeGenderServiceImpl.getService();
        this.employeeGender = EmployeeGenderFactory.buildEmployeeGender("1","1");
    }

    @Test
    public void create() {

        EmployeeGender testCreate = this.service.create(this.employeeGender);
        Assert.assertSame(testCreate, this.employeeGender);

    }

    @Test
    public void update() {
        String newEmployeeGenderName = "Application Development Theory 3";
        EmployeeGender updated = new EmployeeGender.Builder().copy(getSavedEmployeeGender()).genderId(newEmployeeGenderName).build();
        this.service.update(updated);
        Assert.assertSame(newEmployeeGenderName, updated.getGenderId());
    }

    @Test
    public void delete() {
        int startingSize = this.service.getAll().size();
        EmployeeGender savedEmployeeGender = getSavedEmployeeGender();
        this.service.delete(savedEmployeeGender.getGenderId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another employeeGender after deleting so that Read() has something to read.
        this.service.create(this.employeeGender);
    }

    @Test
    public void read() {
        EmployeeGender savedEmployeeGender = getSavedEmployeeGender();
        String id = savedEmployeeGender.getGenderId();
        EmployeeGender readEmployeeGender = this.service.read(id);
        Assert.assertEquals(savedEmployeeGender, readEmployeeGender);
    }

    @Test
    public void getAll() {
        Set<EmployeeGender> all = this.service.getAll();
        Assert.assertNotNull(all);
    }
}