# saga-pattern-spring-boot-demo
Demonstration of SAGA Orchestration Design Pattern using Spring Boot and Kafka
Saga Demo
├── Orders ├── Products ├── Payments ├── Credit Card Processor

**Full FLow:**
Client
|
v
Orders Service
(Producer)
|
| OrderCreatedEvent
v
orders-events
|
| Consumer
v
OrderSaga
|
| Producer
| ReserveProductCommand
v
products-commands
|
| Consumer
v
Products Service
|
| Producer
| ProductReservedEvent
v
products-events
|
| Consumer
v
OrderSaga
|
| Producer
| ProcessPaymentCommand
v
payments-commands
|
| Consumer
v
Payments Service
|
| Producer
| PaymentProcessedEvent
v
payments-events
|
| Consumer
v
OrderSaga
|
| Producer
| ApproveOrderCommand
v
orders-commands
|
| Consumer
v
Orders Service
|
| Producer
| OrderApprovedEvent
v
orders-events
|
| Consumer
v
OrderSaga
------------------------------------------
Orders Service  → Producer First Event
OrderSaga       → Consumer Events + Producer Commands
Products Service→ Consumer Command + Producer Event
Payments Service→ Consumer Command + Producer Event
Orders Service  → Consumer Approve Command + Producer Approved Event
-----------------------------------------------------------------------------
Event = Event already happened like:  OrderCreatedEvent, PaymentProcessedEvent
Command = Ask from other service to do something like: ReserveProductCommand, ApproveOrderCommand.