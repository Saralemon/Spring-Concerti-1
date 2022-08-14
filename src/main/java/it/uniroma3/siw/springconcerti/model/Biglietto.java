package it.uniroma3.siw.springconcerti.model;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.AUTO;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import it.uniroma3.siw.springconcerti.enumeration.TipoBiglietto;
import lombok.Data;

@Data
@Entity
public class Biglietto {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 16)
    private String nome;

    @Enumerated(STRING)
    @Column(length = 8)
    private TipoBiglietto tipo;

    @Min(0)
    private BigDecimal prezzo;

    @Min(0)
    private Integer quantita;

    @ManyToOne
    private Concerto concerto;
    
}
