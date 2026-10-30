Jeg valgte React til at bygge brugerfladen af genbrugelige komponenter og TypeScript for at gøre data og komponenternes forventninger tydeligere.

## Komponenter og data

Forsiden viser en liste over indlæg fra `posts.ts`. Hvert kort bruger samme markup og CSS, men får titel, beskrivelse og kategori fra sit eget dataobjekt. Det gør det enkelt at tilføje et indlæg uden at kopiere hele kortets kode.

React Router håndterer adresserne. Forsiden ligger på `/`, og hvert indlæg får sin egen sti under `/posts/`. Dermed kan et indlæg åbnes direkte via et link og stadig høre til samme lille app.

## TypeScript i praksis

TypeScript arbejder sammen med editoren og byggeværktøjet om at opdage uoverensstemmelser i koden. Det er især nyttigt, når data sendes mellem komponenter, fordi fejl i feltnavne og værdier kan opdages tidligere.
