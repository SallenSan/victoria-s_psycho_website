package com.psycho.psychological_consultation.repository;

import com.psycho.psychological_consultation.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByEmail(String email);
}
