# Third Service (Name Concatenation Service)

## Overview

The Third Service exposes a POST endpoint that accepts a JSON payload, logs it, and returns a greeting message concatenating the `name` and `surname` values.

## Features

- **POST `/concatenate`**: Accepts a JSON payload with `name` and `surname`, logs the payload, and returns a greeting message in the format `{"Hello Name Surname"}`.

## Setup

```bash
# 1. Clone the repository:
git clone <repository-url>
cd third-service

# 2. Build the project:
mvn clean install

# 3. Run the application:
mvn spring-boot:run

```

## Endpoints
curl --location 'http://log-and-concatenate-service-4-env.eba-pihc9mzr.ap-southeast-2.elasticbeanstalk.com/api/v1/concatenate-log' \
--header 'Content-Type: application/json' \
--data '{
    "name": "yuvraj",
    "surname": "darekar"
}'
