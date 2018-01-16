# Interview Test

This project is a bare minimum setup required to complete the interview test task.

## Your task

Your task is to create a very simple profile editor, using the MVP pattern, with editing capabilities, persistence, and "randomization" using a restful web service.

## Features

- Display a user profile
    - Loads from persistence
    - A user has:
        - Name (first and last name)
        - Age
        - List of liked/preferred somethings (animals, techs, whatever)
    - The preferred somethings need no other information than their name
- Edit the user profile
    - Different screen, but with editing capabilities
    - Saves to persistence
    - Fill from "random" data (get random data from web service)

## Other requirements

- You must use Kotlin to implement the task. Exploiting Kotlin's productivity features is preferred instead of Java styled code.
- Use dependency injection in a minimal form just to showcase you understand the concept.
- UI is not a priority, the most minimal UI is sufficient. (You may use Anko as well)
- You must take advantage of RxJava's threading capabilities.

## Your environment

### Libraries

Already included:

- Dagger 2
- RxJava 2

Suggested:

- Retrofit
- Moshi
- Room

## Questions

If you have questions, you can contact Tamás Barta directly on Skype: tamas.barta at interticket.net
