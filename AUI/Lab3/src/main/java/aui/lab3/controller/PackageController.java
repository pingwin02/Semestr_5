package aui.lab3.controller;

import aui.lab3.dto.PackageRequestDTO;
import aui.lab3.dto.PackageResponseDTO;
import aui.lab3.entity.Package;
import aui.lab3.function.PackageToResponse;
import aui.lab3.function.RequestToPackage;
import aui.lab3.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/packages")
public class PackageController {

    private final PackageService packageService;

    private final PackageToResponse packageToResponse;

    private final RequestToPackage requestToPackage;

    @Autowired
    public PackageController(PackageService packageService,
                             PackageToResponse packageToResponse,
                             RequestToPackage requestToPackage) {
        this.packageService = packageService;
        this.packageToResponse = packageToResponse;
        this.requestToPackage = requestToPackage;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PackageResponseDTO> getPackages() {
        return packageService.getAllPackages().stream()
                .map(packageToResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PackageResponseDTO getPackageById(@PathVariable UUID id) {
        Optional<Package> packageOptional = packageService.getPackageById(id);
        if (packageOptional.isPresent()) {
            return packageToResponse.apply(packageOptional.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePackage(@RequestBody PackageRequestDTO packageRequestDTO) {
        Package packageItem = requestToPackage.apply(packageRequestDTO);
        try {
            packageService.savePackage(packageItem);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePackage(@PathVariable UUID id, @RequestBody PackageRequestDTO packageRequestDTO) {
        Package packageItem = requestToPackage.apply(packageRequestDTO);
        packageService.getPackageById(id).ifPresentOrElse(
                (Package packageToUpdate) -> {
                    packageToUpdate.setName(packageItem.getName());
                    packageToUpdate.setWeight(packageItem.getWeight());
                    packageToUpdate.setWarehouse(packageItem.getWarehouse());
                    try {
                        packageService.savePackage(packageToUpdate);
                    } catch (Exception e) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                    }
                },
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePackage(@PathVariable UUID id) {
        packageService.deletePackage(id);
    }

}
