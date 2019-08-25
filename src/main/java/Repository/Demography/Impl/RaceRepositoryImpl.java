package Repository.Demography.Impl;

import Domain.Demography.Race;
import Repository.Demography.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {
    private static RaceRepositoryImpl repository = null;
    private Set<Race> races;

    private RaceRepositoryImpl(){
        this.races = new HashSet<>();
    }

    public static RaceRepositoryImpl getRepository(){
        if (repository == null) repository = new RaceRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Race> getAll() {
        return this.races;
    }

    @Override
    public Race create(Race race) {
        this.races.add(race);
        return race;
    }

    @Override
    public Race update(Race race) {

        Race[] cloneOfRaces = races.toArray(new Race[races.size()]);
        for (int i = 0; i<cloneOfRaces.length;i++) {
            if (cloneOfRaces[i].equals(race)) {
                races.remove(cloneOfRaces[i]);
            }
        }
        return create(race);
    }

    @Override
    public void delete(String raceId) {
        Race[] cloneOfRaces = races.toArray(new Race[races.size()]);
        for (int i = 0; i<cloneOfRaces.length;i++) {
            if (cloneOfRaces[i].getRaceId() == raceId) {
                if (races.contains(cloneOfRaces[i])){
                    races.remove(cloneOfRaces[i]);
                }
            }
        }
    }

    @Override
    public Race read(String raceId) {

        Race raceToReturn = null;

        Race[] cloneOfRaces = races.toArray(new Race[races.size()]);

        for (int i = 0; i<cloneOfRaces.length;i++) {
            if (cloneOfRaces[i].getRaceId() == raceId) {
                raceToReturn = cloneOfRaces[i];
            }
        }

        return raceToReturn;
    }
}
