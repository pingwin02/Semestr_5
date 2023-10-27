package aui.lab3.controller;

import aui.lab3.dto.DatabaseResponseDTO;
import aui.lab3.function.DatabaseToResponse;
import aui.lab3.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class DatabaseController {

    private final DatabaseToResponse databaseToResponse;

    private final WarehouseService warehouseService;

    @Autowired
    public DatabaseController(DatabaseToResponse databaseToResponse,
                              WarehouseService warehouseService
    ) {
        this.databaseToResponse = databaseToResponse;
        this.warehouseService = warehouseService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DatabaseResponseDTO> getDatabase() {
        return warehouseService.getAllWarehouses().stream()
                .map(databaseToResponse)
                .collect(java.util.stream.Collectors.toList());
    }
}
