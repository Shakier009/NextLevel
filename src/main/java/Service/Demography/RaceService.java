package Service.Demography;

import Domain.Demography.Race;
import Service.IService;

import java.util.Set;

public interface RaceService extends IService<Race, String> {
    Set<Race> getAll();
}
