# Spring-Concerti
Progetto di gruppo per l'esame del corso di Sistemi Informativi su Web

# Tecnologie utilizzate nel progetto
> Front-End
* [Thymeleaf](https://www.thymeleaf.org) Tecnologia di natural templating per l'interazione tra Utente e Sistema.
* [Bootstrap](https://getbootstrap.com) Framework CSS.
* [Font-Awesome](https://fontawesome.com) Framework per le Icone

> Back-End
* [PostgreSQL](https://www.postgresql.org) Database Relazionale ad Oggetti per la gestione della persistenza
* [H2](https://www.h2database.com/html/main.html) Database Relazionale Embedded per il Testing
* [Spring](https://spring.io) Framework Java per la realizzazione di Applicazioni Web

# Contesto
Si vuole realizzare un Sistema Web per una piccola biglietteria online che offre biglietti per i concerti in tutta italia

L'amministrazione si occupa di gestire i concerti, crearne di nuovi e impostare i biglietti disponibili a tali concerti.

L'utente, previa autenticazione, può prenotare, se disponibile un biglietto per un concerto a sua scelta

## Obiettivi
Realizzare un'Applicazione web in Springboot e HTML+CSS per soddisfare le necessità del contesto di riferimento, con l'implementazione dei casi d'uso sotto riportati

## Casi d'uso
> Caso d'uso UC1: Iscrizione Nuovo Utente - Attore Primario: Utente Anonimo

Un utente Anonimo usa il sistema per iscriversi come Utente per potere effettuare le prenotazioni. Il Sistema salva il nuovo Utente nel DBMS

> Caso d'uso UC2: Effettua Prenotazione - Attore Primario: Utente Autenticato

L'Utente seleziona il concerto a cui vuole prenotare un biglietto, seleziona il biglietto che più preferisce. Il Sistema crea una nuova prenotazione per quel biglietto. La disponibilità per quel biglietto viene decrementata di 1 dal Sistema

> Caso d'uso UC3: Annulla Prenotazione - Attore Primario: Utente Autenticato

L'Utente seleziona una delle sue prenotazioni, il Sistema cancella la prenotazione per quel biglietto e incrementa di 1 la quantità disponibile per quel biglietto

> Caso d'uso UC4: Affilia Luogo - Attore primario: Amministratore

L'amministratore seleziona la voce per la creazione di un luogo e il sistema gli mostra la form per l'inserimento dei dati del luogo e successivamente il sistema validerà tali dati e li salva nel database.

> Caso d'uso UC5: Organizza concerto - Attore primario: Amministratore

L'Amministratore seleziona la voce per organizzare un nuovo concerto, il sistema mostrerà la form per l'inserimento dei dati del concerto e la selezione del gruppo musicale e del luogo dedicato a tale concerto, il sistema validerà i dati e salverà le informazioni nel Database, successivamente il sistema mostrerà la form per la creazione dei biglietti, l'Amministratore inserisce i dati dei tipi di biglietto, il sistema valida e salva tutto nel Database.

> Caso d'uso UC6: Modifica concerto - Attore primario: Amministratore

L'amministratore seleziona la voce per modificare un concerto già esistente, il sistema mostrerà la form per la modifica dei dati del concerto, l'Amministratore inserirà le dovute modifiche, il sistema validerà tali modifiche e aggiorna il concerto nel Database.

> Caso d'suo UC7: Cancella concerto - Attore primario: Amministratore

L'amministratore seleziona la voce per cancellare un concerto esistente, il Sistema cancella il concerto è tutti i biglietti a esso affiliati.

> Caso d'uso UC8: Ricerca concerto - Attore primario: Utente Autenticato

L'utente immette i parametri di ricerca attraverso una form, il Sistema ricerca all'interno del Database tutti i concerti che rispecchiano tali vincoli di ricerca e li mostra all'utente
