package it.uniroma3.siw.springconcerti.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.springconcerti.components.CurrencyComponent;
import it.uniroma3.siw.springconcerti.components.UserDetailsComponent;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    private final UserDetailsComponent userDetailsComponent;
    private final CurrencyComponent currencyComponent;

    @GetMapping(value = {"/", "/index"})
    public String index() {
        log.info("Richiesta GET /index");
        return "index";
    }

    @GetMapping("/profilo")
    public String mostraProfilo(Model model) {
        model.addAttribute("utente", this.userDetailsComponent.getUtenteAutenticato());
        model.addAttribute("valuta", this.currencyComponent.getSimboloMoneta());
        return "profilo";
    }

    @GetMapping("/admin/home")
    public String getAdminHome() {
        log.info("Richiesta GET /admin/home");
        return "admin/home";
    }
    
}
