package aui.lab3.service;

import aui.lab3.entity.Package;
import aui.lab3.entity.Warehouse;
import aui.lab3.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PackageService {
    private final PackageRepository packageRepository;

    @Autowired
    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    public Optional<Package> getPackageById(UUID id) {
        return packageRepository.findById(id);
    }

    public List<Package> getPackagesByWarehouse(Warehouse warehouse) {
        return packageRepository.findByWarehouse(warehouse);
    }

    public void savePackage(Package packageItem) {
        packageRepository.save(packageItem);
    }

    public void deletePackage(UUID id) {
        packageRepository.deleteById(id);
    }
}
