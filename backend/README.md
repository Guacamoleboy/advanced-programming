# Backend

Selvstændigt Maven-projekt til Java-opgaver og lærerens eksempler. Projektet bruger
Java 17 og JUnit 5 med faste dependency- og pluginversioner.

## Kør fra IntelliJ IDEA

1. Åbn eller importér `backend/pom.xml` som Maven-projekt, og indlæs Maven-ændringerne.
2. Vælg JDK 17 som projektets SDK og Maven JDK.
3. Kør `src/main/java/Main.java` med kørselsmappen (Working directory) sat til
   `backend/`-mappens absolutte sti. Hvis hele repositoryet er åbent som projekt,
   kan du bruge `$PROJECT_DIR$/backend`.

`Main.java` kalder nu `portfolioOne.PortfolioOne`, som kører Dijkstra og A*.
Byer, veje og gridlayout defineres i `portfolioOne/LocalMaps.java`.
Tilføj eller skift kald til opgaverne i `Main`, efterhånden som du laver dem.

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
