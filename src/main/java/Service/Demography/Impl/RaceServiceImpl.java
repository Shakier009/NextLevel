package Service.Demography.Impl;

import Domain.Demography.Race;
import Repository.Demography.Impl.RaceRepositoryImpl;
import Repository.Demography.RaceRepository;
import Service.Demography.RaceService;

import java.util.Set;

public class RaceServiceImpl implements RaceService {
    private static RaceServiceImpl service = null;
    private RaceRepository repository;

    private RaceServiceImpl(){
        this.repository = RaceRepositoryImpl.getRepository();
    }

    public static RaceServiceImpl getService(){
        if (service == null) service = new RaceServiceImpl();
        return service;
    }

    @Override
    public Race create(Race race) {
        return this.repository.create(race);
    }

    @Override
    public Race update(Race race) {
        return this.repository.update(race);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Race read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Race> getAll() {
        return repository.getAll();
    }
}

