Jeg har delt frontend-projektet op, så indhold, præsentation og opstart ligger hvert sit sted. Det gør det lettere at finde rundt og ændre én del uden at blande den sammen med resten.

## Mappestrukturen

`src/app/App.tsx` samler applikationens wrappers, mens `src/app/routes/AppRoutes.tsx` definerer ruterne. Sider og det fælles bloglayout ligger under `src/app/`. Bloggens data og Markdown-tekster ligger samlet under `src/features/blog/data/`, og opslagene vises med komponenter fra samme feature.

Globale designværdier og grundregler ligger i `src/shared/styles/globals.css`. Layout-, side- og komponentstil er opdelt i lokale CSS-moduler, så hver komponent har sine egne styles.

Opsætningen af Vite og TypeScript ligger i projektets rod sammen med `package.json`, hvor scripts og afhængigheder er samlet.

## Hvorfor dele det op?

Når indlægsteksten ligger separat fra React-komponenterne, kan jeg redigere teksten uden at ændre sidens layout. Samtidig fungerer `posts.ts` som forbindelsen mellem hvert indlæg, dets titel og den URL, der åbner det.