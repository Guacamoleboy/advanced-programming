# Backend

Selvstændigt Maven-projekt til Java-opgaver og lærerens eksempler. Projektet bruger
Java 17 og JUnit 5 med faste dependency- og pluginversioner.

## Kør fra IntelliJ IDEA

1. Åbn eller importér `backend/pom.xml` som Maven-projekt, og indlæs Maven-ændringerne.
2. Vælg JDK 17 som projektets SDK og Maven JDK.
3. Kør `src/main/java/Main.java` med kørselsmappen (Working directory) sat til
   `backend/`-mappens absolutte sti. Hvis hele repositoryet er åbent som projekt,
   kan du bruge `$PROJECT_DIR$/backend`.

`Main.java` kalder som standard `portfolioOne.PortfolioOne`, som kører Dijkstra og A*.
Vælg en anden portfolio ved at kommentere det aktive kald ud og fjerne `//` foran
det ønskede kald. `Main` indeholder kun kald, mens data og løsninger ligger i hver package:

- `portfolioOne`: Dijkstra og A* med lokale byer.
- `portfolioTwo`: målinger af lister, søgning og sæt.
- `portfolioThree`: bubble sort, merge sort og quick sort på heltalsarrays.
- `portfolioFour`: backtracking i en labyrint.
- `portfolioFive`: tom startklasse, der afventer Signes opgavetekst.

Kørselsmappen er vigtig: nogle af lærerens eksempler læser `data/Students.txt`
med en relativ sti. Opgaveskabelonerne er bevaret, så ufærdige opgaver stadig skal
implementeres, før de giver det forventede resultat.

## Kør med Maven

Med JDK 17 og Maven installeret kan du køre `Main` fra `backend/`:

```powershell
cd backend
mvn compile exec:java
```

Kør de eksisterende JUnit-tests med `mvn test` fra samme mappe.

## Tilføj en opgave

Placér Java-klasser under `src/main/java/` i en passende package og tests under
`src/test/java/`. `Main.java` ligger i roden af Java-kildemappen uden package.
Tilføj kald til dine opgaver direkte i dens `main`-metode undervejs.
