package it.uniroma3.siw.springconcerti.services;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.springconcerti.repository.UtenteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtenteService {

    @SuppressWarnings("unused")
    private final UtenteRepository utenteRepository;
    
}
