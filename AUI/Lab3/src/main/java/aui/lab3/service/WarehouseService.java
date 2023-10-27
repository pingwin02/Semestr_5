package aui.lab3.service;

import aui.lab3.entity.Warehouse;
import aui.lab3.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Optional<Warehouse> getWarehouseById(UUID id) {
        return warehouseRepository.findById(id);
    }

    public void saveWarehouse(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    public void deleteWarehouse(UUID id) {
        warehouseRepository.deleteById(id);
    }
}
