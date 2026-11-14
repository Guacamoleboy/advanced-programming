## Backtracking

Afleveringsdato: 4. december 2026 kl. 12.00.

## Find en vej, og gå tilbage når den stopper

I portfolio 1 handlede det om den korteste vej mellem byer. Denne gang er målet bare at finde en vej gennem en labyrint. Jeg har valgt mit eget lille layout, hvor der er en blindgyde tidligt på turen, så jeg kan forklare selve tilbageskridtet.

Labyrinten er et array med seks rækker og seks kolonner. `1` er et åbent felt, og `0` er en mur. Starten er `(0,0)`, og målet er nederste højre hjørne, altså `(5,5)`. Målet beregnes ud fra arrayets størrelse, så jeg ikke skal rette koordinaterne inde i algoritmen, hvis jeg ændrer layoutet.

## Selve rekursionen

For hvert felt kontrollerer algoritmen først grænser, mur og om feltet allerede er med i den aktuelle sti. Derefter markeres feltet i et separat `path`-array. Er vi ved målet, returneres `true`.

Ellers prøves ned, højre, op og venstre. Hvis ingen retninger fører til målet, sættes feltets markering tilbage til `0`, og kaldet returnerer `false`. Så kan det forrige kald prøve sin næste mulighed.

I mit layout går den første tur ned til `(3,0)` og videre til `(3,2)`, hvor der ikke er mere vej. De felter bliver fjernet fra stien igen. Tilbage ved `(1,0)` kan algoritmen i stedet prøve højre og komme videre mod målet. Resultatet har 13 markerede felter, altså 12 skridt.

Markeringen gælder den aktuelle sti, ikke alle felter, der nogensinde har været besøgt. Det forhindrer, at samme felt bruges to gange på én rute, men tillader, at et felt undersøges igen via en anden rute.

## Forskel fra den korteste vej

Programmet finder den første gyldige rute i den valgte rækkefølge. Det lover ikke den korteste. Det er en vigtig forskel fra Dijkstra og A*. Hvis jeg skulle finde den korteste vej i den her labyrint med ens pris pr. skridt, ville BFS være et oplagt valg.

Data, søgning og udskrift ligger i hver sin klasse under `portfolioFour`. Jeg udskriver kun den fundne sti som nuller og ettaller. Dermed kan jeg sammenligne den med layoutet og se, at blindgyden er væk, mens selve labyrinten stadig er uændret.
