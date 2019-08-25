package Service.Demography;

import Domain.Demography.Gender;
import Service.IService;

import java.util.Set;

public interface GenderService extends IService<Gender, String> {
    Set<Gender> getAll();
}
