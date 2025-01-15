package com.psycho.psychological_consultation.repository;

import com.psycho.psychological_consultation.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);
}
