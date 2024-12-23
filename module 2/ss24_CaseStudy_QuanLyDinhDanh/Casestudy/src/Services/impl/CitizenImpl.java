package Services.impl;

import Models.Entities.Citizens;
import Repositories.CitizenRepository;
import Services.ICitizenServices;

import java.util.List;

public class CitizenImpl implements ICitizenServices {
    private static CitizenRepository citizenRepository = new CitizenRepository();
    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void save(Citizens citizens) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void update(String id, Citizens citizens) {

    }

    @Override
    public Citizens findById(String id) {
        return null;
    }
}
