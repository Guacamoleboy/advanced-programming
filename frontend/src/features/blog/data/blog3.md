## Sortering

Afleveringsdato: 27. november 2026 kl. 12.00.

Jeg har beholdt Hillerød og omegn som eksempel fra portfolio 1. Denne gang sorterer jeg 12 steder efter deres afstand fra Hillerød. Afstandene er forenklede, så Esrum og Nødebo står begge til 9 km. Med navnene i arrayet kan jeg se, om de to bytter plads i forhold til hinanden, selv når afstandene ender i rigtig rækkefølge.

Jeg blander arrayet med samme seed hver gang og laver også en sorteret og en omvendt sorteret udgave. Hver algoritme får en kopi af den udgave, den skal køre på. I konsollen kan man følge trinnene på den blandede udgave og se tællingerne for alle tre.

## Bubble Sort

Jeg sammenligner to naboer og bytter dem, hvis den venstre har længst afstand. Efter første gennemløb ligger Gilleleje på 20 km på sin endelige plads. Konsollen viser den del, der stadig arbejdes på, og den del til højre, der allerede ligger rigtigt.

På det sorterede array stopper jeg efter 11 sammenligninger og 0 bytninger. På det omvendte bruger jeg 66 sammenligninger. Det tidlige stop gør bedste fald lineært, mens værste fald er O(n²). Esrum og Nødebo bliver i samme rækkefølge, fordi jeg kun bytter, når den venstre afstand er større.

## Merge Sort

Jeg deler arrayet i to, sorterer venstre halvdel, sorterer højre halvdel og fletter dem sammen. Indrykningen i udskriften viser, hvor langt nede i rekursionen jeg er. Man kan følge den venstre halvdel hele vejen ned og tilbage, før den højre begynder.

I `ArrayMerge` bruger jeg `<=`, så elementet fra venstre halvdel bliver valgt først, når afstandene er ens. Derfor står Esrum stadig foran Nødebo efter det blandede eksempel. Der er 30 sammenligninger i fletningerne for det eksempel. Sorteringen bruger O(n log n) tid og O(n) ekstra plads til halvdelene.

## Quick Sort

Jeg bruger sidste element som pivot i Lomuto-partitioneringen. Udskriften viser, hvor pivot ender, og hvor mange elementer der ligger på hver side. Når input allerede er sorteret, er sidste element det største. Med 12 steder fordeles de andre 11 derfor som 11 til venstre og 0 til højre i første trin. Det fortsætter på samme måde og giver O(n²) i værste fald.

Jeg prøvede også at flytte det midterste element hen på sidste plads før partitioneringen. På det sorterede array med 12 steder faldt antallet af sammenligninger fra 66 til 25. Da jeg udvidede det sorterede eksempel til 480 elementer, var tallene 114.960 og 3.346. I den blandede udgave ender Nødebo foran Esrum med sidste element som pivot. Bytningerne i partitioneringen kan altså ændre rækkefølgen ved samme afstand.

## Heap Sort

Jeg bygger en max-heap i selve arrayet. Børnene til en plads `i` ligger ved `2i + 1` og `2i + 2`. Roden er den største afstand, så jeg bytter den med det sidste element i heapen og genopretter heapen i den del, der er tilbage.

Jeg viser både arrayet og heapens niveauer i konsollen. Når Gilleleje er flyttet til enden, kan man se, at den stadig står i arrayet, mens træet er blevet et element mindre. Den blandede udgave bruger 54 sammenligninger, og også her ender Nødebo foran Esrum. Heap Sort har O(n log n) tid i værste fald og bruger kun konstant ekstra plads til sorteringen, når trinnene ikke udskrives.

## Valg undervejs

Jeg har holdt mig til konsollen, fordi jeg gerne vil kunne følge de samme navne fra linje til linje. I Bubble Sort giver det mening at se, hvor meget af arrayet der er færdigt. I Quick Sort kigger jeg mest på størrelsen af de to dele efter et pivotvalg. Hvis jeg skrev hver sammenligning ud, skulle jeg lede efter de to størrelser mellem alle de andre linjer. Derfor viser jeg trinnene på det lille eksempel og nøjes med tællingerne, når jeg skruer op for størrelsen.

Jeg har også lagt data og udskrift i egne klasser, ligesom i de andre portfolioer. Så kan jeg ændre rækkefølgen eller prøve en anden afstand ét sted og se, hvad det gør ved alle fire sorteringer. Tællingerne siger noget om arbejdet i algoritmen. Hvis jeg ville sammenligne køretid, ville jeg slå udskriften fra og måle den for sig.

## Hvad ville jeg vælge?

På det sorterede array laver Bubble Sort og Quick Sort med sidste pivot begge 0 bytninger. Alligevel bruger de henholdsvis 11 og 66 sammenligninger. Det er den forskel, jeg bedst kan bruge fra opgaven. Jeg skal både se på, hvordan data ligger til at begynde med, og på, hvad algoritmen gør med den rækkefølge.

Hvis jeg skulle sortere en liste over steder, hvor den oprindelige rækkefølge stadig skal gælde ved samme afstand, ville jeg vælge Merge Sort. Så bliver Esrum stående foran Nødebo, hvis det var den rækkefølge, de kom ind i. Hvis rækkefølgen ved samme afstand er ligegyldig, og jeg gerne vil holde pladsforbruget nede, giver Heap Sort mere mening.
