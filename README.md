# plastiq-memry-cards

Plastiq Memry Cards is a cloud-based flashcard application suitable for learning. Its a work in progress and currently very pre-release with errors, unfinished code, commented out code blocks and all the other embarrassing things usually hidden away on full display.

Its a Java 21 & Spring-based application, with an Angular front-end and Redis back-end, suitable for cloud deployment.

Built with the principles of Domain Driven Design, OOP, and SOLID, it also uses a gateway as single point of entry, enabling separation of the front-end from the database services thereby increasing security as well as throughput performance, when used with k8s horizontal scaling abilities.

It also demonstrates GRPC and Protocol Buffers.