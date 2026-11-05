# Architecture

## Current state

The repository contains a React and TypeScript course-notes site under `frontend/`, built with Vite. `src/app/` contains the entry point, router, shared layout, and page components. The blog feature owns its post data, Markdown files, card component, and lookup hooks under `src/features/blog/`. Global design tokens and document defaults live in `src/shared/styles/globals.css`; all component styles use colocated CSS modules. See [frontend conventions](frontend-conventions.md) for the required source layout and style rules.

The independent Maven project under `backend/` contains Java 17 course examples and
exercise templates in `src/main/java/`, with JUnit 5 tests in `src/test/java/`.
The default-package `Main` class calls `portfolioOne.PortfolioOne`, which runs
the portfolio's Dijkstra road-network and A* grid examples with console output.
Within `portfolioOne`, `LocalMaps` defines the example data, `RoadNetwork` groups
the cities, and `GridMap` owns grid cells and neighbor lookup. `GridNode` references
the shared `City` objects. The search classes receive their maps and endpoints
rather than constructing example data themselves.
`NodeWithCost` and `NodeWithDist` are separate queue-entry classes with fixed
costs and `Comparable` implementations for the two search priorities.
Exercise calls are updated in `Main` as they are implemented. Run it with `backend/` as
the working directory because some examples read relative paths under `data/`.
See [the backend README](../backend/README.md) for IDE and Maven instructions.

## Maintaining this document

As the project takes shape, record its major components, how they interact, and durable architectural decisions here. Keep task-specific guidance in separate files under `ai/` and link to those files from [the agent entry point](../.github/agent-instructions.md) when useful.
