# Programming Operational Rules

> **Purpose:** These rules govern the discipline, planning, and execution of programming-related tasks in project environments. All agents and developers must comply with these principles to ensure maintainable, traceable, and high-quality software outcomes.

---

## 1. Planning and Task Progression

1.1. **Mandatory Planning File**: Before initiating any work on a project, create a file named `GEMINI.PLAN.md` at the root of the project directory. This file must include:

* A breakdown of all project tasks.
* The rationale and strategy for completing each task.
* Current progress updates with timestamps.
* Dependencies, blockers, and next steps.

1.2. **Sequential Task Execution**: Do **not** proceed to the next task until the current task is fully completed, tested, and documented. Mark tasks as complete in the `GEMINI.PLAN.md` before proceeding.

1.3. **Web Search First Policy**: Before writing or modifying any implementation, prioritize researching current best practices and official documentation via the web. This ensures that code is written using the latest and most secure standards.

1.4. **No Auto-Dev Server Execution**: Never execute local development servers or watchers like `npm run dev`, `flutter run`, or `php artisan serve` from within scripts or agent commands. These must be started manually by the user only.

---

## 2. Coding and Development Practices

2.1. **Explicit Type Declarations**: Always declare variable and function types explicitly, especially in TypeScript, Dart, or strongly typed environments.

2.2. **Code Must Compile Before Commit**: Do not commit any code that fails to compile or throws warnings in the build process.

2.3. **No Console Logs in Final Code**: Remove all debugging output such as `console.log`, `print()`, or similar before marking a task as complete.

2.4. **Function Length Limit**: Break any function exceeding 50 lines into smaller, reusable sub-functions unless doing so harms readability.

2.5. **One Purpose per Function**: Each function must perform a single, clearly defined purpose. Do not mix responsibilities.

2.6. **No Dead Code**: All unused functions, commented-out blocks, and deprecated variables must be removed before code is merged or submitted.

2.7. **Strict Naming Conventions**: Use consistent and descriptive naming for all variables, functions, and files. Example: `getUserSession()` instead of `getSes()`.

2.8. **Avoid Magic Numbers**: Replace all unexplained numeric literals with named constants or enums.

2.9. **Environmental Configs in .env Only**: Do not hardcode URLs, secrets, or keys. These must reside in `.env` files or appropriate configuration managers.

---

## 3. Version Control Discipline

3.1. **Descriptive Commits Only**: All commit messages must start with an action verb and clearly describe the change. Example: `Fix login redirect bug`, `Add input validation to signup form`.

3.2. **Atomic Commits**: Each commit must include a single unit of work. Do not mix unrelated changes in one commit.

3.3. **No Force Pushes to Main Branch**: Force pushing is strictly prohibited on `main`, `master`, or any protected branches.

3.4. **Always Pull Before Push**: Before pushing code, always pull the latest changes from the remote branch and resolve any merge conflicts locally.

---

## 4. Testing and Verification

4.1. **Test Coverage Minimum**: Ensure at least 85% code coverage with meaningful unit and integration tests.

4.2. **Write Tests First (TDD)**: When appropriate, follow Test-Driven Development (TDD). Define tests before implementing new logic.

4.3. **Manual QA After Feature Completion**: After completing any task, manually verify the change in a test or staging environment before declaring it done.

4.4. **Test File Naming**: Test files must be clearly named and colocated with or mirrored from the component/module they are testing.

---

## 5. Project Structure and File Management

5.1. **Respect Project Structure**: Do not introduce custom folders or unconventional file placement unless justified and approved in `GEMINI.PLAN.md`.

5.2. **Organize by Feature, Not Type**: Prefer grouping files by feature/module instead of function type (e.g., `auth/` instead of `controllers/`, `services/`, etc.).

5.3. **One Component per File Rule**: Avoid placing multiple unrelated classes or components in a single file.

5.4. **No Binary or Temp Files in Repo**: Never commit build artifacts, `.DS_Store`, `node_modules/`, or environment files into version control.

---

## 6. Communication and Documentation

6.1. **Document Every Public Interface**: All public-facing functions, endpoints, or classes must include concise but informative docstrings.

6.2. **Change Justification Logs**: For every major refactor or change in logic, update a `CHANGELOG.md` entry explaining:

* What changed
* Why it changed
* Any side effects or follow-ups

6.3. **Inline Documentation for Complex Logic**: If a piece of logic is non-obvious, include inline comments to explain the rationale.

6.4. **No Untracked TODOs**: All TODOs or FIXME comments must be logged in a task tracker (or `GEMINI.PLAN.md`) and assigned a clear resolution timeline.

---

## 7. Finalization and Handover

7.1. **Clean Working Tree**: Ensure no uncommitted or untracked changes are present before closing a task.

7.2. **Environment Check Script**: Include a `setup.md` or `check-env.sh` script that verifies prerequisites for running the project.

7.3. **No Open Console Warnings**: Final app must not log warnings in the browser, terminal, or logs during runtime or startup.

7.4. **Confirm with End User Before Marking Done**: Always get end-user or stakeholder confirmation that a feature is working as intended before marking it complete.

---
