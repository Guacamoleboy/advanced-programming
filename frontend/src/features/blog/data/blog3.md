## Sortering

Afleveringsdato: 27. november 2026 kl. 12.00.

Denne gang har jeg lavet bubble sort, merge sort og quick sort til et `int[]`. Signes eksempler sorterer studerende efter deres id. Jeg bruger i stedet en lille liste med forenklede afstandstal fra Hillerød og omegn, så jeg kan følge tallene uden at skulle holde styr på en masse objekter. Det er eksempeldata, ikke målte afstande.

Alle tre algoritmer får en kopi af samme array. Ellers ville merge sort og quick sort få et array, som bubble sort allerede havde sorteret, og så ville udgangspunktet være forskelligt.

## Bubble sort

Bubble sort sammenligner to naboer og bytter dem, hvis de står forkert. Efter en gennemløbning ligger det største tilbageværende tal på sin endelige plads til højre. Den ydre løkke styrer gennemløbningerne, mens den indre løkke sammenligner naboerne i den usorterede del.

I Signes kode bytter `Collections.swap()` to elementer i en liste. Det virker ikke på et `int[]`, så min løsning bruger en lille separat klasse til at bytte to arraypladser med en midlertidig variabel. Den del bruger quick sort også.

Min bubble sort stopper, hvis en gennemløbning ikke laver nogen bytninger. Et allerede sorteret array tager derfor O(n), men i gennemsnit og i værste fald er arbejdet O(n²).

## Merge sort

Merge sort deler arrayet i to, indtil hver del har højst ét tal. Det er basecasen: der er ikke noget at sortere i et tomt array eller et array med ét element. De sorterede halvdele flettes bagefter ved at vælge det mindste af deres næste tal.

Metoderne returnerer ikke et nyt array, fordi de skriver resultatet tilbage i det array, de får ind. Java sender en kopi af referencen, men begge referencer peger på det samme array.

Der er cirka log₂(n) niveauer og O(n) arbejde pr. niveau. Derfor er tiden O(n log n), også i værste fald. Til gengæld kræver løsningen O(n) ekstra plads til halvdelene.

## Quick sort og et dårligt pivotvalg

Jeg bruger sidste tal som pivot, ligesom i undervisningseksemplet. Partitioneringen placerer tal mindre end eller lig pivot til venstre, hvorefter pivot kommer på sin endelige plads. Rekursionen fortsætter på hver side uden at tage pivot med igen.

Her er det vigtigt, hvad der sker uden `Collections.shuffle()`. Hvis data allerede er sorterede, bliver sidste tal det største hver gang. Delingen bliver 0 og n−1 elementer i stedet for to nogenlunde lige store dele. Det giver O(n²) og en dyb rekursion, der på store arrays kan ende med `StackOverflowError`.

Jeg har beholdt det enkle pivotvalg for at kunne forklare den forskel. Programmet viser både et blandet og et sorteret eksempel i lille størrelse. Quick sort er typisk O(n log n), men det er ikke en garanti for alle input.

## Struktur

Hver algoritme har sin egen klasse i `portfolioThree`. Fletning, partitionering, bytning og eksempeldata ligger også hver for sig. `PortfolioThree` samler kørslen, mens den fælles `Main.java` kun vælger portfolio. Jeg kan dermed ændre tallene ét sted og køre alle tre sorteringer på samme input.
