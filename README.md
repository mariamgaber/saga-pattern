# saga-pattern-spring-boot-demo
Demonstration of SAGA Orchestration Design Pattern using Spring Boot and Kafka
Saga Demo
├── Orders ├── Products ├── Payments ├── Credit Card Processor

**Full FLow:**
Client
│
▼
Orders Service
│
▼
OrderCreatedEvent
│
▼
──────────── OrderSaga ────────────
│
▼
ReserveProductCommand
│
▼
Products Service
│
▼
ProductReservedEvent
│
▼
──────────── OrderSaga ────────────
│
▼
ProcessPaymentCommand
│
▼
Payment Service
│
▼
PaymentProcessedEvent
│
▼
──────────── OrderSaga ────────────
│
▼
ApproveOrderCommand
│
▼
Orders Service
│
▼
OrderApprovedEvent
│
▼
──────────── OrderSaga ────────────
│
▼
Order Status = APPROVED
------------------------------------------
Event = Event already happened like:  OrderCreatedEvent, PaymentProcessedEvent
Command = Ask from other service to do something like: ReserveProductCommand, ApproveOrderCommand.