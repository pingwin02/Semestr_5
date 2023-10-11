package aui.lab2.repository;

import aui.lab2.entity.Package;
import aui.lab2.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PackageRepository extends JpaRepository<Package, UUID> {

    List<Package> findByWarehouse(Warehouse warehouse);
}