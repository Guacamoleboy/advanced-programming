# Grådig algoritme

Du skal lave en algoritme, som kan beregne hvor meget træ af forskellige længder vi skal bruge til at opnå en target-længde.
Find evt inspiration i `graphs.greedy.MoneyHandler`.

Vi har træ liggende i længderne 7, 5 og 2 meter. Så hvis vi skal bruge 12 meter, stykker vi det sammen af 7 og 5 meter.

Opgaven er nu

- Lav en klasse `WoodHandler` med metoden `List<Integer> calculateWood(int target)` som tager en target-længde som parameter
  og returnerer en liste af de længder, vi skal bruge. Fx vil `calculateWood(11)` returnere en liste med tallene 7, 2, 2. Din algoritme skal være grådig. 
- Hvis metoden ikke kan ramme target præcist, kan du lade den returnere det, der kommer tættest på (men ikke er mindre end target). Fx skal `calculateWood(13)` returnere
  7, 5, 2.
- Du kan også vælge at returnere `null` hvis metoden ikke kan ramme target præcist.

I hvilke tilfælde giver den grådige algoritme den bedst mulige løsning –
og i hvilke tilfælde kunne færre stykker være muligt med en anden strategi? Hvilken anden strategi kunne det være?

