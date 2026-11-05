# Kompleksitet

## 1. Leg med kompleksitet

- Kig på klassen `complexity.BigOExamples`, som viser eksempler på fire forskellige kompleksiteter. Kør `main` og se de forskellige metoder
  performe. Prøv at skifte værdien af `n` og observer effekten.
- Kig på metoden `testComplexity()` i klassen `complexity.Main`. Her kaldes de samme metoder fra `BigOExamples` og deres
  performance måles med tidsstempler. Kald metoden fra `main` og se forskellen i tid.

## Lav et simpelt, komplekst program

- Lav fire metoder i en ny klasse eller i klassen `BigOExamples`. Hver metode skal have én af følgende kompleksiteter:
  O(1), O(log n), O(n) og O(n²). Du bestemmer selv, hvad metoderne skal gøre, men hold dem simple.
- Byt kode med en anden. Analyser hinandens kode og identificer kompleksiteten for hver enkelt metode.
  Begrund dit svar: Hvad sker der med arbejdet, hvis n bliver 1000 gange større?