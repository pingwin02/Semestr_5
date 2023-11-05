package aui.lab.initialize;

import aui.lab.entity.Warehouse;
import aui.lab.service.WarehouseService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer implements InitializingBean {
    private final WarehouseService warehouseService;

    @Autowired
    public DataInitializer(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
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

        Warehouse w3 = Warehouse.builder()
                .id(UUID.fromString("44e3210-9bca-32d1-ba56-499602026999"))
                .name("AliExpress")
                .capacity(120)
                .build();


        warehouseService.create(w1);
        warehouseService.create(w2);
        warehouseService.create(w3);

    }
}
