# PR-01: Project Setup & Build (Maven)
Linked PR: [#1](https://github.com/akhilennu/spring-boot-samples-tldr/pull/1)

## What was done
- Created a new Spring Boot project using Maven via Spring Initializr.
- Group ID: `com.akhilennu`
- Artifact ID/Name: `spring-boot-samples-tldr`
- Package: `com.akhilennu.samples.tldr`
- Added `.gitignore` and `README.md` with the full project roadmap.
- [Optional] Configured code style files (`.editorconfig`, etc.)

## Key decisions/notes
- No dependencies added yet; project is an empty scaffold.
- Using Maven as the build system for this iteration.

## How to run
```bash
mvn spring-boot:run
```

## Next steps
- Start API Foundation by adding the Web starter and basic controller.
