# ui page unload wait demo

## Description
Imagine the following scenario: you click on a button that should redirect you to a new page,
but the page URL stays the same and the DOM structure stays almost the same. Provide a code fragment to wait explicitly
for the page to unload. Waiting for the page to load is not necessary (perhaps you want to gracefully handle some errors
in case you are left on the same page).

## Environment configuration
Make sure the environment has Java Development Kit installed. This project tested on:
* [Open JDK 14](https://openjdk.org/projects/jdk/14/)

## Build tool
- **Gradle**, wrapper version - *7.4*

## Run
#### Gradle
  `./gradlew task-4-ui-page-unload-wait:test`