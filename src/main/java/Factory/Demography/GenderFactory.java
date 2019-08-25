package Factory.Demography;

import Domain.Demography.Gender;
import util.Misc;

public class GenderFactory {

    public static Gender buildGender(String genderName)
    {
        return new Gender.Builder()
                .genderId(Misc.generateID())
                .genderName(genderName)
                .build();
    }


}
