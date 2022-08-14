package it.uniroma3.siw.springconcerti.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.springconcerti.model.Luogo;
import it.uniroma3.siw.springconcerti.repository.ConcertoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConcertoService {

    private final ConcertoRepository concertoRepository;

    public boolean esisteConcerto(LocalDate data, Luogo luogo) {
        return this.concertoRepository.existsByDataAndLuogo(data, luogo);
    }
    
}
