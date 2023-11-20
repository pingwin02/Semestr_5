package aui.lab.product.repository;

import aui.lab.product.entity.Product;
import aui.lab.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findAllByWarehouse(Warehouse warehouse);

}