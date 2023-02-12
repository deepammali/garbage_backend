package com.deepammali.garbage_backend.collector;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectorService {

    private final CollectorRepository collectorRepository;

    @Autowired
    public CollectorService(CollectorRepository collectorRepository) {
        this.collectorRepository = collectorRepository;
    }

    public List<Collector> getCollectors() {
        return collectorRepository.findAll();
    }

    public void addNewCollector(Collector collector) {
        Optional<Collector> maybeFindCollectorByEmail = collectorRepository.findByEmail(collector.getEmail());
        if (maybeFindCollectorByEmail.isPresent()) {
            throw new IllegalStateException("Email Exists");
        }
        collectorRepository.save(collector);
        System.out.println(collector);
    }

    public void deleteCollector(Long collectorId) {
        boolean exists = collectorRepository.existsById(collectorId);
        if (!exists) {
            throw new IllegalStateException("Collector with id: " + collectorId + " does not exists");
        }
        collectorRepository.deleteById(collectorId);
    }

}