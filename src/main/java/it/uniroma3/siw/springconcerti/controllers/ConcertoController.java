package it.uniroma3.siw.springconcerti.controllers;

import static it.uniroma3.siw.springconcerti.constants.CurrencyConstants.SIMBOLO_MONETA;
import static java.time.format.TextStyle.SHORT;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.springconcerti.enumeration.TipoBiglietto;
import it.uniroma3.siw.springconcerti.model.Biglietto;
import it.uniroma3.siw.springconcerti.model.Concerto;
import it.uniroma3.siw.springconcerti.services.ConcertoService;
import it.uniroma3.siw.springconcerti.services.LuogoService;
import it.uniroma3.siw.springconcerti.validators.ConcertoValidator;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ConcertoController {

    private static final Logger log = LoggerFactory.getLogger(ConcertoController.class);

    private final ConcertoService concertoService;
    private final LuogoService luogoService;
    private final ConcertoValidator concertoValidator;

    @GetMapping("/concerti/{id}")
    public String mostraConcerto(
            @RequestParam(required = false, value = "prenotazione") boolean prenotazione,
            @PathVariable Long id,
            Model model) {
        log.info("Richiesta GET /concerti/" + id);
        Concerto concerto = this.concertoService.getConcerto(id);
        String giorno = concerto.getData().getDayOfWeek().getDisplayName(SHORT, Locale.getDefault());
        model.addAttribute("prenotazioneEffettuata", prenotazione);
        model.addAttribute("giorno", giorno);
        model.addAttribute("concerto", concerto);
        model.addAttribute("valuta", SIMBOLO_MONETA);
        return "concerto";
    }

    @GetMapping("/admin/concerti")
    public String getConcerti(Model model) {
        log.info("Richiesta GET /admin/concerti");
        model.addAttribute("concerti", this.concertoService.getConcerti());
        return "admin/concerti";
    }

    @GetMapping("/admin/concerti/new")
    public String newConcerto(Model model) {
        log.info("Richiesta GET /admin/concerti/new");
        model.addAttribute("concerto", new Concerto());
        model.addAttribute("luoghi", this.luogoService.getLuoghi());
        return "admin/concertoForm";
    }

    @GetMapping("/admin/concerti/{id}/modify")
    public String modificaConcerto(@PathVariable Long id, Model model) {
        log.info("Richiesta GET /admin/concerti/" + id + "/modify");
        model.addAttribute("concerto", this.concertoService.getConcerto(id));
        model.addAttribute("luoghi", this.luogoService.getLuoghi());
        return "admin/concertoForm";
    }

    @GetMapping("/admin/concerto/{id}/delete")
    public String cancellaConcerto(@PathVariable Long id, Model model) {
        log.info("Richiesta GET /admin/concerti/" + id + "/delete");
        this.concertoService.cancellaConcerto(id);
        return "redirect:/admin/concerti";
    }

    @GetMapping("/admin/concerto/{id}/biglietti/new")
    public String creaBigliettiConcerto(@PathVariable Long id, Model model) {
        log.info("Richiesta GET /admin/concerti/" + id + "/biglietti/new");
        model.addAttribute("concerto", this.concertoService.getConcerto(id));
        model.addAttribute("biglietto", new Biglietto());
        model.addAttribute("tipi", TipoBiglietto.values());
        return "admin/bigliettiConcertoForm";
    }

    @PostMapping("/admin/concerti/new")
    public String saveConcerto(@Valid @ModelAttribute Concerto concerto, BindingResult bindingResult, Model model) {
        log.info("Richiesta POST /admin/concerti/new");
        this.concertoValidator.validate(concerto, bindingResult);

        if (!bindingResult.hasErrors()) {
            log.info("Parametri inseriti Corretti");
            this.concertoService.salvaConcerto(concerto);
            return "redirect:/admin/concerti";
        }
        log.warn("Parametri inseriti non Validi");
        model.addAttribute("luoghi", this.luogoService.getLuoghi());
        return "admin/concertoForm";
    }

}
