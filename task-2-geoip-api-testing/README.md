# geoip api testing demo

## Description
Go to https://freegeoip.io/ and get a free API key (be aware that it is limited to 100 requests / mo). Call their API with that key, using JSON format, and perform the following actions:
a) Assert the response code;
b) Parse the response;
c) Assert your latitude and longitude with a 0.01° tolerance (assume you know your actual lat and lon).

## Environment configuration
Make sure the environment has Java Development Kit installed. This project tested on:
* [Open JDK 14](https://openjdk.org/projects/jdk/14/)

## Build tool
- **Gradle**, wrapper version - *7.4*

## Run
#### Gradle
  `./gradlew task-2-geoip-api-testing:test`