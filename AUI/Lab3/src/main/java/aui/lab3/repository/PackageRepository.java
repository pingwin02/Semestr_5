package aui.lab3.repository;

import aui.lab3.entity.Package;
import aui.lab3.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PackageRepository extends JpaRepository<Package, UUID> {

}