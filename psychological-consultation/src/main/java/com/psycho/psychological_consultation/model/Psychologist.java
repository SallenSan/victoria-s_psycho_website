package com.psycho.psychological_consultation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Psychologist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String specialty;

    // relationship with consultation class
    @OneToMany(mappedBy = "psychologist", cascade = CascadeType.ALL)
    private List<Consultation> consultations;


}
