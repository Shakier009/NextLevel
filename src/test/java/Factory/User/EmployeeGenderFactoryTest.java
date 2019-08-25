package Factory.User;

import Domain.User.EmployeeGender;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeGenderFactoryTest {

    @Test
    public void buildEmployeeGender() {
        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender("1","1");
        Assert.assertNotNull(employeeGender);
    }
}