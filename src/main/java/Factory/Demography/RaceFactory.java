package Factory.Demography;

import Domain.Demography.Race;
import util.Misc;

public class RaceFactory {

    public static Race buildRace(String raceName) {
        return new Race.Builder()
                .raceId(Misc.generateID())
                .raceName(raceName)
                .build();
    }
}