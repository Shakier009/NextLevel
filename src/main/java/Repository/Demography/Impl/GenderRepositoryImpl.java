package Repository.Demography.Impl;

import Domain.Demography.Gender;
import Repository.Demography.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {
    private static GenderRepositoryImpl repository = null;
    private Set<Gender> genders;

    private GenderRepositoryImpl(){
        this.genders = new HashSet<>();
    }

    public static GenderRepositoryImpl getRepository(){
        if (repository == null) repository = new GenderRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Gender> getAll() {
        return this.genders;
    }

    @Override
    public Gender create(Gender gender) {
        this.genders.add(gender);
        return gender;
    }

    @Override
    public Gender update(Gender gender) {

        Gender[] cloneOfGenders = genders.toArray(new Gender[genders.size()]);
        for (int i = 0; i<cloneOfGenders.length;i++) {
            if (cloneOfGenders[i].equals(gender)) {
                genders.remove(cloneOfGenders[i]);
            }
        }
        return create(gender);
    }

    @Override
    public void delete(String genderId) {
        Gender[] cloneOfGenders = genders.toArray(new Gender[genders.size()]);
        for (int i = 0; i<cloneOfGenders.length;i++) {
            if (cloneOfGenders[i].getGenderId() == genderId) {
                if (genders.contains(cloneOfGenders[i])){
                    genders.remove(cloneOfGenders[i]);
                }
            }
        }
    }

    @Override
    public Gender read(String genderId) {

        Gender genderToReturn = null;

        Gender[] cloneOfGenders = genders.toArray(new Gender[genders.size()]);

        for (int i = 0; i<cloneOfGenders.length;i++) {
            if (cloneOfGenders[i].getGenderId() == genderId) {
                genderToReturn = cloneOfGenders[i];
            }
        }

        return genderToReturn;
    }
}

