## Kompleksitet og datastrukturer

Afleveringsdato: 21. november 2026 kl. 12.00.

I portfolio 1 brugte jeg en `PriorityQueue` til at vælge næste by. Nu handler det om, hvad operationerne koster. Jeg sammenligner lister med 500.000 heltal, søgning i en liste og et sæt samt `TreeSet` og `HashSet` med egne objekter.

## ArrayList og LinkedList

Begge implementerer `List`, men det gør dem ikke lige hurtige. En `ArrayList` gemmer elementerne i et array, så `get(250000)` kan slå direkte op på en plads. En `LinkedList` skal følge kæden af noder for at finde samme element.

Det er også forklaringen på, at indsættelse i midten af en hægtet liste ikke bare er O(1), når kaldet er `add(250000, 99)`. Selve ændringen af forbindelserne er billig, men pladsen skal findes først. Derfor er hele kaldet O(n). En `ArrayList` finder pladsen direkte, men skal flytte elementerne efter den.

Forrest i listen er forskellen mere enkel: `LinkedList` kan sætte en ny node ind i O(1), mens `ArrayList` flytter de eksisterende elementer. Opgavens 10.000 indsættelser gør den forskel lettere at undersøge.

## Søgning og egne objekter

Jeg søger efter det første tal, det sidste tal og et tal, der ikke findes. Listen stopper ved første match, mens `HashSet` bruger en hashværdi til at finde det relevante sted. For listen er både det sidste og det manglende tal worst case: alle 500.000 elementer skal undersøges.

Til objekterne har jeg valgt opgaver fra vores valgfag på 4. semester. Hver opgave har et nummer og en titel. Nummeret bestemmer identiteten i både `compareTo`, `equals` og `hashCode`. Derfor opfattes samme opgavenummer som samme objekt i begge sæt, også når jeg søger med en ny instans. `TreeSet` holder orden efter nummer; `HashSet` lover ingen rækkefølge.

## Målinger og forventninger

Programmet bruger `System.nanoTime()` og kører tre runder, hvor den første er opvarmning. Hurtige opslag gentages, og tiderne udskrives sammen med antal operationer. Oprettelse af data og konsoludskrift ligger uden for selve målingen.

I anden runde tog 100 opslag i midten cirka 0,032 ms med `ArrayList` og 49,5 ms med `LinkedList`. De 10.000 indsættelser forrest tog cirka 462 ms mod 0,323 ms. Det er samlede tider, ikke tid pr. operation. Midterindsættelsen var også hurtigere i `ArrayList` i den kørsel, selvom begge kald er O(n). Det hænger sammen med, at arrayet kan flytte en sammenhængende blok, mens den hægtede liste først skal følge mange referencer.

Tiderne svinger mellem runderne. JVM-opvarmning og garbage collection kan påvirke dem, og én datastørrelse er ikke nok til at udlede Big O. Jeg bruger derfor målingerne til at sammenligne de konkrete kald og teorien til at forklare, hvordan arbejdet vokser.

## Køen fra portfolio 1

En `PriorityQueue` skal bevare en heap, så indsættelse og udtagning af det mindste element koster O(log n). En `ArrayDeque` bruges i enderne: som kø er det først ind, først ud, og som stak er det sidst ind, først ud. Indsættelse er amortiseret O(1), fordi arrayet indimellem skal udvides. Udtagning fra enderne er O(1).

Det giver mig en bedre forklaring på valget fra portfolio 1: Dijkstra har brug for den billigste kendte afstand som næste element, ikke bare den by, der blev lagt i køen først.
