<p align="center">
  <a href="" rel="noopener">
 <img width=200px height=200px src="https://i.imgur.com/8VQLkEZ.jpeg" alt="Project logo"></a>
</p>

<h3 align="center">Clínica Odontológica - Back End</h3>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![GitHub Issues](https://img.shields.io/badge/issues-0-red)](https://github.com/Akaidmaru/TIRADO-LAURA-QUEVEDO-REDDMAR/issues)
[![GitHub Pull Requests](https://img.shields.io/badge/pull_requests-0-yellow)](https://github.com/Akaidmaru/TIRADO-LAURA-QUEVEDO-REDDMAR/pulls)
[![License](https://img.shields.io/badge/license-apache-blue.svg)](/LICENSE)

</div>

## 📖 English Version <a name = "english-version"></a>

For the English version, please refer to [README.md](README.md).

## 📝 Tabla de Contenidos

-   [Acerca de](#acerca-de)
-   [Arquitectura](#arquitectura)
-   [Inicio Rápido](#inicio-rápido)
-   [Uso](#uso)
-   [Construido Usando](#construido-usando)
-   [TODO](../TODO.md)
-   [Contribuciones](../CONTRIBUTIONS.md)
-   [Autores](#autores)
-   [Reconocimientos](#reconocimientos)

## 🧐 Acerca de <a name = "acerca-de"></a>

Este es un proyecto realizado por Laura Tirado y Reddmar Quevedo como proyecto final integrador de la materia de Back End de Digital House. Es un proyecto para una clínica odontológica, que sigue en desarrollo. El objetivo es crear un sistema que permita gestionar la información de pacientes y odontólogos, facilitando la administración de turnos y consultas.

## 🏗️ Arquitectura <a name = "arquitectura"></a>

El proyecto está estructurado en una **arquitectura en capas**, que incluye las siguientes capas:

-   **Capa de Presentación**: Maneja las solicitudes HTTP y las respuestas. Utiliza controladores REST para interactuar con el cliente.
-   **Capa de Servicio**: Contiene la lógica de negocio. Aquí se implementan las reglas y procesos que gestionan la información de pacientes, odontólogos y turnos.
-   **Capa de Persistencia**: Se encarga de la interacción con la base de datos. Utiliza JPA para la gestión de entidades y repositorios.
-   **Capa de Modelo**: Define las entidades del sistema, que representan los datos que se manejan (Pacientes, Odontólogos, Turnos, etc.).

La aplicación utiliza **Spring Boot** para simplificar la configuración y el desarrollo, y se basa en una base de datos **H2** para el almacenamiento de datos.

## 📁 Estructura de Archivos <a name = "estructura-de-archivos"></a>

La estructura de archivos del proyecto es la siguiente:

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

## 🏁 Inicio Rápido <a name = "inicio-rápido"></a>

Para comenzar, descarga ambos repositorios, el actual y el del front. Aquí está el del front:

```
https://github.com/lauramtirado/Front-End-Proyecto-Clinica-Odontologica
```

### Prerequisitos

1. Instalar Java 21.
2. Abrir el proyecto e ir a `ClinicaOdontologiaApplication` y ejecutarlo.
3. Alternativamente, puedes hacer el ciclo de producción de Maven y generar el paquete Java de la aplicación, luego ejecutarlo con:

```
java -jar <nombre del paquete generado>
```

## 🎈 Uso <a name="uso"></a>

El front permite agregar, eliminar, modificar y listar tanto pacientes como odontólogos. Las funcionalidades principales incluyen:

-   **Gestión de Pacientes**: Crear, modificar y eliminar pacientes, así como buscar por ID, nombre o apellido.
-   **Gestión de Odontólogos**: Crear, modificar y eliminar odontólogos, así como buscar por ID, nombre o apellido.
-   **Gestión de Turnos**: Crear, modificar y eliminar turnos, así como buscar turnos por paciente o odontólogo.

## ⛏️ Construido usando <a name = "construido-usando"></a>

-   [H2 Database](https://www.h2database.com/html/main.html) - Base de datos
-   [Spring](https://spring.io/) - Servidor, Framework Web
-   [Lombok](https://projectlombok.org/) - Herramienta de desarrollo
-   [Gson](https://github.com/google/gson) - Serialización/deserialización en Java
-   [ModelMapper](https://modelmapper.org/) - Mapeo de objetos simple e inteligente
-   [Postman](https://www.postman.com/) - Plataforma API

## ✍️ Autores <a name = "autores"></a>

-   [@lauramtirado](https://github.com/lauramtirado) - Idea & Trabajo inicial
-   [@akaidmaru](https://github.com/akaidmaru) - Idea & Trabajo inicial

## 🎉 Reconocimientos <a name = "reconocimientos"></a>

-   A la profe Vero, por compartir sus conocimientos y guiarnos todo el tiempo.
-   A nuestros compañeros que siempre están pendientes y colaborando.
-   A Digital House por la oportunidad de ayudarnos a crecer.
