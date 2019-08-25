package Repository.Demography;

import Domain.Demography.Race;
import Repository.IRepository;

import java.util.Set;

public interface RaceRepository extends IRepository<Race, String> {

    Set<Race> getAll();
}
