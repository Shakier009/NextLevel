package Service.Demography.Impl;

import Domain.Demography.Gender;
import Repository.Demography.GenderRepository;
import Repository.Demography.Impl.GenderRepositoryImpl;
import Service.Demography.GenderService;

import java.util.Set;

public class GenderServiceImpl implements  GenderService{
    private static GenderServiceImpl service = null;
    private GenderRepository repository;

    private GenderServiceImpl(){
        this.repository = GenderRepositoryImpl.getRepository();
    }

    public static GenderServiceImpl getService(){
        if (service == null) service = new GenderServiceImpl();
        return service;
    }

    @Override
    public Gender create(Gender gender) {
        return this.repository.create(gender);
    }

    @Override
    public Gender update(Gender gender) {
        return this.repository.update(gender);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Gender read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Gender> getAll() {
        return repository.getAll();
    }
}
