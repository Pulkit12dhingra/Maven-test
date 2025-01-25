# Maven-test

This project is a Maven-based Java web application that demonstrates the use of a simple calculator program. The application is built using Spring MVC and includes basic arithmetic operations such as addition, subtraction, multiplication, and division.


## CI/CD Pipeline

The project leverages Continuous Integration and Continuous Deployment (CI/CD) using Jenkins and Docker. Below is an overview of the CI/CD pipeline:

### Jenkinsfile

The `Jenkinsfile` defines the CI/CD pipeline for the project. It includes the following stages:

1. **Build**: Clones the repository from GitHub and runs Maven to build the project and package it into a WAR file.
2. **SonarQube Analysis**: Runs SonarQube analysis to ensure code quality.
3. **Server Configuration**: Configures the Artifactory server for storing build artifacts.
4. **Upload**: Uploads the WAR file to the Artifactory server.
5. **Publish Build Info**: Publishes build information to the Artifactory server.
6. **Docker Build**: Builds a Docker image for the application.

### Dockerfile

The `Dockerfile` defines the Docker image for the application. It uses the Tomcat base image and adds the WAR file to the Tomcat webapps directory. The application is exposed on port 8090.

### How to Run

To run the application locally, follow these steps:

1. **Clone the repository**:
    ```sh
    git clone https://git.nagarro.com/freshertraining2022/pulkitdhingra01.git
    cd java_test_1
    ```

2. **Build the project using Maven**:
    ```sh
    mvn clean package
    ```

3. **Build the Docker image**:
    ```sh
    docker build -t calculator_java .
    ```

4. **Run the Docker container**:
    ```sh
    docker run -p 8090:8080 calculator_java
    ```

5. **Access the application**:
    Open your browser and navigate to `http://localhost:8090/java_test_1`.

## Dependencies

The project uses the following dependencies:

- JUnit 4.12 for unit testing
- Spring Context 4.1.6.RELEASE
- Spring Web MVC 4.1.6.RELEASE
- Servlet API 2.5
- JSTL 1.2
- Spring JDBC 4.0.3.RELEASE
