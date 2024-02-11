

# OpenAI Spring Demo

This project demonstrates the integration of the experimental Spring AI project with OpenAI, showcasing how to leverage Spring Boot to create applications that interact with OpenAI's powerful AI models.

## Prerequisites

- JDK 21 or later
- Maven 3.6 or later

## Setup

To get started with the OpenAI Spring Demo, clone this repository to your local machine. Before running the application, ensure you have Maven and JDK 21 installed on your system.

### Maven Configuration

This project uses the experimental `0.8.0-SNAPSHOT` version of Spring AI, which requires access to Spring's snapshot and milestone repositories. These repositories are configured in the `pom.xml` file, so no additional setup is required to resolve the Spring AI dependencies.

However, it's crucial to enable the snapshot repository in your Maven settings to use the `0.8.0-SNAPSHOT` version of Spring AI. If your build fails to resolve Spring AI dependencies, verify your Maven settings to ensure snapshot repositories are enabled.

## Running the Application

To run the application, navigate to the project root directory and execute the following command:

```bash
./mvnw spring-boot:run
```

This command will start the Spring Boot application. Once the application is running, it will be ready to receive requests and interact with OpenAI's models through the configured endpoints.

## Interacting with the Application

The application defines a REST endpoint `/dad-joke` that returns a dad joke from OpenAI's models. To request a dad joke, use the following `curl` command:

```bash
curl http://localhost:8080/dad-joke
```

You should receive a response containing a dad joke.

## Customizing the Application

To customize the application or integrate additional OpenAI models, refer to the `ChatService` class located in the `io.jeremyodell.openaispringdemo.gateway` package. This class serves as an example of how to implement a service layer that communicates with OpenAI's models using the Spring AI `ChatClient`.

## Contributing

Contributions to the OpenAI Spring Demo are welcome. Please feel free to submit pull requests or open issues to suggest improvements or report bugs.

## License

This project is open-sourced under the MIT License. See the LICENSE file for more details.

---
