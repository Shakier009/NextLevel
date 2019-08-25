package Repository.Demography.Impl;

import Domain.Demography.Gender;
import Factory.Demography.GenderFactory;
import Repository.Demography.GenderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class GenderRepositoryImplTest {

    private GenderRepository repository;
    private Gender gender;

    private Gender getSavedGender(){
        Set<Gender> savedGenders = this.repository.getAll();
        return savedGenders.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository =  GenderRepositoryImpl.getRepository();
        this.gender = GenderFactory.buildGender("Test");
    }

    @Test
    public void getAll() {
        Set<Gender> all = this.repository.getAll();
        Assert.assertNotNull(all);
    }

    @Test
    public void create() {
        Gender created = this.repository.create(this.gender);
        getAll();
        Assert.assertSame(created, this.gender);
    }

    @Test
    public void update() {
        String newName = "New Name";
        Gender gender = new Gender.Builder().copy(getSavedGender()).genderName(newName).build();
        Gender updated = this.repository.update(gender);
        Assert.assertSame(newName, updated.getGenderName());
        getAll();
    }

    @Test
    public void read() {
        Gender savedGender = getSavedGender();
        Gender read = this.repository.read(savedGender.getGenderId());
        getAll();
        Assert.assertEquals(savedGender, read);
    }

    @Test
    public void delete() {
        Gender savedGender = getSavedGender();
        this.repository.delete(savedGender.getGenderId());
        getAll();

        //Create another Gender after deleting so that Read() has something to read.
        this.repository.create(this.gender);
    }
}