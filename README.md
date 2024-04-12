# TRENOCREATOR

Il progetto consiste in una Web App che da la possibilità all'utente di creare treni di vario tipo e nazionalità e cercare quelli creati da altri utenti,
implementando anche un algoritmo appositamente ottimizzato per la normalizzazione degli errori ortografici durante la creazione/ricerca degli stessi

### TECNOLOGIE IMPLEMENTATE

Il progetto è stato sviluppato utilizzando le seguenti tecnologie: Java (+JSP), JavaScript, Spring (+SpringBoot), Maven, Tomcat, MySQL, JPA (+Hibernate)

Inoltre segue i pattern architetturali: DAO e MVC

## INSTALLAZIONE

Per eseguire correttamente il progetto è necessario avere installata sulla macchina una versione recente di java e Maven,
prima di eseguire l'applicazione è necessario modificare i dati di accesso al database locale mysql nel file AppConfig.java ("\src\main\java\com\marcoarcarisi\demo\config")

Successivamente per avviare il progetto inserire il codice:

  ```
  mvn spring-boot:run
  ```

Il progetto sarà quindi disponibile all'indirizzo "http://localhost:8080/"

## ALGORITMO DI NORMALIZZAZIONE

Nel progetto è presenta un algoritmo di normalizzazione  (che ne integra di diversi tipi) ottimizzato per i vari casi d'uso,
che normalizza una stringa fornita in input ad una presente nel nostro Database.

Un'ulteriore ottimizzazione di questo algoritmo risiede nella creazione di una tabella <<AlgortimoUtilizzato>> all'interno del Database che permette di riutilizzare
risultati già ottenuti non dovendo rieseguire l'intero algoritmo, permettendo un risparmio di risorse e miglioramento delle prestazioni

<div align=center>
  <img width="700" alt="Senza titolo" src="https://github.com/scio97/IdmProgetto/assets/56976553/400c52e6-b284-4b10-926a-51ca24067c70">
</div>

## UTILIZZO

Una volta avviato il progetto, collegandosi via browser all'indirizzo specificato durante l'esecuzione (localhost:8080), sarà mostrata la pagina principale della webapp che
mostra le principali funzioni disponibili

<div align=center>
  <img width="750" alt="image" src="https://github.com/scio97/IdmProgetto/assets/56976553/404aa20a-e07a-4523-9725-e6cde269c799">
</div>

Le funzioni di creazione e ricerca dei treni sono disponibili solamente dopo aver effettuato la registrazione/accesso

La creazione di un treno avviene secondo la leggenda presente nella relativa pagina e permette di creare un trenop ed associarlo all'account con quale si è loggati

Nella pagina "treni da tutto il mondo" vengono visualizzati tutti i treni creati da tutti gli utenti, mentre in quella di "ricerca treno" solo quelli del paese inserito

Nella pagina profilo è possibile visualizzare i treni creati dall'utene loggato ed eventualmente eliminarli,
l'utente amministratore può vsualizzare ed eliminare i treni creati da qualsiasi utente.
