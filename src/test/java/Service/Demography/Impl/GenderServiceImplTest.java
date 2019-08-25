package Service.Demography.Impl;

import Domain.Demography.Gender;
import Factory.Demography.GenderFactory;
import Service.Demography.GenderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class GenderServiceImplTest {

    private GenderService service;
    private Gender gender;

    private Gender getSavedGender(){
        Set<Gender> savedGenders = this.service.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = GenderServiceImpl.getService();
        this.gender = GenderFactory.buildGender("Test Gender");
    }

    @Test
    public void create() {

        Gender testCreate = this.service.create(this.gender);
        Assert.assertSame(testCreate, this.gender);

    }

    @Test
    public void update() {
        String newGenderName = "Application Development Theory 3";
        Gender updated = new Gender.Builder().copy(getSavedGender()).genderName(newGenderName).build();
        this.service.update(updated);
        Assert.assertSame(newGenderName, updated.getGenderName());
    }

    @Test
    public void delete() {
        int startingSize = this.service.getAll().size();
        Gender savedGender = getSavedGender();
        this.service.delete(savedGender.getGenderId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another gender after deleting so that Read() has something to read.
        this.service.create(this.gender);
    }

    @Test
    public void read() {
        Gender savedGender = getSavedGender();
        String id = savedGender.getGenderId();
        Gender readGender = this.service.read(id);
        Assert.assertEquals(savedGender, readGender);
    }

    @Test
    public void getAll() {
        Set<Gender> all = this.service.getAll();
        Assert.assertNotNull(all);
    }
}