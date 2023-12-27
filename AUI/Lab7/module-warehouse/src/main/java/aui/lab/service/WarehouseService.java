package aui.lab.service;

import aui.lab.entity.Warehouse;
import aui.lab.event.repository.WarehouseEventRepository;
import aui.lab.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WarehouseService {
    private final WarehouseRepository repository;

    private final WarehouseEventRepository eventRepository;

    @Autowired
    public WarehouseService(WarehouseRepository repository, WarehouseEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    public List<Warehouse> findAll() {
        return repository.findAll();
    }

    public Optional<Warehouse> find(UUID id) {
        return repository.findById(id);
    }

    public void create(Warehouse warehouse) {
        repository.save(warehouse);
        eventRepository.save(warehouse);
    }

    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }
}
