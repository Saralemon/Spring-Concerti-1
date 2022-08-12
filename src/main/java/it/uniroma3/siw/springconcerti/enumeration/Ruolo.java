package it.uniroma3.siw.springconcerti.enumeration;

public enum Ruolo {
    
    ADMIN("Amministratore"),
    UTENTE("Utente");

    private final String nome;

    private Ruolo(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
