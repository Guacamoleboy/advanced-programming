En praktisk reference til syntaksen, hvordan indlæg vises på denne side, og hvilke udvidelser der kræver ekstra plugins. Kopiér de dele, du skal bruge, ind i et nyt indlæg under `src/features/blog/data/`.

## Sådan virker det her projekt

Hvert indlæg er en `.md`-fil, som importeres som rå tekst i `src/features/blog/data/posts.ts`. React-komponenten renderer teksten med `ReactMarkdown` i `src/app/pages/BlogPostPage.tsx`:

```tsx
import ReactMarkdown from 'react-markdown'

<ReactMarkdown>{post.content}</ReactMarkdown>
```

`react-markdown` understøtter CommonMark som standard. Dette projekt har ikke automatisk GFM-tabeller, task lists eller gennemstreget tekst aktiveret. De eksempler er markeret som GFM nedenfor og kræver `remark-gfm`.

## Grundlæggende Markdown

### Overskrifter

Sæt et mellemrum efter `#`. Brug overskrifter i rækkefølge, så dokumentet har en logisk struktur.

```md
# Sidens titel

## Afsnit

### Underafsnit

#### Mindre underafsnit
```

Markdown-heading-niveauer går fra `#` til `######`. Brug normalt én H1-titel per artikel, og lad første egentlige afsnit være H2.

### Afsnit og linjeskift

En tom linje starter et nyt afsnit:

```md
Dette er første afsnit.

Dette er et nyt afsnit.
```

Et almindeligt linjeskift inde i et afsnit bliver normalt vist som et mellemrum. Hvis du faktisk har brug for et linjeskift, kan du sætte to mellemrum til sidst på linjen eller bruge `\` før linjeskiftet. Til almindelig tekst er et nyt afsnit oftest mere læsbart.

### Fremhævning og inline-kode

```md
*Kursiv* eller _kursiv_
**Fed** eller __fed__
***Fed og kursiv***
~~Gennemstreget tekst~~ (GFM)
Brug `inline-kode` til korte navne og udtryk.
```

Undgå at bruge fed tekst som erstatning for overskrifter.

### Lister

Uordnet liste:

```md
- Første punkt
- Andet punkt
  - Indlejret punkt
  - Endnu et indlejret punkt
- Sidste punkt
```

Nummereret liste:

```md
1. Første trin
2. Andet trin
3. Tredje trin
```

Markdown justerer normalt nummereringen ud fra den første værdi, men det er mest overskueligt at skrive `1.` på alle punkterne. Indryk indlejrede punkter med to eller fire mellemrum, og brug samme indrykning i hele listen.

### Citatblokke

```md
> Dette er et citat.
>
> En tom citatlinje adskiller afsnit i citatet.

> Citat kan indeholde **formatering** og lister:
>
> - Første punkt
> - Andet punkt
```

### Kodeblokke

Brug tre backticks før og efter kodeblokken. Skriv gerne sprognavnet efter de første tre backticks:

````md
```ts
const course = 'Advanced Programming'
console.log(course)
```
````

Andre almindelige sprogmarkører er `js`, `jsx`, `tsx`, `css`, `html`, `json`, `bash`, `sh`, `sql`, `python`, `java` og `text`. Markøren giver parseren et sprognavn, men `react-markdown` farvelægger ikke kode automatisk. Syntax highlighting kræver en highlighter eller et rehype-plugin og tilhørende styles.

Hvis koden selv indeholder tre backticks, så brug fire backticks til den ydre Markdown-hegn:

`````md
````md
```js
console.log('hegn inden i hegn')
```
````
`````

### Horisontal streg

En tom linje omkring en horisontal streg gør strukturen tydelig:

```md
Tekst før stregen.

---

