package Repository.User;

import Domain.User.EmployeeGender;
import Repository.IRepository;

import java.util.Set;

public interface EmployeeGenderRepository extends IRepository<EmployeeGender, String> {

    Set<EmployeeGender> getAll();
}
