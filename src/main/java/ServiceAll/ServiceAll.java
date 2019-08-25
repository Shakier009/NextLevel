package ServiceAll;

import Domain.Demography.Gender;
import Domain.Demography.Race;
import Domain.User.Employee;
import Domain.User.EmployeeGender;
import Factory.Demography.GenderFactory;
import Factory.Demography.RaceFactory;
import Factory.User.EmployeeFactory;
import Factory.User.EmployeeGenderFactory;
import Service.Demography.GenderService;
import Service.Demography.Impl.GenderServiceImpl;
import Service.Demography.Impl.RaceServiceImpl;
import Service.Demography.RaceService;
import Service.User.EmployeeGenderService;
import Service.User.EmployeeService;
import Service.User.Impl.EmployeeGenderServiceImpl;
import Service.User.Impl.EmployeeServiceImpl;

public class ServiceAll {

    private EmployeeService employeeService = EmployeeServiceImpl.getService();
    private EmployeeGenderService employeeGenderService = EmployeeGenderServiceImpl.getService();
    private RaceService raceService = RaceServiceImpl.getService();
    private GenderService genderService = GenderServiceImpl.getService();

    public boolean create(String firstName, String lastName, String genderName, String raceName) {

        boolean success = false;
        try {
            Employee employee = EmployeeFactory.buildEmployee(firstName, lastName);
            employeeService.create(employee);

            Race race = RaceFactory.buildRace(raceName);
            raceService.create(race);

            Gender gender = GenderFactory.buildGender(genderName);
            genderService.create(gender);

            EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender(employee.getEmployeeId(), gender.getGenderId());
            employeeGenderService.create(employeeGender);

            success = true;

        }catch (Exception e){
            success = false;
        }

        return success;

    }
}
