package it.uniroma3.siw.springconcerti.model;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import it.uniroma3.siw.springconcerti.enumeration.Ruolo;
import lombok.Data;

@Data
@Entity
public class Credenziali {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String username;

    @Column(nullable = false, length = 64)
    private String password;
    
    @Enumerated(STRING)
    private Ruolo ruolo;

}
