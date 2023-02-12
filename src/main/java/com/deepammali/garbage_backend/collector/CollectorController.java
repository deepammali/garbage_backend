package com.deepammali.garbage_backend.collector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CollectorController {

    private CollectorService collectorService;

    @Autowired
    public CollectorController(CollectorService collectorService) {
        this.collectorService = collectorService;
    }

    @GetMapping("/collectors")
    public List<Collector> getCollectors() {
        return collectorService.getCollectors();
    }

    @PostMapping("/collectors")
    public void registerNewCollector(@RequestBody Collector collector) {
        collectorService.addNewCollector(collector);
    }

    @DeleteMapping("/collectors")
    public void deleteCollector(@RequestBody Collector collector) {
        collectorService.deleteCollector(collector.getId());
    }

}
