package it.uniroma3.siw.springconcerti.services;

import static java.lang.Math.toIntExact;
import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.springconcerti.model.Concerto;
import it.uniroma3.siw.springconcerti.model.Luogo;
import it.uniroma3.siw.springconcerti.repository.ConcertoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConcertoService {

    private final ConcertoRepository concertoRepository;

    @Transactional
    public Concerto salvaConcerto(Concerto concerto) {
        return this.concertoRepository.save(concerto);
    }

    @Transactional
    public void cancellaConcerto(Long id) {
        this.concertoRepository.deleteById(id);
    }

    public List<Concerto> getConcerti() {
        return stream(this.concertoRepository.findAll().spliterator(), false).collect(toList());
    }

    public Concerto getConcerto(Long id) {
        return this.concertoRepository.findById(id).get();
    }

    public int contaConcerti() {
        return toIntExact(this.concertoRepository.count());
    }

    public boolean esisteConcerto(Long id, LocalDate data, Luogo luogo) {
        return this.concertoRepository.existsByIdNotAndDataAndLuogo(id, data, luogo);
    }
    
}
