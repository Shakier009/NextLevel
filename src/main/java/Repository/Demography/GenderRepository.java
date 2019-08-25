package Repository.Demography;

import Domain.Demography.Gender;
import Repository.IRepository;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender, String> {

    Set<Gender> getAll();
}
