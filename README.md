<h1 align="center">
  Backend following an hexagonal architecture with a Domain Driven Design
</h1>

<h2 align="center">
    <a href="https://spring.io/">
        <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white"/>
    </a>
    <a href="https://www.java.com//">
        <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
</h2>

- [Short Description](#short-description)

## Short Description

This backend application written in Java using Spring contains a hexagonal architecture which basically allows a client to:

- Create a user

- Login

- Add balance to a specific user

- Retrieve the balance of the user


By running `mvn springboot:run` it should deploy a db in a docker container in which the users will be registered, alongside the backend application in a different one.
