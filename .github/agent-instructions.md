# Agent entry point

This file is the starting point for every prompt handled by an AI agent in this repository. Read it first, then load only the context tiers needed for the task.

## Context tiers

- [Architecture](../ai/architecture.md): current system structure and architectural decisions. Read when a task depends on how the system is organized; update it when the architecture changes.
- [Frontend conventions](../ai/frontend-conventions.md): frontend structure, tabs, CSS modules, and design-token rules. Read before changing frontend code.

Do not run builds, tests, or similar verification commands; Jonas runs those. Diff inspection and lint are allowed when available.

Keep this entry point short. Put durable, topic-specific context in `ai/` and link to it here. Prefer inspecting the repository's current code and configuration over assuming undocumented behavior.

## Working agreements

- Make focused changes that fit the existing project conventions.
- Do not invent commands, dependencies, or system behavior; verify them in the repository.
- Update relevant documentation when behavior, structure, or contribution steps change.
- Summarize changes and any verification performed in the final response.
