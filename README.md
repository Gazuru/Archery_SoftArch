# Archery_SoftArch

## Importing project

You can import the project to IntelliJ by going to 'New -> Project from Existing Sources', and then choosing the
repository's base folder (Archery_SoftArch).
Then you need to Link/Load the Gradle projects, and you're good to go.

## Building project

Building the project can be done by executing the task under 'archery/Tasks/build/assemble' in the Gradle tool window.

## Starting the application

The backend can be started by simply starting the `ArcheryBeApplication.java` file under '
archery-be/src/main/java/hu/bme/aut/archerybe'.

The frontend can be run by either running it form a terminal using `ng serve`, or by adding a new npm Run configuration
inside IntelliJ, which should be `npm run start`.

## Documentation

Use-case diagram model can be found in: UseCase.mdj

Requirements specification on the following
link: [Requirements Specification](https://docs.google.com/document/d/1if6O7e-fuY0KHLBpNybU5jyjIlNrnnz-jB8PZgpUcYI/)
