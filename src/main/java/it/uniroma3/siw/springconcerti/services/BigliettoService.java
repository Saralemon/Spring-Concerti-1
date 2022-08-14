package it.uniroma3.siw.springconcerti.services;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.springconcerti.model.Concerto;
import it.uniroma3.siw.springconcerti.repository.BigliettoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BigliettoService {

    private final BigliettoRepository bigliettoRepository;

    public boolean esisteBiglietto(String nome, Concerto concerto) {
        return this.bigliettoRepository.existsByNomeAndConcerto(nome, concerto);
    }
    
}
