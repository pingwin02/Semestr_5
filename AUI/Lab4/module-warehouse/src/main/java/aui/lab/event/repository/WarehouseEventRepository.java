package aui.lab.event.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class WarehouseEventRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public WarehouseEventRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void delete(UUID id) {
        restTemplate.delete("/api/warehouses/{id}", id);
    }


}
