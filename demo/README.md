# Getting Started

This is a proof of concept RESTful Spring Boot + MySQL.

I followed these guides to create the final POC:

1. [Spring Quickstart](https://spring.io/quickstart) - initialize the project
2. [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service) - update quick start to add a greeting
   endpoint (resource)
3. [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql) - add MySQL
   with [Hibernate's](https://hibernate.org/) ORM and users endpoint.

Nothing super complicated. Just 2 endpoints with a couple of methods.

## How to run it

### Prerequisites

First you need to install the following tools:

1. A Java Development Kit (JDK) - per the quickstart Spring
   recommends [BellSoft Liberica JDK](https://bell-sw.com/pages/downloads/#jdk-17-lts) (which is what I used).

   In any case - you'll want to make sure the installation folder is part of your PATH variable (e.g. within the
   terminal/command prompt you should be able to run `javac` or `java` with no errors)
2. [Docker](https://www.docker.com/products/docker-desktop/) - to run database container
3. [Postman](https://www.postman.com/downloads/) - to make & view REST requests

### Configure & Bring Up DB

We need to set a password, and optionally, a default database name

1. `cd` into the demo folder
2. make a copy of `example.env` then rename that to `.env`. Most OS usually hide `.` files by default, so you may need
   show hidden files to see the `.env` file.
3. Update `.env` with password & optionally a database name.
4. Bring up the database: `docker compose up -d`. You can shutdown the container with `docker compose down`.

Barring any errors you should see something like this in Docker Desktop (container ID will be different)
![drag racing](Screenshot%202024-02-12%20at%2010.33.42%20PM.png)

You should be able to connect to the db with any tool of your choice:

* host: localhost
* username: root
* password: whatever password you set in `.env`

At this point there's no data.

### Start the API

We can finally run the app!

1. If not already there, `cd` into the demo folder
2. Start the app

   Unix: `./mvnw spring-boot:run`

   Windows: `.\mvnw spring-boot:run`

This will start building the project (1st time might take a while). A bunch of text will fly by. Once it's done, you
should see this (truncated for clarity):

```log
Tomcat started on port 8080 (http) with context path '/api'

Started DemoApplication in 3.888 seconds (process running for 4.205)
```

The REST API is now running & ready to process requests. To verify everything is working, point your browser
to [http:localhost:8080/api/greeting](http:localhost:8080/api/greeting). You should see the customary `Hello, World`

```json
{
  "id": 1,
  "content": "Hello, World!"
}
```

You can import the [Postman collection](Demo%20REST%20API.postman_collection.json) into Postman to see all available
endpoints and make requests to them.

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
