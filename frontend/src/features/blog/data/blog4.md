Siden skal kunne læses både på en bred skærm og på en telefon. Derfor tilpasses kortenes kolonner og afstande med CSS media queries.

## Fleksibelt layout

På brede skærme vises indlægskortene i to kolonner. Når vinduet bliver smallere, skifter gitteret til én kolonne. Det holder kortene brede nok til, at titler og beskrivelser kan læses uden at blive klemt.

Overskrifter bruger `clamp()` til at vokse med skærmbredden inden for en fast minimums- og maksimumsstørrelse. Indholdsområdet har samtidig en maksimal bredde, så tekstlinjerne ikke bliver for lange.

## Læsbarhed først

Jeg har holdt farverne neutrale og sørget for tydelig kontrast mellem tekst, baggrund og kort. Layoutet bruger almindelige systemskrifttyper, så siden ikke er afhængig af at hente skrifter fra en ekstern tjeneste.
