# Wallet Service

[English](#english) | [Español](#español)

---

<a name="english"></a>
## English

### Project Description
Wallet Service is a RESTful API built with Java 21 and Spring Boot that manages a digital wallet system. It allows users to register, create accounts with different currencies, perform money transfers between accounts, and view transaction history. The project uses PostgreSQL as the database.

### Setup

#### Prerequisites
*   Java 21
*   Maven
*   PostgreSQL

#### Installation & Configuration
1.  Clone the repository.
2.  Create a PostgreSQL database.
3.  Configure your database connection in `src/main/resources/application.properties` (create the file if it doesn't exist):
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```
4.  Run the application:
    ```bash
    mvn spring-boot:run
    ```

### API Documentation

Base URL: `/api`

#### 1. Create User
Registers a new user in the system.

*   **URL:** `/user`
*   **Method:** `POST`
*   **Request Body:**
    ```json
    {
      "name": "John Doe",
      "email": "john.doe@example.com"
    }
    ```
*   **Success Response:**
    *   **Code:** `201 CREATED`
    *   **Content:** User object details.
*   **Error Responses:**
    *   **Code:** `400 BAD REQUEST`
        *   Content: Validation errors (e.g., invalid email, empty name).
    *   **Code:** `409 CONFLICT`
        *   Content: `{"message": "Email ya registrado", "code": 409}`

#### 2. Create Account
Creates a new wallet account for a specific user.

*   **URL:** `/user/account`
*   **Method:** `POST`
*   **Request Body:**
    ```json
    {
      "currency": "USD",
      "userId": 1
    }
    ```
*   **Success Response:**
    *   **Code:** `201 CREATED`
    *   **Content:**
        ```json
        {
          "id": 1,
          "currency": "USD",
          "userId": 1
        }
        ```
*   **Error Responses:**
    *   **Code:** `400 BAD REQUEST`
        *   Content: Validation errors or invalid currency.
    *   **Code:** `404 NOT FOUND`
        *   Content: `{"message": "No se encontro usuario", "code": 404}`
    *   **Code:** `409 CONFLICT`
        *   Content: `{"message": "Cuenta ya existente", "code": 409}`

#### 3. Create Transaction
Performs a money transfer between accounts.

*   **URL:** `/transaction`
*   **Method:** `POST`
*   **Request Body:**
    ```json
    {
      "amount": 100.00,
      "type": "TRANSFER",
      "accountId": 1,
      "targetAccountId": 2
    }
    ```
*   **Success Response:**
    *   **Code:** `200 OK`
    *   **Content:**
        ```json
        {
          "id": 10,
          "amount": 100.00,
          "type": "TRANSFER",
          "accountId": 1,
          "targetAccountId": 2
        }
        ```
*   **Error Responses:**
    *   **Code:** `400 BAD REQUEST`
        *   Content: Validation errors.
    *   **Code:** `404 NOT FOUND`
        *   Content: `{"message": "No se encuentra la cuenta solicitante", "code": 404}` or `{"message": "No se encontro cuenta destino", "code": 404}`
    *   **Code:** `409 CONFLICT`
        *   Content: `{"message": "No hay fondos suficientes en la cuenta", "code": 409}` or `{"message": "Ambas cuentas no tiene la misma moneda", "code": 409}`

#### 4. Transaction History
Retrieves the history of transactions for a specific account.

*   **URL:** `/transaction/{id}`
*   **Method:** `GET`
*   **URL Params:** `id` (The Account ID)
*   **Success Response:**
    *   **Code:** `200 OK`
    *   **Content:** List of transaction objects.

---

<a name="español"></a>
## Español

### Descripción del Proyecto
Wallet Service es una API RESTful construida con Java 21 y Spring Boot que gestiona un sistema de billetera digital. Permite a los usuarios registrarse, crear cuentas con diferentes monedas, realizar transferencias de dinero entre cuentas y ver el historial de transacciones. El proyecto utiliza PostgreSQL como base de datos.

### Configuración (Setup)

#### Requisitos Previos
*   Java 21
*   Maven
*   PostgreSQL

#### Instalación y Configuración
1.  Clonar el repositorio.
2.  Crear una base de datos PostgreSQL.
3.  Configurar la conexión a la base de datos en `src/main/resources/application.properties` (crear el archivo si no existe):
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/tu_base_de_datos
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    ```
4.  Ejecutar la aplicación:
    ```bash
    mvn spring-boot:run
    ```

### Documentación de la API

URL Base: `/api`

#### 1. Crear Usuario
Registra un nuevo usuario en el sistema.

*   **URL:** `/user`
*   **Método:** `POST`
*   **Cuerpo de la Solicitud (Body):**
    ```json
    {
      "name": "Juan Perez",
      "email": "juan.perez@example.com"
    }
    ```
*   **Respuesta Exitosa:**
    *   **Código:** `201 CREATED`
    *   **Contenido:** Detalles del objeto Usuario.
*   **Respuestas de Error:**
    *   **Código:** `400 BAD REQUEST`
        *   Contenido: Errores de validación (ej. email inválido, nombre vacío).
    *   **Código:** `409 CONFLICT`
        *   Contenido: `{"message": "Email ya registrado", "code": 409}`

#### 2. Crear Cuenta
Crea una nueva cuenta de billetera para un usuario específico.

*   **URL:** `/user/account`
*   **Método:** `POST`
*   **Cuerpo de la Solicitud (Body):**
    ```json
    {
      "currency": "USD",
      "userId": 1
    }
    ```
*   **Respuesta Exitosa:**
    *   **Código:** `201 CREATED`
    *   **Contenido:**
        ```json
        {
          "id": 1,
          "currency": "USD",
          "userId": 1
        }
        ```
*   **Respuestas de Error:**
    *   **Código:** `400 BAD REQUEST`
        *   Contenido: Errores de validación o moneda inválida.
    *   **Código:** `404 NOT FOUND`
        *   Contenido: `{"message": "No se encontro usuario", "code": 404}`
    *   **Código:** `409 CONFLICT`
        *   Contenido: `{"message": "Cuenta ya existente", "code": 409}`

#### 3. Crear Transacción
Realiza una transferencia de dinero entre cuentas.

*   **URL:** `/transaction`
*   **Método:** `POST`
*   **Cuerpo de la Solicitud (Body):**
    ```json
    {
      "amount": 100.00,
      "type": "TRANSFER",
      "accountId": 1,
      "targetAccountId": 2
    }
    ```
*   **Respuesta Exitosa:**
    *   **Código:** `200 OK`
    *   **Contenido:**
        ```json
        {
          "id": 10,
          "amount": 100.00,
          "type": "TRANSFER",
          "accountId": 1,
          "targetAccountId": 2
        }
        ```
*   **Respuestas de Error:**
    *   **Código:** `400 BAD REQUEST`
        *   Contenido: Errores de validación.
    *   **Código:** `404 NOT FOUND`
        *   Contenido: `{"message": "No se encuentra la cuenta solicitante", "code": 404}` o `{"message": "No se encontro cuenta destino", "code": 404}`
    *   **Código:** `409 CONFLICT`
        *   Contenido: `{"message": "No hay fondos suficientes en la cuenta", "code": 409}` o `{"message": "Ambas cuentas no tiene la misma moneda", "code": 409}`

#### 4. Historial de Transacciones
Obtiene el historial de transacciones para una cuenta específica.

*   **URL:** `/transaction/{id}`
*   **Método:** `GET`
*   **Parámetros URL:** `id` (El ID de la Cuenta)
*   **Respuesta Exitosa:**
    *   **Código:** `200 OK`
    *   **Contenido:** Lista de objetos de transacción.
