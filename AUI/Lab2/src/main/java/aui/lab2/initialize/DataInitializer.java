package aui.lab2.initialize;

import aui.lab2.entity.Package;
import aui.lab2.entity.Warehouse;
import aui.lab2.service.PackageService;
import aui.lab2.service.WarehouseService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
                .name("Amazon")
                .capacity(50)
                .build();

        Warehouse w2 = Warehouse.builder()
                .name("Allegro")
                .capacity(80)
                .build();

        Package p1 = Package.builder()
                .name("smartphone")
                .weight(10)
                .warehouse(w1)
                .build();

        Package p2 = Package.builder()
                .name("vacuum cleaner")
                .weight(20)
                .warehouse(w1)
                .build();

        Package p3 = Package.builder()
                .name("tv")
                .weight(30)
                .warehouse(w2)
                .build();

        Package p4 = Package.builder()
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
