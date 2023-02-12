package com.deepammali.garbage_backend.collector;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectorRepository extends JpaRepository<Collector, Long> {

    Optional<Collector> findByEmail(String email);

}