Tekst efter stregen.
```

### Links

Inline-link:

```md
[React Markdown dokumentation](https://github.com/remarkjs/react-markdown)
```

Link med valgfri titel:

```md
[CommonMark](https://commonmark.org "CommonMark-projektet")
```

Reference-link er praktisk, hvis samme kilde bruges flere steder:

```md
Se [React Markdown][react-markdown] og [CommonMark][commonmark].

[react-markdown]: https://github.com/remarkjs/react-markdown
[commonmark]: https://commonmark.org
```

Skriv meningsfuld linktekst, så det fremgår, hvor linket fører hen. Undgå “klik her”.

### Billeder

```md
![Kort beskrivelse af grafen](./images/graf.png)
```

Alt-teksten beskriver billedets information. Et rent dekorativt billede kan have tom alt-tekst: `![](url)`, men brug det kun, når billedet ikke tilfører indhold. React Markdown importerer ikke automatisk relative billedfiler fra en Markdown-fil. Brug en URL, der kan åbnes fra sitet, eller importér asseten i React og map billedet via en custom `img`-komponent.

### Escaping af specialtegn

Sæt en backslash før et tegn, som ellers har Markdown-betydning:

```md
\*Dette vises med asterisker omkring teksten.\*
\# Dette er ikke en overskrift
\[Dette bliver ikke til et link\]
```

## GitHub Flavored Markdown (GFM)

GFM er en udvidelse af CommonMark, ikke en del af den grundlæggende Markdown-syntaks. I React skal plugin'et installeres og gives til `remarkPlugins`:

```bash
npm install remark-gfm
```

```tsx
import ReactMarkdown from 'react-markdown'
import remarkGfm from 'remark-gfm'

<ReactMarkdown remarkPlugins={[remarkGfm]}>
	{post.content}
</ReactMarkdown>
```

### Tabeller (GFM)

```md
| Algoritme | Tid | Ekstra plads |
| --- | ---: | :---: |
| Insertion sort | O(n²) | O(1) |
| Merge sort | O(n log n) | O(n) |
```

Kolonner kan justeres med kolon i separatorrækken:

- `:---` venstrejusteret
- `---:` højrejusteret
- `:---:` centreret

Hold tabeller små. På smalle skærme kan brede tabeller kræve vandret scrolling eller en anden præsentation.

### Task lists (GFM)

```md
- [x] Emne gennemgået
- [ ] Eksempel tilføjes
```

Task list checkboxes er visning, ikke automatisk gemt app-state. Redigér markeringen i Markdown-filen.

### Gennemstreget tekst (GFM)

```md
~~Denne tekst er markeret som forældet.~~
```

### Autolinks og e-mail (GFM)

Med `remark-gfm` kan almindelig URL eller e-mailadresse blive til et link:

```md
https://react.dev
contact@example.com
```

Linket kan stadig skrives eksplicit med `[tekst](url)`, som ofte giver bedre tilgængelighed.

### Fodnoter (GFM)

```md
Markdown har flere udvidelser.[^gfm]

[^gfm]: Fodnoter understøttes her af remark-gfm.
```

## React Markdown i React

### Importér en Markdown-fil som tekst

Dette projekt bruger Vites `?raw`-import:

```ts
import graphNotes from './blog1.md?raw'

const post = {
	slug: 'grafer-og-korteste-vej',
	title: 'Grafer og korteste vej',
	content: graphNotes,
}
```

Render indholdet som børn af komponenten:

```tsx
<ReactMarkdown>{post.content}</ReactMarkdown>
```

Brug en streng som `children`. Skriv ikke flerlinjet Markdown direkte mellem JSX-tags: JSX samler linjeskift og mellemrum, så Markdown-strukturen kan gå tabt.

### Custom komponenter

`components` lader dig erstatte de HTML-elementer, som Markdown normalt genererer. Det er nyttigt for CSS-moduler, interne links, billedregler eller kodeblokke:

```tsx
<ReactMarkdown
	components={{
		h2: ({ children }) => <h2 className={styles.markdownHeading}>{children}</h2>,
		blockquote: ({ children }) => (
			<blockquote className={styles.quote}>{children}</blockquote>
		),
		a: ({ href, children }) => <a href={href}>{children}</a>,
	}}
>
	{post.content}
</ReactMarkdown>
```

Komponenterne får de almindelige HTML-props for elementet og en `node`-prop fra syntaxtræet. Destrukturér kun de props, du skal bruge, og videregiv resten, når elementets standardattributter stadig skal virke.

Ofte nyttige mappings:

| Markdown | HTML-tag / React Markdown key |
| --- | --- |
| `# Overskrift` | `h1` |
| `[link](url)` | `a` |
| `![alt](url)` | `img` |
| `> citat` | `blockquote` |
| `` `kode` `` | `code` |
| Kodehegn | `pre` og `code` |
| GFM tabel | `table`, `thead`, `tbody`, `tr`, `th`, `td` |

### React Markdown props

De mest brugte props på `<ReactMarkdown>`:

- `children`: Markdown-strengen, der skal renderes.
- `remarkPlugins`: plugins, der udvider eller ændrer Markdown-parsningen, for eksempel GFM.
- `rehypePlugins`: plugins, der bearbejder HTML-lignende syntaxtræ efter Markdown er konverteret.
- `components`: mapping fra genererede HTML-tags til React-komponenter.
- `skipHtml`: ignorér rå HTML-noder i Markdown.
- `allowedElements` / `disallowedElements`: tillad eller filtrér genererede elementer. Brug kun én af listerne ad gangen.
- `allowElement`: ekstra filterfunktion til elementer.
- `urlTransform`: tilpas link- og billed-URL'er; bevar sikre protokolregler.
- `unwrapDisallowed`: behold indholdet fra et filtreret element uden selve elementet.

### Sikkerhed og rå HTML

`react-markdown` renderer gennem React og er sikker som udgangspunkt. Rå HTML i en `.md`-fil bliver normalt escaped; `skipHtml` kan få HTML ignoreret helt. Undgå `dangerouslySetInnerHTML` for blogindhold.

Hvis der er et konkret behov for at fortolke rå HTML, kræver det `rehype-raw`. Brug kun betroet indhold. Hvis indholdet kan komme fra brugere eller andre ikke-betroede kilder, tilføj også `rehype-sanitize` efter `rehype-raw`, så resultatet bliver renset efter HTML-parsningen:

```bash
npm install rehype-raw rehype-sanitize
```

```tsx
import rehypeRaw from 'rehype-raw'
import rehypeSanitize from 'rehype-sanitize'

<ReactMarkdown rehypePlugins={[rehypeRaw, rehypeSanitize]}>
	{post.content}
</ReactMarkdown>
```

Plugins og custom komponenter er også en del af sikkerhedsgrænsen. Gennemgå dem, før de bruges på indhold, andre kan redigere.

## Valgfrie udvidelser

Disse muligheder er ikke installeret eller aktiveret i det nuværende projekt. Tilføj kun pakker, hvis blogindholdet får brug for funktionaliteten.

### Matematik med LaTeX

Brug `remark-math` til at parse matematik og enten `rehype-katex` eller `rehype-mathjax` til at vise den:

```bash
npm install remark-math rehype-katex katex
```

```tsx
import rehypeKatex from 'rehype-katex'
import remarkMath from 'remark-math'
import 'katex/dist/katex.min.css'

<ReactMarkdown
	remarkPlugins={[remarkMath]}
	rehypePlugins={[rehypeKatex]}
>
	{String.raw`Einstein: $E = mc^2$

$$
\sum_{i=1}^{n} i = \frac{n(n+1)}{2}
$$`}
</ReactMarkdown>
```

KaTeX kræver sin stylesheet. `String.raw` gør det nemmere at bevare backslashes i JavaScript-template strings.

### Syntax highlighting

Sprognavnet efter et kodehegn ender typisk som en `language-*`-klasse på `<code>`. Det giver en highlighter eller CSS mulighed for at markere tokens:

````md
```ts
const answer: number = 42
```
````

`react-markdown` giver i sig selv semantiske `<pre><code>`-elementer, men farver ikke syntaksen. En mulighed er et custom `code`-element via `components`; en anden er et rehype-plugin som `rehype-highlight`. Følg plugin'ets egen dokumentation og importer den nødvendige theme-CSS.

### Overskrifts-ID'er og indholdsfortegnelse

Markdown skaber ikke nødvendigvis anker-ID'er i den nuværende side. `rehype-slug` kan tilføje ID'er til overskrifter, og et rehype-toc-plugin kan bygge en indholdsfortegnelse. Kontroller ID-konflikter, gentagne overskrifter og links, før du bruger ankre.

### Frontmatter

YAML-frontmatter er metadata øverst i en fil:

```yaml
---
title: Eksempel
date: 2026-10-31
---
```

Frontmatter er ikke almindelig CommonMark. `ReactMarkdown` gør ikke automatisk disse felter til sidemetadata. I dette projekt ligger titel og slug i `posts.ts`; hvis metadata senere flyttes til `.md`, kræver det en frontmatter-parser som `remark-frontmatter` og kode til at læse felterne.

### Bløde linjeskift

Standard Markdown behandler et enkelt linjeskift i et afsnit som et mellemrum. Hvis hvert linjeskift skal blive til et HTML-linjeskift, kan `remark-breaks` ændre den adfærd. Brug det kun, hvis det passer til skriveformen; afsnit med tom linje er som regel lettere at læse.

### Mermaid, diagrammer og JSX

- Diagrammer som Mermaid kræver en særskilt renderer eller plugin; et kodehegn med `mermaid` laver ikke diagrammet alene.
- JSX/JavaScript indlejret i Markdown er MDX, ikke almindelig `.md`. Brug ikke MDX-syntaks, medmindre build pipeline og sikkerhedsbehov er sat op til det.
- Definition lists, callouts og andre editor-specifikke udvidelser kan virke i ét system og fejle i et andet. Brug CommonMark eller GFM, medmindre den konkrete udvidelse er aktiveret her.

## Blogskabelon

Kopiér denne struktur til et nyt Markdown-indlæg. Titel og slug tilføjes separat i `src/features/blog/data/posts.ts`.

````md
# Kort, præcis titel

Kort indledning: hvad emnet handler om, og hvorfor det er relevant.

## Problem eller mål

Beskriv opgaven eller spørgsmålet med dine egne ord.

## Fremgangsmåde

Forklar idéen trin for trin. Brug lister, hvis rækkefølgen betyder noget.

## Eksempel

Beskriv input, output og eventuelle antagelser.

```ts
// Indsæt et kort, relevant kodeeksempel.
```

## Refleksion

Hvad lærte du? Hvad var svært? Hvilke begrænsninger eller alternativer er der?

## Kilder

- [Titel på kilde](https://example.com)
````

## Hurtig fejlfinding

| Problem | Typisk årsag | Løsning |
| --- | --- | --- |
| Overskrift vises som tekst | Manglende mellemrum efter `#` | Skriv `## Overskrift` |
| To linjer bliver ét afsnit | Intet tomt linjeskift | Indsæt en tom linje mellem afsnittene |
| Kode vises uden farver | Highlighter er ikke installeret eller sat op | Brug almindelig kodeblok eller tilføj syntax highlighting |
| GFM-tabel vises forkert | `remark-gfm` mangler i renderer | Installer plugin'et og giv det til `remarkPlugins` |
| Rå HTML vises som tekst | `rehype-raw` er ikke aktiveret | Foretræk Markdown; brug kun rå HTML med omtanke og sanitizing |
| En Markdown-fil dukker ikke op | Den er ikke importeret og registreret i datafilen | Tilføj raw-import og et objekt i `posts.ts` |
| Overskrift eller liste genkendes ikke | Manglende tom linje eller forkert indrykning | Adskil blokke med tom linje; kontrollér listeindryk |
| Backticks lukker kodeblokken for tidligt | Indholdet indeholder samme hegn | Brug længere ydre hegn, fx fire backticks |

## Kilder og detaljer

- [React Markdown: README, props, plugins, components og sikkerhed](https://github.com/remarkjs/react-markdown)
- [CommonMark-specifikationen](https://spec.commonmark.org/)
- [remark-gfm: tabeller, task lists, autolinks, fodnoter og gennemstregning](https://github.com/remarkjs/remark-gfm)
- [remark-math: matematiksyntaks og renderingsmuligheder](https://github.com/remarkjs/remark-math)
- [rehype-raw: fortolkning af rå HTML](https://github.com/rehypejs/rehype-raw)
- [rehype-sanitize: rensning af HTML-noder](https://github.com/rehypejs/rehype-sanitize)
