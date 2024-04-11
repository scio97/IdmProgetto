# TRENOCREATOR

Il progetto consiste in una Web App che da la possibilità all'utente di creare treni di vario tipo e nazionalità e cercare quelli creati da altri utenti,
implementando anche un algoritmo appositamente ottimizzato per la normalizzazione degli errori ortografici durante la creazione/ricerca degli stessi

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

