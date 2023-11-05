package aui.lab.warehouse.service;

import aui.lab.warehouse.entity.Warehouse;
import aui.lab.warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class WarehouseService {
    private final WarehouseRepository repository;


    @Autowired
    public WarehouseService(WarehouseRepository repository) {
        this.repository = repository;
    }

    public Optional<Warehouse> find(UUID id) {
        return repository.findById(id);
    }

    public void create(Warehouse warehouse) {
        repository.save(warehouse);
    }

    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
