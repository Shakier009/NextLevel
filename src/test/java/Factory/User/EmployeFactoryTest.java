package Factory.User;

import Domain.User.Employee;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeFactoryTest {

    @Test
    public void buildEmployee() {
        Employee employee = EmployeeFactory.buildEmployee("Kelvin", "Van Sittert");
        Assert.assertNotNull(employee);
    }
}