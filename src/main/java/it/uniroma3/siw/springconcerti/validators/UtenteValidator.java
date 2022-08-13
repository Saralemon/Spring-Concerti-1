package it.uniroma3.siw.springconcerti.validators;

import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.springconcerti.model.Utente;

@Component
public class UtenteValidator implements Validator {

    private static final Logger log = LoggerFactory.getLogger(UtenteValidator.class);

    @Override
    public void validate(Object target, Errors errors) {
        Utente utente = (Utente)target;
        String nome = utente.getNome().trim();
        String cognome = utente.getCognome().trim();

        log.debug("Validazione campo nome");
        rejectIfEmptyOrWhitespace(errors, "nome", "required");
        if(nome.length() < 2 || nome.length() > 20) {
            log.debug("Campo nome non rispetta lunghezza");
            errors.rejectValue("nome", "size");
        }

        log.debug("Validazione campo cognome");
        rejectIfEmptyOrWhitespace(errors, "cognome", "required");
        if(cognome.length() < 2 || cognome.length() > 20) {
            log.debug("Campo cognome non rispetta lunghezza");
            errors.rejectValue("cognome", "size");
        }
        
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Utente.class.equals(clazz);
    }
    
}
