package aui.lab3.controller;

import aui.lab3.dto.PackagesResponseDTO;
import aui.lab3.dto.WarehouseRequestDTO;
import aui.lab3.dto.WarehouseResponseDTO;
import aui.lab3.dto.WarehousesResponseDTO;
import aui.lab3.entity.Warehouse;
import aui.lab3.function.PackagesToResponse;
import aui.lab3.function.RequestToWarehouse;
import aui.lab3.function.WarehouseToResponse;
import aui.lab3.function.WarehousesToResponse;
import aui.lab3.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    private final WarehouseService warehouseService;

    private final WarehouseToResponse warehouseToResponse;

    private final WarehousesToResponse warehousesToResponse;

    private final PackagesToResponse packagesToResponse;

    private final RequestToWarehouse requestToWarehouse;

    @Autowired
    public WarehouseController(WarehouseService warehouseService,
                               WarehouseToResponse warehouseToResponse,
                               WarehousesToResponse warehousesToResponse,
                               PackagesToResponse packagesToResponse,
                               RequestToWarehouse requestToWarehouse
    ) {
        this.warehouseService = warehouseService;
        this.warehouseToResponse = warehouseToResponse;
        this.warehousesToResponse = warehousesToResponse;
        this.packagesToResponse = packagesToResponse;
        this.requestToWarehouse = requestToWarehouse;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public WarehousesResponseDTO getWarehouses() {
        return warehousesToResponse.apply(warehouseService.getAllWarehouses());
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WarehouseResponseDTO getWarehouseById(@PathVariable UUID id) {
        Optional<Warehouse> warehouseOptional = warehouseService.getWarehouseById(id);
        if (warehouseOptional.isPresent()) {
            return warehouseToResponse.apply(warehouseOptional.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/packages")
    @ResponseStatus(HttpStatus.OK)
    public PackagesResponseDTO getPackagesByWarehouseId(@PathVariable UUID id) {
        Optional<Warehouse> warehouseOptional = warehouseService.getWarehouseById(id);
        if (warehouseOptional.isPresent()) {
            return packagesToResponse.apply(warehouseOptional.get().getPackages());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveWarehouse(@RequestBody WarehouseRequestDTO warehouseRequestDTO) {
        Warehouse warehouse = requestToWarehouse.apply(warehouseRequestDTO);
        warehouseService.saveWarehouse(warehouse);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateWarehouse(@PathVariable UUID id, @RequestBody WarehouseRequestDTO warehouseRequestDTO) {
        Warehouse warehouse = requestToWarehouse.apply(warehouseRequestDTO);
        warehouseService.getWarehouseById(id).ifPresentOrElse(
                (Warehouse warehouseToUpdate) -> {
                    warehouseToUpdate.setName(warehouse.getName());
                    warehouseToUpdate.setCapacity(warehouse.getCapacity());
                    warehouseService.saveWarehouse(warehouseToUpdate);
                },
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWarehouse(@PathVariable UUID id) {
        warehouseService.deleteWarehouse(id);
    }


}
