package aui.lab3.initialize;

import aui.lab3.entity.Package;
import aui.lab3.entity.Warehouse;
import aui.lab3.service.PackageService;
import aui.lab3.service.WarehouseService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer implements InitializingBean {
    private final WarehouseService warehouseService;
    private final PackageService packageService;

    @Autowired
    public DataInitializer(WarehouseService warehouseService, PackageService packageService) {
        this.warehouseService = warehouseService;
        this.packageService = packageService;
    }

    @Override
    public void afterPropertiesSet() {

        Warehouse w1 = Warehouse.builder()
                .id(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"))
                .name("Amazon")
                .capacity(50)
                .build();

        Warehouse w2 = Warehouse.builder()
                .id(UUID.fromString("654e3210-9bca-32d1-ba56-499602026999"))
                .name("Allegro")
                .capacity(80)
                .build();

        Package p1 = Package.builder()
                .id(UUID.fromString("951e7530-951e-951e-951e-951e7530951e"))
                .name("smartphone")
                .weight(10)
                .warehouse(w1)
                .build();

        Package p2 = Package.builder()
                .id(UUID.fromString("87daf4f4-7fca-4b76-8f93-2ced3252131e"))
                .name("vacuum cleaner")
                .weight(20)
                .warehouse(w1)
                .build();

        Package p3 = Package.builder()
                .id(UUID.fromString("66dda0c1-9900-41f1-a0ab-86922960ef51"))
                .name("tv")
                .weight(30)
                .warehouse(w2)
                .build();

        Package p4 = Package.builder()
                .id(UUID.fromString("e0b0b0c1-3ad3-41f1-a0ab-86922960ef51"))
                .name("dishwasher")
                .weight(40)
                .warehouse(w2)
                .build();

        warehouseService.saveWarehouse(w1);
        warehouseService.saveWarehouse(w2);

        packageService.savePackage(p1);
        packageService.savePackage(p2);
        packageService.savePackage(p3);
        packageService.savePackage(p4);
    }
}
