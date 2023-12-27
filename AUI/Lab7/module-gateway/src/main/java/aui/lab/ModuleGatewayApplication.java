package aui.lab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ModuleGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(
            RouteLocatorBuilder builder,
            @Value("${module.gateway.host}") String host
    ) {

        return builder
                .routes()
                .route("warehouse", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/warehouses",
                                "/api/warehouses/{id}"
                        )
                        .uri("lb://module-warehouse")
                )
                .route("product", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/products",
                                "/api/products/**",
                                "/api/warehouses/{id}/products",
                                "/api/warehouses/{id}/products/**"
                        )
                        .uri("lb://module-product")
                )
                .build();
    }
}
