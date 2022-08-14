package it.uniroma3.siw.springconcerti.repository;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.springconcerti.model.Concerto;
import it.uniroma3.siw.springconcerti.model.Luogo;

@Repository
public interface ConcertoRepository extends CrudRepository<Concerto, Long> {

    public boolean existsByDataAndLuogo(LocalDate data, Luogo luogo);
    
}
