# Architecture

## Current state

The repository contains a React and TypeScript course-notes site under `frontend/`, built with Vite. `src/app/` contains the entry point, router, shared layout, and page components. The blog feature owns its post data, Markdown files, card component, and lookup hooks under `src/features/blog/`. Global design tokens and document defaults live in `src/shared/styles/globals.css`; all component styles use colocated CSS modules. See [frontend conventions](frontend-conventions.md) for the required source layout and style rules.

## Maintaining this document

As the project takes shape, record its major components, how they interact, and durable architectural decisions here. Keep task-specific guidance in separate files under `ai/` and link to those files from [the agent entry point](../.github/agent-instructions.md) when useful.
