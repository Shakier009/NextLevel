package Repository.User.Impl;

import Domain.User.EmployeeGender;
import Repository.User.EmployeeGenderRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeGenderRepositoryImpl implements EmployeeGenderRepository {
    private static EmployeeGenderRepositoryImpl repository = null;
    private Set<EmployeeGender> employeeGenders;

    private EmployeeGenderRepositoryImpl(){
        this.employeeGenders = new HashSet<>();
    }

    public static EmployeeGenderRepositoryImpl getRepository(){
        if (repository == null) repository = new EmployeeGenderRepositoryImpl();
        return repository;
    }

    @Override
    public Set<EmployeeGender> getAll() {
        return this.employeeGenders;
    }

    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        this.employeeGenders.add(employeeGender);
        return employeeGender;
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {

        EmployeeGender[] cloneOfEmployeeGenders = employeeGenders.toArray(new EmployeeGender[employeeGenders.size()]);
        for (int i = 0; i<cloneOfEmployeeGenders.length;i++) {
            if (cloneOfEmployeeGenders[i].equals(employeeGender)) {
                employeeGenders.remove(cloneOfEmployeeGenders[i]);
            }
        }
        return create(employeeGender);
    }

    @Override
    public void delete(String employeeGenderId) {
        EmployeeGender[] cloneOfEmployeeGenders = employeeGenders.toArray(new EmployeeGender[employeeGenders.size()]);
        for (int i = 0; i<cloneOfEmployeeGenders.length;i++) {
            if (cloneOfEmployeeGenders[i].getGenderId() == employeeGenderId) {
                if (employeeGenders.contains(cloneOfEmployeeGenders[i])){
                    employeeGenders.remove(cloneOfEmployeeGenders[i]);
                }
            }
        }
    }

    @Override
    public EmployeeGender read(String employeeGenderId) {

        EmployeeGender employeeGenderToReturn = null;

        EmployeeGender[] cloneOfEmployeeGenders = employeeGenders.toArray(new EmployeeGender[employeeGenders.size()]);

        for (int i = 0; i<cloneOfEmployeeGenders.length;i++) {
            if (cloneOfEmployeeGenders[i].getGenderId() == employeeGenderId) {
                employeeGenderToReturn = cloneOfEmployeeGenders[i];
            }
        }

        return employeeGenderToReturn;
    }
}

