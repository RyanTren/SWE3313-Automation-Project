# Setup

## Using Docker

A `docker-compose` file is included to make setting up a database easy. No need to install anything locally. You _will_
need to install [Docker](https://www.docker.com/products/docker-desktop/)

Once docker is installed & running:

1. Copy the [example.env](example.env) & rename that to `.env`
2. Update `.env` with your password, _optionally_, a DB name
3. In your terminal/command prompt window:
    1. cd in to the repo
    2. `docker compose up -d`

Once completed you should have a MySQL DB running.

## If you already have MySQL installed

1. Copy the [example.env](example.env) & rename that to `.env`
2. Update `.env` with your password & DB name

   If your username is not `root` then set your username here
   in `src/main/java/org/jsrestaurant/DatabaseConnection.java`
   ```java
   // also change localhost if MySQL is running somewhere else
   String url = "jdbc:mysql://localhost:3306/" + dbName;
   String username = "root";
   ```

## How to Run App

In your IDE, open `src/main/java/org/jsrestaurant/App.java`. Your IDE should detect the project structure, allowing you
to hit the play/run button.

If it doesn't, mark `src/main/java` as Sources Root (or your IDE equivalent).

### Running it Manually

#### If you have maven installed (& set in your system PATH)

From the repo root, run

`mvn clean package`

Follow by

`java -jar SWE3313-Automation-Project-1.0-SNAPSHOT-jar-with-dependencies.jar`

#### If you do not have maven installed

##### Unix & macOS

From the repo root, run

`./mvnw clean package`

You _may_ get a permission deny error. If so, make the script executable by running:

`chmod +x mvnw`

then clean, package the app again.

Finally,

`java -jar SWE3313-Automation-Project-1.0-SNAPSHOT-jar-with-dependencies.jar`

##### Windows

From the repo root, run

`.\mvnw.cmd clean package`

Follow by

`java -jar SWE3313-Automation-Project-1.0-SNAPSHOT-jar-with-dependencies.jar`
