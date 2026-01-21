# DevSphere - SRS

## 1. Introduction

### 1.1 Purpose

Tài liệu này mô tả chi tiết các yêu cầu chức năng và phi chức năng của hệ thống **DevSphere**, nhằm làm cơ sở cho việc:

- Phát triển phần mềm
- Kiểm thử
- Triển khai
- Bảo trì và mở rộng hệ thống

## 1.2 Scope

DevSphere là một nền tảng mạng nghề nghiệp dành cho lập trình viên, tích hợp:

- AI-powered recruitment
- Web3 / Blockchain verification
- Social networking
- Enterprise recruitment management

## 1.3 Definitions, Acronyms

- AI: Artificial Intelligence
- IAM: Identity and Access Management
- ATS: Applicant Tracking System
- Web3: Blockchain-based identity & data ownership

---

## 2. Overall Description

### 2.1 Product Perspective

Hệ thống được xây dựng theo kiến trúc **Microservices**, bao gồm:

- Frontend (Next.js)
- Backend Core Services (Spring Boot)
- AI Services (FastAPI)
- Blockchain Layer (Ethereum + IPFS)

### 2.2 User Classes

| User Class | Description |
| ----------- | ------------- |
| Developer | Người tìm việc, quản lý hồ sơ cá nhân |
| Recruiter | Người tuyển dụng |
| Org Admin | Quản lý tổ chức |
| System Admin | Quản trị hệ thống |

### 2.3 Operating Environment

- Web browser hiện đại
- Cloud-native infrastructure
- Blockchain networks (Ethereum)

## 3. Functional Requirements

### FR-01: User Registration & Authentication

- Hệ thống phải cho phép đăng ký bằng email, OAuth hoặc Web3 wallet
- Hệ thống phải hỗ trợ phân quyền theo vai trò

### FR-02: Profile Management

- Developer có thể tạo, chỉnh sửa, versioning profile
- Profile phải hỗ trợ rollback

### FR-03: Portfolio Management

- Cho phép upload portfolio
- Lưu trữ file qua IPFS

### FR-04: Job Posting & Search

- Recruiter đăng tin tuyển dụng
- Cho phép tìm kiếm nâng cao

### FR-05: Job Application

- Developer ứng tuyển
- Theo dõi trạng thái ứng tuyển

### FR-06: AI Matching

- Hệ thống phải sinh matching score
- Giải thích được kết quả (Explainable AI)

### FR-07: Recruitment Pipeline

- Quản lý các giai đoạn tuyển dụng
- Ghi chú nội bộ

## FR-08: Blockchain Verification

- Xác thực kỹ năng on-chain
- Smart contract cho job agreement

---

## 4. Non-Functional Requirements

### 4.1 Performance

- Response time < 300ms (P95)
- AI inference < 1s

### 4.2 Security

- OAuth2 / OIDC
- Encryption at rest & in transit
- User-owned data

### 4.3 Scalability

- Horizontal scaling
- Event-driven (Kafka)

### 4.4 Audit & Compliance

- Full audit log
- GDPR compliance

---

## 5. External Interface Requirements

### 5.1 User Interface

- Web-based UI
- Responsive design

### 5.2 API Interface

- REST / GraphQL
- OpenAPI documented

### 5.3 Blockchain Interface

- Ethereum RPC
- IPFS gateway
