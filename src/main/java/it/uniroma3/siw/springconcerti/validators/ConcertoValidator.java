package it.uniroma3.siw.springconcerti.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.springconcerti.model.Concerto;
import it.uniroma3.siw.springconcerti.services.ConcertoService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ConcertoValidator implements Validator {

    private static final Logger log = LoggerFactory.getLogger(ConcertoValidator.class);

    private final ConcertoService concertoService;

    @Override
    public void validate(Object target, Errors errors) {
        log.info("Validazione Concerto Iniziata");
        Concerto concerto = (Concerto)target;

        log.debug("Validazione Globale");
        if(this.concertoService.esisteConcerto(concerto.getData(), concerto.getLuogo())) {
            log.debug("Non si può organizzare più concerti nella stessa data nello stesso luogo");
            errors.reject("Overlap.concerto");
        }

        log.info("Validazione Concerto Terminata");
    }
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Concerto.class.equals(clazz);
    }

    
    
}
