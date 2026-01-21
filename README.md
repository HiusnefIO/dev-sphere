# DevSphere 🌐

## The professional network for developers powered by AI

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Next.js](https://img.shields.io/badge/Next.js-16+-black)](https://nextjs.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4+-green)](https://spring.io/projects/spring-boot)

## 📋 Overview

**DevSphere** is a comprehensive social networking platform dedicated to the developer community, combining Web3/Blockchain technology with artificial intelligence to create a transparent, secure, and efficient recruitment ecosystem.

### 🎯 Objectives

- **For Developers**: Build blockchain-verified professional profiles, manage portfolios, and find suitable job opportunities
- **For Recruiters/Headhunters**: Search and connect with potential developers through AI-powered matching system
- **For Organizations**: Manage the entire recruitment process from job posting to on-boarding

## ✨ Key Features

### 🔐 Web3 & Blockchain Integration

- **Decentralized Profiles**: Data encrypted and stored on blockchain
- **Skill Authentication**: Certificates and achievements verified on-chain
- **Data Ownership**: Developers have full control over personal information
- **Smart Contracts**: Automated agreements and payments

### 👨‍💻 Profile & Portfolio Management

- Build professional profiles with customizable sections
- Integrate GitHub, GitLab, Bitbucket to showcase projects
- Upload and manage diverse portfolios (code, design, documentation)
- Work timeline and achievements tracker
- Endorsements and recommendations from colleagues

### 🤖 AI-Powered Job Matching

- **Smart Recommendations**: AI analyzes skills and experience to suggest suitable jobs
- **Two-way Matching**: Suggest developers to recruiters based on job requirements
- **Skill Gap Analysis**: Recommend skills to learn for career goals
- **Predictive Analytics**: Predict candidate success probability

### 💼 Job Marketplace

- Post job openings for full-time positions and freelance projects
- Advanced filtering and search with multiple criteria
- Real-time application status tracking
- Reviews and ratings from both parties

### 📊 Recruitment Management System

- Pipeline tracking for each candidate
- Interview scheduling and management
- Collaboration tools for hiring team
- Analytics and reporting dashboard
- Automated notifications and reminders

### 🌐 Social Networking

- News feed with tech content
- Groups and communities by tech stack
- Events and webinars
- Messaging and networking

## 🏗️ System Architecture

### Tech Stack Overview

```graph
┌───────────────────────────────┐
│        Frontend Layer         │
└───────────────────────────────┘
                ▼
┌───────────────────────────────┐
│        Traefik Gateway        │
│Load Balancing | Rate Limiting │
└───────────────────────────────┘
                ▼
┌───────────────────────────────┐
│        Backend Services       │
│ (Core domains, Edge services) │
└───────────────────────────────┘
                ▼
┌───────────────────────────────┐
│     Infrastructure Layer      │
│ PostgreSQL, Redis, Kafka, ELK │
└───────────────────────────────┘
```

### Core Technologies

#### Frontend

- **Framework**: Next.js 16+ with App Router and Turbopack
- **UI Library**: React 19 with Server Components & Actions
- **Styling**: TailwindCSS 4.x + Shadcn/ui
- **State Management**: Zustand / Redux Toolkit
- **Web3 Integration**: Web3.js, ethers.js, WalletConnect
- **Forms**: React Hook Form + Zod validation

#### Backend

- **Architecture**: Microservice with clean architecture
- **Core Domains**: Monolith source code with Spring Boot 4+ (Java 25 LTS)
- **Edge Services**: Keycloak 26 for IAM, Golang for Notification Service, AI Services with FastAPI
- **Infrastructure**: Traefix, PostgreSQL, Redis, Kafka, ELK stack

#### Message Queue & Streaming

- **Event Streaming**: Apache Kafka 3.8+
- **Message Queue**: RabbitMQ 4.0+
- **Real-time**: WebSocket, Server-Sent Events

#### Blockchain & Web3

- **Blockchain**: Ethereum (Mainnet/Testnet)
- **Storage**: IPFS (distributed file storage)
- **Smart Contracts**: Solidity
- **Web3 Provider**: Infura/Alchemy

## 📁 Project Structure

```sh
dev-sphere/
├── dev-sphere-web/           # Next.js application
├── dev-sphere-core/          # Core domain service
├── dev-sphere-ai/            # AI Powered service
├── dev-sphere-notification/  # Notification service
├── dev-sphere-contracts/     # Smart contracts
├── docker/                   # Dockerfile, compose and components
├── docs/                     # Project documents
└── README.md
```

## 🔧 Development

### Frontend Development

**Prerequisite:** `node` **>=24**, `npm` **>=11** or `pnpm` **>=10**

```bash
cd dev-sphere-web

# Development mode
pnpm run dev

# Build for production
pnpm run build

# Run tests
npm run test

# Lint code
npm run lint
```

### Backend Development

**Prerequisite:** `jdk` **>=25**

```bash
cd backend

# Run application
./mvnw spring-boot:run

# Run tests
./mvnw test

# Build JAR
./mvnw clean package

# Run with profile
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

## 📊 API Documentation

API documentation is automatically generated and accessible at:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

## 🤝 Contributing

We welcome all contributions! Please read [CONTRIBUTING.md](./CONTRIBUTING.md) for details.

### Development Workflow

1. Fork repository
2. Create feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open Pull Request

## 📝 License

This project is licensed under the MIT License. See the [LICENSE](./LICENSE) file for details.

## 📞 Contact & Support

- **Website**: <https://devsphere.io>
- **Email**: <support@devsphere.io>
- **Discord**: <https://discord.gg/devsphere>
- **Twitter**: [@DevSphere](https://twitter.com/devsphere)

## 🗺️ Roadmap

### Phase 1 - MVP (3/2026) ✅

- [ ] Basic user registration and authentication
- [ ] Profile creation and management
- [ ] Job posting and search
- [ ] Simple matching algorithm

### Phase 2 - Blockchain Integration (5/2026) 🚧

- [ ] Web3 wallet integration
- [ ] On-chain profile verification
- [ ] Smart contracts for job agreements
- [ ] IPFS integration for file storage

### Phase 3 - AI Enhancement (7/2026)

- [ ] Advanced ML matching algorithm
- [ ] Skill gap analysis
- [ ] Career path recommendations
- [ ] Automated resume parsing

### Phase 4 - Enterprise Features (9/2026)

- [ ] Advanced recruitment pipeline
- [ ] Team collaboration tools
- [ ] Analytics dashboard
- [ ] White-label solutions

### Future Features

- [ ] Video interview platform
- [ ] Coding challenge integration
- [ ] Reputation system with NFT badges
- [ ] DAO governance for platform decisions
- [ ] Multi-chain support
- [ ] Mobile applications (iOS/Android)

## 🙏 Acknowledgments

- Next.js team for the amazing framework
- Spring community for excellent documentation
- OpenZeppelin for secure smart contract libraries
- Hugging Face for AI/ML models
- All open-source contributors
