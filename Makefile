# ---------------------------------------------
# Project Configuration
# ---------------------------------------------
APP_NAME=openbanking-api
DOCKER_IMAGE=openbanking-api-app
DOCKER_COMPOSE_FILE=docker-compose.yml
JAR_PATH=build/libs/*.jar

# ---------------------------------------------
# Targets
# ---------------------------------------------

.PHONY: build test lint lint-format detekt docker-build up down logs clean help quality-check

## Build the application (JAR)
build:
	./gradlew clean bootJar

## Run unit tests
test:
	./gradlew test

## Run ktlint for code style
lint:
	./gradlew ktlintCheck

## Auto-format Kotlin code using ktlint
lint-format:
	./gradlew ktlintFormat

## Run detekt for static analysis
detekt:
	./gradlew detekt

## Run all code quality checks
quality-check: lint-format lint detekt

## Build the Docker image
docker-build: build
	docker build -t $(DOCKER_IMAGE) .

## Start services using docker-compose
up:
	docker-compose -f $(DOCKER_COMPOSE_FILE) up

## Stop docker-compose services
down:
	docker-compose -f $(DOCKER_COMPOSE_FILE) down

## View real-time logs from docker-compose
logs:
	docker-compose -f $(DOCKER_COMPOSE_FILE) logs -f

## Clean up docker containers, images, and volumes
clean:
	docker-compose -f $(DOCKER_COMPOSE_FILE) down --rmi all --volumes --remove-orphans

## Show help
help:
	@echo ""
	@echo "Usage:"
	@echo "  make build           -> Build the Spring Boot JAR"
	@echo "  make test            -> Run unit tests"
	@echo "  make lint            -> Run ktlint check"
	@echo "  make lint-format     -> Auto-format code with ktlintFormat"
	@echo "  make detekt          -> Run detekt static analysis"
	@echo "  make quality-check   -> Run all quality checks (format, lint, detekt)"
	@echo "  make docker-build    -> Build Docker image after JAR"
	@echo "  make up              -> Start Docker Compose services"
	@echo "  make down            -> Stop Docker Compose services"
	@echo "  make logs            -> Show real-time logs"
	@echo "  make clean           -> Remove containers, images, volumes"
