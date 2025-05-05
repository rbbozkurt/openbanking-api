# 🏦 OpenBanking API

This repository contains the core backend services for an **OpenBanking API**, designed using modern Kotlin + Spring Boot architecture. It provides a secure, scalable and extensible framework for interacting with financial services, eg. with initial support for the [Plaid API](https://plaid.com/docs/) using their sandbox environment.

---

## 🚀 Project Overview

This project serves as a foundational open banking backend infrastructure. It integrates with third-party financial services and offers:

- Secure user-facing REST API
- Scalable and containerized deployment on **Google Cloud Run**
- Automated CI/CD pipelines with GitHub Actions
- Clean architecture separation with DTOs, services, and config

---

## 🛠️ Tech Stack

| Layer       | Technology                         |
|------------|------------------------------------|
| Language    | Kotlin (JDK 17 - Temurin)          |
| Framework   | Spring Boot                        |
| API Client  | WebClient                          |
| Build Tool  | Gradle (Kotlin DSL)                |
| Deployment  | Docker + Google Cloud Run          |
| Infra       | GitHub Actions + Artifact Registry |


---

## ⚙️ CI/CD Pipeline

GitHub Actions workflows are defined for:

### ✅ `ci.yml` - Quality Checks on All Branches
- Run on all pushes
- Performs:
    - Gradle build & test
    - Lint check via `ktlint`
    - Static analysis via `detekt`

### 🚀 `deploy.yml` - Build & Deploy on Main Branch
- Triggered on `main` branch push
- Performs:
    - Auth via GitHub secret (`GCP_SA_KEY`)
    - Docker image build & push to Artifact Registry
    - Deploy to Cloud Run
    - Allow unauthenticated access
    - Auto-create GitHub release with:
        - Deployed URL
        - Docker image tag

### 🔍 `pr-check.yml` - Docker Runtime Check
- Triggered on PR to `main`
- Builds and starts Docker container locally
- Runs basic health check to ensure the image is bootable

---

## ☁️ Deployment

Deployed automatically to:

> [`https://openbanking-api-826260723607.europe-west3.run.app`](https://openbanking-api-826260723607.europe-west3.run.app)

Environment: **Google Cloud Run (europe-west3)**  
Image Source: **Artifact Registry**

---

## 🔐 Branch Protection & Code Ownership

- Protected `main` branch with:
    - Required PRs
    - Minimum 1 code owner approval
    - No self-approval
- Code owners:
    - `@rbbozkurt`
    - `@evgenyim`
- Verified deployments only mergeable with passing checks

---

## 📦 Requirements

- Java 17
- Docker (for local testing)
- Valid GCP Service Account JSON in GitHub Secrets (`GCP_SA_KEY`)

---


## 📄 License

MIT License — see [LICENSE](./LICENSE) for details.


