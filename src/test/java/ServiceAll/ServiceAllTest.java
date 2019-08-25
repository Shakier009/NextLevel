package ServiceAll;

import org.junit.Assert;
import org.junit.Test;

public class ServiceAllTest {

    private ServiceAll superService = new ServiceAll();

    @Test
    public void create() {

        String firstName = "Spock";
        String lastName = "Idk";
        String genderName = "Male";
        String raceName = "Vulcan";

        boolean success = superService.create(firstName, lastName, genderName, raceName);

        Assert.assertTrue(success);
    }
}