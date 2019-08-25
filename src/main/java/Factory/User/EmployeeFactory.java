package Factory.User;

import Domain.User.Employee;
import util.Misc;

public class EmployeeFactory {

    public static Employee buildEmployee(String firstName, String lastName){
        return new Employee.Builder()
                .employeeId(Misc.generateID())
                .employeeFirstName(firstName)
                .employeeLastName(lastName)
                .build();
    }
}
