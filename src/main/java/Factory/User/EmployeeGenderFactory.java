package Factory.User;

import Domain.User.EmployeeGender;
import util.Misc;

public class EmployeeGenderFactory {

    public static EmployeeGender buildEmployeeGender(String newEmployeeId, String newGenderId){
        return new EmployeeGender.Builder()
                .employeeId(newEmployeeId)
                .genderId(newGenderId)
                .build();
    }
}
