package it.uniroma3.siw.springconcerti.services;

import org.springframework.stereotype.Service;

import it.uniroma3.siw.springconcerti.repository.LuogoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LuogoService {

    private final LuogoRepository luogoRepository;

    public boolean esisteLuogo(String nome, String citta) {
        return this.luogoRepository.existsByNomeAndCitta(nome, citta);
    }
    
}
