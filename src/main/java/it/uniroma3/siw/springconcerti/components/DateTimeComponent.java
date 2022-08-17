package it.uniroma3.siw.springconcerti.components;

import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * Classe a supporto dei controller
 * per la gestione del tipo DateTime
 */
@Component
public class DateTimeComponent {

    /**
     * <p>
     * Questo metodo si occupa di mappare i parametri
     * dedicati alla rappresentazione dei giorni della settimana
     * nei template.
     * </p>
     * Il Mapping si occupa di mappare i seguenti parametri:
     * <ul>
     * <li>stileData -> {@code TextStyle.SHORT}</li>
     * <li>linguaData -> {@code Locale.getDefault()}</li>
     * </ul>
     * <hr>
     * 
     * @return una mappa con i parametri mappati
     */
    public Map<String, Object> getMappingStileGiornoDellaSettimana() {
        return Map.of("stileData", TextStyle.SHORT, "linguaData", Locale.getDefault());
    }

}
