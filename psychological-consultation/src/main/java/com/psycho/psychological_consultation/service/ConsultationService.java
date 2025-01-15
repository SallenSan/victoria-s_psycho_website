package com.psycho.psychological_consultation.service;

import com.psycho.psychological_consultation.model.Consultation;
import com.psycho.psychological_consultation.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultationService {
    @Autowired
    private ConsultationRepository repository;
    private ConsultationRepository consultationRepository;


    public Consultation scheduleConsultation(Consultation consultation) {
        consultation.setConsultationStatus("PENDING");
        return repository.save(consultation);
    }

    public List<Consultation> searchConsultationByPeriod(LocalDateTime start, LocalDateTime end) {
        return consultationRepository.findByDateTimeBetween(start, end);
    }

    public Consultation cancelConsultation(Long id) {
        Consultation consultation = consultationRepository.findById(id).orElseThrow( ()-> new RuntimeException("Consultation not found"));

        consultation.setConsultationStatus("CANCELLED");
        return repository.save(consultation);
    }
}
