package aui.lab.controller;

import aui.lab.dto.WarehouseRequestDTO;
import aui.lab.dto.WarehouseResponseDTO;
import aui.lab.dto.WarehousesResponseDTO;
import aui.lab.entity.Warehouse;
import aui.lab.function.RequestToWarehouse;
import aui.lab.function.WarehouseToResponse;
import aui.lab.function.WarehousesToResponse;
import aui.lab.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    private final WarehouseService service;

    private final WarehouseToResponse warehouseToResponse;

    private final WarehousesToResponse warehousesToResponse;

    private final RequestToWarehouse requestToWarehouse;

    @Autowired
    public WarehouseController(WarehouseService service,
                               WarehouseToResponse warehouseToResponse,
                               WarehousesToResponse warehousesToResponse,
                               RequestToWarehouse requestToWarehouse
    ) {
        this.service = service;
        this.warehouseToResponse = warehouseToResponse;
        this.warehousesToResponse = warehousesToResponse;
        this.requestToWarehouse = requestToWarehouse;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public WarehousesResponseDTO getWarehouses() {
        return warehousesToResponse.apply(service.findAll());
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WarehouseResponseDTO getWarehouseById(@PathVariable UUID id) {
        return service.find(id)
                .map(warehouseToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveWarehouse(@RequestBody WarehouseRequestDTO warehouseRequestDTO) {
        service.create(requestToWarehouse.apply(warehouseRequestDTO));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateWarehouse(@PathVariable UUID id, @RequestBody WarehouseRequestDTO warehouseRequestDTO) {
        Warehouse warehouse = requestToWarehouse.apply(warehouseRequestDTO);
        service.find(id).ifPresentOrElse(
                (Warehouse warehouseToUpdate) -> {
                    warehouseToUpdate.setName(warehouse.getName());
                    warehouseToUpdate.setCapacity(warehouse.getCapacity());
                    service.create(warehouseToUpdate);
                },
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWarehouse(@PathVariable UUID id) {
        service.delete(id);
    }

}
