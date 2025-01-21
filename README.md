# Spring AI Introduction App

## Overview
This application serves as an introduction to integrating Spring with OpenAI APIs. It is designed to provide information about cities or answer general questions using natural language processing powered by OpenAI.  

The project is structured following the MVC (Model-View-Controller) pattern to ensure clarity, scalability, and maintainability.  

---

## Features
- **City Information Fetching**: Query detailed information about cities using OpenAI's APIs.  
- **Q&A Functionality**: Ask general questions and receive AI-generated responses.  
- **MVC Architecture**:  
  - **Controller**: Exposes an API endpoint to handle requests.  
  - **Model**: Defines request and response structures for clean data processing.  
  - **Service Layer**: Handles communication with OpenAI APIs, leveraging advanced tools like:  
    - `PromptTemplate`  
    - `ChatModel`  
    - `ChatResponse`  
    - Other OpenAI functions to process and generate responses effectively.  

---

## Technologies Used
- **Spring Framework**: To build a robust, scalable backend application.  
- **OpenAI API**: For natural language processing and AI-powered responses.  
- **Java**: Core programming language for the application logic.  

---

## Getting Started
### Prerequisites
- Java 21 or higher  
- Maven
- OpenAI API Key  
