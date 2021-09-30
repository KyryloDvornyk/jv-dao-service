package mate.jdbc.service;

import java.util.List;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Inject
    private ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        if (manufacturer == null || (manufacturer.getName() == null
                && manufacturer.getCountry() == null)) {
            throw new RuntimeException("Can't insert manufacturer with null values");
        }
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        if (id == null) {
            throw new RuntimeException("Can't get manufacturer by null id");
        }
        return manufacturerDao.get(id).orElseThrow(() ->
                new RuntimeException("Manufacturer with id " + id + " does not exist"));
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDao.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        if (manufacturer == null || manufacturer.getId() == null) {
            throw new RuntimeException("Can't update null value manufacturer "
                    + "or manufacturer with null id");
        }
        return manufacturerDao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        if (id == null) {
            throw new RuntimeException("Can't delete manufacturer by null id");
        }
        return manufacturerDao.delete(id);
    }
}
