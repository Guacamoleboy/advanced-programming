## Korteste vej fra Hillerød til Gilleleje

I den her opgave har jeg arbejdet med Dijkstra og A*. Jeg tog udgangspunkt i Signes eksempler, men brugte Hillerød og omegn i stedet for bogstaver og opdigtede bynavne. Der er otte byer med, blandt andet Gadevang, Nødebo og Esrum. Afstandene og kortene er forenklede til opgaven, så det er ikke en rutevejledning, man skal køre efter.

Opgaven er delt ud i `SoC` og `OOP` og køres fra `Main.java` via egne packages under `src/` for at gøre det nemmere for fremtidige opgaver. Det er et bevidst valg, og noget som jeg tænker hjælper mig mere med læring af reelt stof fremfor blot at spytte en opgave ud.

## Dijkstra

Vejnettet består af byer som noder og veje som vægtede, rettede kanter. Vægten er vejens længde i km. At vejen er rettet betyder, at en forbindelse fra Hillerød til Gadevang ikke automatisk giver en vej tilbage.

Jeg bruger to maps til `dist` og `prev` og et sæt til `visited`. `dist` gemmer den billigste kendte afstand fra start, mens `prev` gemmer byen, man kom fra. `visited` holder styr på de byer, der er valgt og besøgt. En `PriorityQueue` sørger for, at den billigste ubesøgte by bliver valgt først. Det er det grådige valg: den laveste samlede afstand lige nu.

En vigtig forskel er, at en by godt kan få opdateret sin afstand uden at være besøgt endnu. Nødebo får fx først afstanden 9 direkte fra Hillerød. Via Gadevang bliver den 2 + 3 = 5, og så ændres både `dist` og `prev`. Derfor stopper søgningen først, når målet vælges fra køen, og ikke bare når det dukker op som nabo.

Med de valgte afstande er den korteste rute Hillerød → Gadevang → Nødebo → Esrum → Græsted → Søborg → Gilleleje på 14 km. Dijkstra kræver, at vægtene ikke er negative, så det bliver kontrolleret, når en vej tilføjes.

## A*

A* bruger et grid på 8×8 med de samme byer. Her er nogle celler lukkede, og man kan gå op, ned, til venstre og til højre. Hvert skridt koster 1.

Forskellen ligger især i prioriteringen. Dijkstra bruger afstanden fra start, mens A* bruger `f = g + h`. `g` er afstanden fra start, og `h` er et skøn over afstanden til målet. Jeg bruger Manhattan-afstand, altså forskellen i rækker plus forskellen i kolonner. Den ser bort fra forhindringer, så den overvurderer ikke den resterende afstand i det her grid. A* kan dermed bruge målets placering til at styre søgningen.

## Struktur og valg undervejs

Undervejs flyttede jeg byer og kortopsætning ud af algoritmerne. `LocalMaps` opretter data, `City` beskriver en by, og `GridMap` holder styr på celler og naboer. Algoritmerne får kort, start og mål som parametre. Køposterne `NodeWithDist` og `NodeWithCost` ligger også i egne klasser. Det gør det lettere at finde rundt og ændre kortet uden at rode i søgningen.

Jeg droppede at tegne griddet, fordi jeg hellere ville følge beregningerne trin for trin. Det vigtigste for mig er at kunne se, hvorfor en node bliver valgt, og hvornår en billigere vej ændrer det, vi allerede ved.

## Læring om Grafer & korteste vej

Jeg har generelt OK forståelse for hvordan ting fungerer, og har bl.a. set en dokumentar omkring hvordan `Uber` beregner lokation og hvordan de opdaterer deres kort mm. Derfor var det ikke nyt som sådan, men jeg har bestemt lært noget, og tager det med videre i fremtiden hvis jeg på et tidspunkt skal benytte dette til en løsning.

I gymnasiet havde jeg `Mat A` hvorfor jeg som sådan ikke har noget mod beregninger eller tilsvarende herom.
Jeg har været lidt presset ift privatliv hvorfor løsningen nok også afspejler sig heraf. Jeg har lavet opgaven som jeg mener opgaven burde laves - `så den blot fungerer`. Den kunne godt have været lavet badre, større, mere effektiv og mere OOP.

Jeg har dog prioriteret `privatliv` lige i denne omgang hvorfor løsningen er som den er.

Forsøger at få frigjort noget tid i privaten hvorfor valgfaget kan fylde noget mere. Det bliver den næste periode brugt på. Der bliver læst op og undersøgt yderligere når jeg har tid til det.