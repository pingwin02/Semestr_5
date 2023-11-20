package aui.lab.product.service;

import aui.lab.product.entity.Product;
import aui.lab.product.repository.ProductRepository;
import aui.lab.warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository repository;

    private final WarehouseRepository warehouseRepository;

    @Autowired
    public ProductService(ProductRepository repository, WarehouseRepository warehouseRepository) {
        this.repository = repository;
        this.warehouseRepository = warehouseRepository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Optional<Product> find(UUID id) {
        return repository.findById(id);
    }

    public Optional<List<Product>> findAllByWarehouse(UUID warehouseId) {
        return warehouseRepository.findById(warehouseId)
                .map(repository::findAllByWarehouse);
    }

    public void create(Product product) {
        repository.save(product);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
