package aui.lab.event.repository;

import aui.lab.entity.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class WarehouseEventRepository {
    private final RestTemplate restTemplate;

    private final LoadBalancerClient loadBalancerClient;

    @Autowired
    public WarehouseEventRepository(RestTemplate restTemplate, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = restTemplate;
        this.loadBalancerClient = loadBalancerClient;
    }

    public void save(Warehouse warehouse) {
        String url = loadBalancerClient.choose("module-product").getUri().toString();
        restTemplate.postForLocation(url + "/api/warehouses", warehouse);
    }

    public void delete(UUID id) {
        String url = loadBalancerClient.choose("module-product").getUri().toString();
        restTemplate.delete(url + "/api/warehouses/{id}", id);
    }

}
