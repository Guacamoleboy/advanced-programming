Indlæggenes tekst er skrevet i Markdown og gemt som separate `.md`-filer. React importerer filerne som tekst, og `react-markdown` omsætter overskrifter og afsnit til HTML-elementer.

## Indhold adskilt fra visning

Teksten bliver importeret i `posts.ts` og knyttet til metadata som titel, kategori og læsetid. Komponenten for en artikel viser derefter indholdet gennem `ReactMarkdown`.

Det giver en enkel arbejdsgang: selve teksten kan redigeres i Markdown, mens React-komponenten tager sig af siden omkring den. CSS bestemmer, hvordan de genererede overskrifter og afsnit ser ud.

## En begrænset løsning

Indlæggene er en del af appen ved build-tidspunktet. Det passer til et lille, statisk kursusprojekt, hvor indholdet ikke skal opdateres gennem et administrationssystem eller en database.
