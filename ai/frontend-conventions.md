# Frontend conventions

## Source layout

- Keep application composition, layouts, pages, and route definitions under `frontend/src/app/`.
- Put domain-specific UI, data, and hooks under `frontend/src/features/<feature>/`.
- Keep genuinely reusable data, hooks, and shared styles under `frontend/src/shared/`.
- Put reusable functional React logic in files named `*.hooks.ts`. Keep rendered components in `.tsx` files.
- Keep Markdown content in `.md` files and project/build configuration in its native file format.

## Styling

- Use tabs for indentation in TypeScript, TSX, and CSS.
- Keep global design tokens, document defaults, and reset rules in `frontend/src/shared/styles/globals.css`.
- Put all component and page styling in colocated `*.module.css` files. Do not add another global stylesheet.
- Use the existing CSS custom properties for colors, typography, spacing, borders, and radii. Add or adjust tokens in `globals.css` when a reusable design value is needed.
- Format CSS with one selector per block and one declaration per line.

## Verification

- Do not run builds, tests, or similar verification commands. Jonas runs those checks himself.
- It is fine to inspect the diff and run lint when a lint script is available.

## Application entry and routing

- `frontend/src/app/main.tsx` mounts `App` and imports the global stylesheet once.
- `frontend/src/app/App.tsx` provides application-level wrappers.
- `frontend/src/app/routes/AppRoutes.tsx` owns route definitions.
