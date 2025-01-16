package com.psycho.psychological_consultation.controller;

import com.psycho.psychological_consultation.model.Consultation;
import com.psycho.psychological_consultation.repository.ConsultationRepository;
import com.psycho.psychological_consultation.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/api/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @PostMapping("/schedule")
    public Consultation scheduleConsultation(@RequestBody Consultation consultation) {
        return consultationService.scheduleConsultation(consultation);
    }

    @GetMapping("/list")
    public List<Consultation> listConsultations(@RequestParam String start, @RequestParam String end) {
        return consultationService.searchConsultationByPeriod(
                LocalDateTime.parse(start),
                LocalDateTime.parse(end)
        );
    }

    @PutMapping("/cancel/{id}")
    public Consultation cancelConsultation(@PathVariable Long id) {
        return consultationService.cancelConsultation(id);
    }

}
