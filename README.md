
# Meu Projeto de Aplicativo de Treino

Estou desenvolvendo um aplicativo para gerenciar e otimizar meus treinos na academia. Este aplicativo tem como objetivo proporcionar uma experiência personalizada e eficiente para o acompanhamento e planejamento dos exercícios, com funcionalidades que incluem:

Gerenciamento de Exercícios: Cadastro e organização de diferentes exercícios, incluindo detalhes como grupos musculares trabalhados, repetições e séries.
Planos de Treino: Criação e personalização de planos de treino com base nas metas individuais.

```mermaid
classDiagram
    class Exercise {
        +String name
        +String description
        +String equipment
        +MuscleGroup muscleGroup
    }

    class Workout {
        +String name
        +List<Progress> progress
        +addProgress(p: Progress): void
        +removeProgress(p: Progress): void
        +Date date
    }

    class User {
        +List<Workout> workouts
        +addWorkout(w: Workout): void
        +removeWorkout(w: Workout): void
        +String username
        +String password
    }

    class Progress {
        +Exercise exercise
        +int sets
        +double weight
        +int repetitions
    }

    class Goal {
        +String description
        +Date targetDate
        +boolean completed
    }

    class MuscleGroup {
        <<enumeration>>
        +CHEST
        +BACK
        +LEGS
        +ARMS
        +ABS
    }

    User "1" -- "0..*" Workout : has
    Workout "1" -- "0..*" Progress : tracks
    Progress "1" -- "1" Exercise : refers to
    User "1" -- "0..*" Goal : defines
    Exercise --> MuscleGroup
```
