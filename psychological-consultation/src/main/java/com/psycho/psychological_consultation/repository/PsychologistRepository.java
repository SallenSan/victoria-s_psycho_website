package com.psycho.psychological_consultation.repository;

import com.psycho.psychological_consultation.model.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsychologistRepository extends JpaRepository<Psychologist, Long> {
    Psychologist findByEmail(String email);
}
