# Svære eksempler – vejledende løsninger

Til klassen `complexity.HardBigOExamples` og `complexity.GraphComplexityDemo`.

## HardBigOExamples

| # | Metode | Kompleksitet | Hvorfor |
|---|---|---|---|
| 1 | `sumTwice` | O(n) | To løkker *efter* hinanden giver 2n skridt. Konstanten smides væk. Det er ikke O(n²) – det kræver løkker *inde i* hinanden. |
| 2 | `sumFirstTen` | O(1) | Løkken kører højst 10 gange, uanset hvor stort arrayet er. At der er en løkke, betyder ikke, at det er O(n). |
| 3 | `sumFirstHalf` | O(n) | n/2 skridt. At gå halvdelen igennem er stadig lineært. Det er ikke O(log n) – det kræver, at vi halverer *igen og igen*. |
| 4 | `countPairs` | O(n²) | Den indre løkke starter ved `i + 1`, så der er ca. n²/2 sammenligninger. Halvdelen af n² er stadig O(n²). |
| 5 | `countCommon(List, List)` | O(n · m) | `contains` på en liste er selv en lineær søgning. Kompleksiteten gemmer sig i biblioteket. Er listerne lige store, er det O(n²). |
| 6 | `countCommon(List, Set)` | O(n) | `contains` på et `HashSet` er O(1). Samme kode som nr. 5 – kun datastrukturen er skiftet. |
| 7 | `doublingInside` | O(n log n) | Den ydre løkke kører n gange. Den indre fordobler `j` og kører derfor log n gange. |
| 8 | `fibonacci` | O(2ⁿ) | Hvert kald laver to nye kald, så antallet af kald fordobles (næsten) for hvert trin. `fibonacci(50)` når I ikke at se blive færdig. |

**Gode spørgsmål til opsamlingen**

- Nr. 1 vs. nr. 4: Hvad er forskellen på løkker efter hinanden og løkker inde i hinanden?
- Nr. 3 vs. `logTime` i `BigOExamples`: Hvorfor er "halvdelen" ikke det samme som "halvér"?
- Nr. 5 vs. nr. 6: Samme kode, forskellig kompleksitet. Hvad har skiftet?

## Kompleksitet for BFS og DFS

### Med `visited` (den klassiske version)

Begge er **O(V + E)**: hver node besøges én gang, og hver kant kigges på én gang.

I et træ er E = V − 1, så det bliver **O(n)**.

### Uden `visited` (som i `graphs.graphsearch.SearchStrategies`)

| Graf | Kompleksitet |
|---|---|
| Træ | O(n) – der er kun én vej til hver node |
| Graf hvor veje mødes (fx diamanter) | En node besøges én gang **per vej** dertil. Kan blive eksponentielt. |
| Graf med cyklus (fx `E.addNeighbor(A)`) | Stopper aldrig |

Kør `GraphComplexityDemo`: 61 noder giver over 4 millioner besøg uden `visited` og 61 besøg med. Det er `visited`, der gør algoritmen til O(V + E).

### Samme tid – forskellig hukommelse

BFS og DFS har samme tidskompleksitet. Forskellen er, hvad der ligger i køen og stakken undervejs:

- **BFS** har hele det næste niveau i køen. I et balanceret binært træ er det nederste niveau ca. halvdelen af noderne, så køen kan blive **O(n)**.
- **DFS** følger én gren ad gangen. Stakken vokser med dybden – i et balanceret træ **O(log n)**.

Derudover finder BFS altid den korteste vej (færrest kanter) i en uvægtet graf. Det gør DFS ikke.

**Spørgsmål til de studerende:** Hvis BFS og DFS har samme kompleksitet, hvorfor har vi så to algoritmer?
