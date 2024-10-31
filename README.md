<p align="center">
  <a href="" rel="noopener">
 <img width=200px height=200px src="https://i.imgur.com/8VQLkEZ.jpeg" alt="Project logo"></a>
</p>

<h3 align="center">Dental Clinic - Back End</h3>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![GitHub Issues](https://img.shields.io/badge/issues-0-red)](https://github.com/Akaidmaru/TIRADO-LAURA-QUEVEDO-REDDMAR/issues)
[![GitHub Pull Requests](https://img.shields.io/badge/pull_requests-0-yellow)](https://github.com/Akaidmaru/TIRADO-LAURA-QUEVEDO-REDDMAR/pulls)
[![License](https://img.shields.io/badge/license-apache-blue.svg)](/LICENSE)

</div>


## 📝 Table of Contents

-   [About](#about)
-   [Architecture](#architecture)
-   [Quick Start](#quick-start)
-   [Usage](#usage)
-   [Built Using](#built-using)
-   [TODO](../TODO.md)
-   [Contributions](../CONTRIBUTIONS.md)
-   [Authors](#authors)
-   [Acknowledgments](#acknowledgments)

## 🧐 About <a name = "about"></a>

This is a project created by Laura Tirado and Reddmar Quevedo as a final integrative project for the Back End course at Digital House. It is a project for a dental clinic that is still under development. The goal is to create a system that allows managing the information of patients and dentists, facilitating the administration of appointments and consultations.

## 🏗️ Architecture <a name = "architecture"></a>

The project is structured in a **layered architecture**, which includes the following layers:

-   **Presentation Layer**: Handles HTTP requests and responses. It uses REST controllers to interact with the client.
-   **Service Layer**: Contains the business logic. Here, the rules and processes that manage the information of patients, dentists, and appointments are implemented.
-   **Persistence Layer**: Responsible for interacting with the database. It uses JPA for managing entities and repositories.
-   **Model Layer**: Defines the entities of the system, which represent the data being managed (Patients, Dentists, Appointments, etc.).

The application uses **Spring Boot** to simplify configuration and development, and is based on an **H2** database for data storage.

## 📁 File Structure <a name = "file-structure"></a>

The file structure of the project is as follows:

```
src
├── main
│   ├── java
│   │   └── finalproject
│   │       └── com
│   │           └── Clinica_Odontologica
│   │               ├── config
│   │               │   └── ModelMapperConfig
│   │               │   └── WebConfig.java
│   │               ├── controller
│   │               │   ├── odontologoController.java
│   │               │   ├── pacienteController.java
│   │               │   ├── turnoController.java
│   │               │   └── VistaController.java
│   │               ├── dto
│   │               │   ├── request
│   │               │   │   ├── TurnoModifyDto.java
│   │               │   │   ├── TurnoRequestDto.java
│   │               │   └── response
│   │               │       ├── OdontologoResponseDto.java
│   │               │       ├── PacienteResponseDto.java
│   │               │       └── TurnoResponseDto.java
│   │               ├── entity
│   │               │   ├── Domicilio.java
│   │               │   ├── Odontologo.java
│   │               │   ├── Paciente.java
│   │               │   └── Turno.java
│   │               ├── exception
│   │               │   ├── ApiError.java
│   │               │   ├── GlobalHandler.java
│   │               │   └── ResourceNotFoundException.java
│   │               ├── repository
│   │               │   ├── IDomicilioRepository.java
│   │               │   ├── IOdontologoRepository.java
│   │               │   ├── IPacienteRepository.java
│   │               │   └── ITurnoRepository.java
│   │               ├── service
│   │               │   ├── IOdontologoService.java
│   │               │   ├── IPacienteService.java
│   │               │   ├── ITurnoService.java
│   │               │   └── impl
│   │               │       ├── ServiceOdontologo.java
│   │               │       ├── ServicePaciente.java
│   │               │       └── ServiceTurno.java
│   │               └── utils
│   │                   ├── GsonProvider.java
│   │                   └── LocalDateAdapter.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── finalproject
            └── com
                └── Clinica_Odontologica
                    ├── ServiceOdontologoTest.java
                    ├── ServicePacienteTest.java
                    └── ClinicaOdontologicaApplicationTests.java
```

## 🏁 Quick Start <a name = "quick-start"></a>

To get started, download both repositories, the current one and the front-end one. Here is the front-end repository:

```
https://github.com/lauramtirado/Front-End-Proyecto-Clinica-Odontologica
```

### Prerequisites

1. Install Java 21.
2. Open the project and go to `ClinicaOdontologiaApplication` and run it.
3. Alternatively, you can run the Maven production cycle and generate the Java package of the application, then execute it with:

```
java -jar <name of the generated package>
```

## 🎈 Usage <a name="usage"></a>

The front-end allows adding, deleting, modifying, and listing both patients and dentists. The main functionalities include:

-   **Patient Management**: Create, modify, and delete patients, as well as search by ID, name, or surname.
-   **Dentist Management**: Create, modify, and delete dentists, as well as search by ID, name, or surname.
-   **Appointment Management**: Create, modify, and delete appointments, as well as search appointments by patient or dentist.

## ⛏️ Built Using <a name = "built-using"></a>

-   [H2 Database](https://www.h2database.com/html/main.html) - Database
-   [Spring](https://spring.io/) - Server, Web Framework
-   [Lombok](https://projectlombok.org/) - Development tool
-   [Gson](https://github.com/google/gson) - Serialization/deserialization in Java
-   [ModelMapper](https://modelmapper.org/) - Simple and intelligent object mapping
-   [Postman](https://www.postman.com/) - API platform

## ✍️ Authors <a name = "authors"></a>

-   [@lauramtirado](https://github.com/lauramtirado) - Idea & Initial Work
-   [@akaidmaru](https://github.com/akaidmaru) - Idea & Initial Work

## 🎉 Acknowledgments <a name = "acknowledgments"></a>

-   To Professor Vero, for sharing her knowledge and guiding us all the time.
-   To our classmates who are always attentive and collaborating.
-   To Digital House for the opportunity to help us grow.
