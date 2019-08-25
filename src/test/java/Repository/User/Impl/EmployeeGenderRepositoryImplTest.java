package Repository.User.Impl;

import Domain.User.EmployeeGender;
import Factory.User.EmployeeGenderFactory;
import Repository.User.EmployeeGenderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class EmployeeGenderRepositoryImplTest {

    private EmployeeGenderRepository repository;
    private EmployeeGender employeeGender;

    private EmployeeGender getSavedEmployeeGender(){
        Set<EmployeeGender> savedEmployeeGenders = this.repository.getAll();
        return savedEmployeeGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository =  EmployeeGenderRepositoryImpl.getRepository();
        this.employeeGender = EmployeeGenderFactory.buildEmployeeGender("1", "1");
    }

    @Test
    public void getAll() {
        Set<EmployeeGender> all = this.repository.getAll();
        Assert.assertNotNull(all);
    }

    @Test
    public void create() {
        EmployeeGender created = this.repository.create(this.employeeGender);
        getAll();
        Assert.assertSame(created, this.employeeGender);
    }

    @Test
    public void update() {
        String newId = "1";
        EmployeeGender employeeGender = new EmployeeGender.Builder().copy(getSavedEmployeeGender()).employeeId(newId).build();
        EmployeeGender updated = this.repository.update(employeeGender);
        Assert.assertSame(newId, updated.geteEmployeeId());
        getAll();
    }

    @Test
    public void read() {
        EmployeeGender savedEmployeeGender = getSavedEmployeeGender();
        EmployeeGender read = this.repository.read(savedEmployeeGender.geteEmployeeId());
        getAll();
        Assert.assertEquals(savedEmployeeGender, read);
    }

    @Test
    public void delete() {
        EmployeeGender savedEmployeeGender = getSavedEmployeeGender();
        this.repository.delete(savedEmployeeGender.geteEmployeeId());
        getAll();

        //Create another EmployeeGender after deleting so that Read() has something to read.
        this.repository.create(this.employeeGender);
    }
}