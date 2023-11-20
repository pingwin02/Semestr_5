package aui.lab.product.initialize;

import aui.lab.product.entity.Product;
import aui.lab.warehouse.entity.Warehouse;
import aui.lab.product.service.ProductService;
import aui.lab.warehouse.service.WarehouseService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer implements InitializingBean {
    private final WarehouseService warehouseService;
    private final ProductService productService;

    @Autowired
    public DataInitializer(WarehouseService warehouseService, ProductService productService) {
        this.warehouseService = warehouseService;
        this.productService = productService;
    }

    @Override
    public void afterPropertiesSet() {

        Warehouse w1 = Warehouse.builder()
                .id(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"))
                .build();

        Warehouse w2 = Warehouse.builder()
                .id(UUID.fromString("654e3210-9bca-32d1-ba56-499602026999"))
                .build();

        Product p1 = Product.builder()
                .id(UUID.fromString("951e7530-951e-951e-951e-951e7530951e"))
                .name("smartphone")
                .weight(10)
                .warehouse(w1)
                .build();

        Product p2 = Product.builder()
                .id(UUID.fromString("87daf4f4-7fca-4b76-8f93-2ced3252131e"))
                .name("vacuum cleaner")
                .weight(20)
                .warehouse(w1)
                .build();

        Product p3 = Product.builder()
                .id(UUID.fromString("66dda0c1-9900-41f1-a0ab-86922960ef51"))
                .name("tv")
                .weight(30)
                .warehouse(w2)
                .build();

        Product p4 = Product.builder()
                .id(UUID.fromString("e0b0b0c1-3ad3-41f1-a0ab-86922960ef51"))
                .name("dishwasher")
                .weight(40)
                .warehouse(w2)
                .build();

        warehouseService.create(w1);
        warehouseService.create(w2);

        productService.create(p1);
        productService.create(p2);
        productService.create(p3);
        productService.create(p4);
    }
}
