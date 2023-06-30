# Trading Application

The Trading Application receives signals and processes them using trading algorithms provided by a third-party library.

## Features

- Receives signals via HTTP endpoint
- Easy to understand, maintain, and add new signals
- Supports concurrent signal processing using ExecutorService

## Getting Started

### Prerequisites

- Java 8 or higher
- Gradle

### Installation

1. Clone the repository:

```
https://github.com/PraveenMatthewPhilip/trading-application
```

2. Build the application using Gradle:

```
cd trading-application
gradle clean build
```

### Usage

1. Run the application:

```
java -jar build/libs/trading-application-1.0.jar
```

Example cURL command to send a signal:

```
curl -X POST http://localhost:8080/signal/{signalId}
```
