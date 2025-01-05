Distributed Chat Application

This is a monolithic distributed chat application built using Spring Boot, WebSocket, and MongoDB for real-time messaging. It allows users to:

    Register an account.
    Send and receive one-on-one messages.
    Create and participate in group chats.
    Supports real-time communication using WebSocket.

Tech Stack

    Backend: Spring Boot
    Database: MongoDB
    Real-Time Communication: WebSocket (STOMP)
    Frontend: HTML, JavaScript, Thymeleaf (for rendering views)
    Message Queue: (Optional for future scalability, we can add Kafka or Redis)

Features

    User Registration: Users can create an account with a username and password.
    One-on-One Messaging: Users can send direct messages to other users.
    Group Chat: Users can create or join a group chat and send messages to the group.
    Real-Time Messaging: Messages are sent and received in real-time using WebSocket.

Prerequisites

    MongoDB should be running locally or remotely. Default connection is mongodb://localhost:27017/chatdb.
    Java 8 or higher should be installed.
    Maven should be installed for building the project.

Getting Started
1. Clone the repository

git clone https://github.com/yourusername/distributed-chat-app.git
cd distributed-chat-app

2. Set up MongoDB

Ensure that MongoDB is running locally or on a remote server, and update the connection string in application.properties.

spring.data.mongodb.uri=mongodb://localhost:27017/chatdb

3. Run the Application

To run the application, use the following Maven command:

mvn spring-boot:run

Once the application starts, you can access it by visiting http://localhost:8080.
4. Register a User

    Enter a username and password on the registration page (index.html).
    Once registered, you will be redirected to the Dashboard where you can start sending messages.

5. Send Messages

    In the dashboard, you can:
        Send direct messages to other users.
        Create a group and send group messages.

WebSocket Integration

    The chat uses WebSocket (via STOMP) for real-time communication.
    When a user sends a message, the message is broadcasted to the recipient or group in real time.
    WebSocket endpoints are available at /chat for clients to connect.

Application Structure
src/main/java/com/chat

    controller: Contains ChatController.java, which handles HTTP requests and WebSocket communication.
    model: Defines the User.java and Message.java models.
    repository: Contains MongoDB repositories for User and Message.
    service: Implements business logic for chat features (sending messages, retrieving messages, etc.).
    websocket: Configures WebSocket for real-time messaging.

src/main/resources

    application.properties: Configuration file for MongoDB and WebSocket.
    static/index.html: The user registration page.
    static/dashboard.html: The main chat interface where users send and receive messages.

Future Enhancements

    Authentication: Add JWT-based authentication for user management.
    Scalability: Integrate Kafka or Redis for message queuing and better scalability.
    File Sharing: Allow users to send images and other files in messages.
    Notifications: Implement push notifications when a new message is received.

License

This project is licensed under the MIT License - see the LICENSE file for details.