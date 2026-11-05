# Søgning i grafer

## 1. BFS

Kig på klassen `graphs.graphsearch.SearchStrategies`. I klassen er metoden `searchBFS(..)`.

Din opgave er

- Tegn den graf, der laves i `main`
- Gå metoden `searchBFS(..)` igennem linje for linje og forklar for din sidemakker hvad den gør.
- Tegn indholdet af køen for hver iteration.
- Overvej hvad det betyder, at vi bruger `Queue` som referencetype.
- Er grafen rettet eller urettet? Sammenlign med `undirectedgraphs.Node`.
- Er kanterne vægtede eller uvægtede?

## 2. DFS

Kig på klassen `graphs.graphsearch.SearchStrategies`. I klassen er metoden `searchDFS(..)`.

Din opgave er

- Gå metoden `searchDFS(..)` igennem linje for linje og forklar for din sidemakker hvad den gør.
- Tegn indholdet af stakken for hver iteration.
- Overvej hvad det betyder, at vi bruger `Deque` som referencetype.

Bonusspørgsmål: 
- Hvorfor kan vi bruge `ArrayDeque` som både stak og kø?
- Hvad sker der, hvis du skriver `stack.add(neighbor)` i stedet for `stack.push(neighbor)`?

## 3. Implementer din egen BFS og DFS

Kig på klasserne `graphs.treesearch.Node` og `graphs.treesearch.SearchStrategies`. Her arbejder vi med et træ. I stedet for `getNeighbors()` bruger vi `getChildren()` — men traverserings-logikken er den samme.

Din opgave er nu

- Implementer metoderne `searchBFS(..)` og `searchDFS(..)`.
- Hent inspiration i `graphs.graphsearch.SearchStrategies`. Du skal ikke kopiere koden, men forstå hvordan der traverseres og gøre det samme for træer.

## Bonus: Cycle detection

I grafer kan der opstå cyklusser. Det kan der ikke i træer, som per definition er acykliske.

Kig på klassen `graphs.graphsearchcycles.CycleDetector` og se hvordan vi bruger DFS med et sæt (`inPath`) til at detektere cyklusser i rettede grafer.

- Gå koden igennem linje for linje og forklar hvad `inPath` holder styr på.
- Hvad sker der når vi backtracker? Hvorfor fjernes noden fra `inPath`?
- Tegn indholdet af inPath for hvert kald. 
- I den første graf besøges C to gange. Hvorfor er det ikke en cyklus, og hvorfor ville det give et forkert svar, hvis vi aldrig fjernede noder fra sættet?
- Kør koden i debug mode og se om du havde ret i hvad der skete. Sæt evt. nye breakpoints.
- Byg din egen graf i main, én med og én uden cyklus, og test om `CycleDetector` svarer rigtigt.
