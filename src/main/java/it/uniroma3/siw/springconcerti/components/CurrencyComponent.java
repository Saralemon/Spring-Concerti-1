package it.uniroma3.siw.springconcerti.components;

import java.util.Currency;
import java.util.Locale;

import org.springframework.stereotype.Component;

/**
 * Classe a supporto dei controller
 * per la gestione della moneta
 */
@Component
public class CurrencyComponent {

    /**
     * Restituisce La stringa che rappresenta il tipo di moneta
     * <hr>
     * @return una stringa con il simbolo monetario
     */
    public String getSimboloMoneta() {
        return Currency.getInstance(Locale.getDefault()).getSymbol();
    }
    
}
