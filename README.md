
# User Authentication and Encryption Project

## Overview

This Java project provides a simple user authentication system combined with a basic encryption utility. It consists of two main classes:

- **`User`**: Manages user creation, including setting a strong password.
- **`Encryption`**: Handles encryption and decryption of strings, requiring user authentication.

## Features

- **User Management**:
  - Prompts for username and password.
  - Validates password strength to ensure security.

- **Encryption and Decryption**:
  - Encrypts strings with additional metadata using Base64 encoding.
  - Decrypts strings only after successful user authentication.

## Requirements

- Java Development Kit (JDK) 21 or higher
- Basic understanding of Java programming


### Encryption and Decryption Workflow

1. **Encrypt a String**:
   - Enter a string to encrypt.
   - The application will display the encrypted string.

2. **Decrypt a String**:
   - Enter your username and password to authenticate.
   - If the credentials are correct, the application will decode and display the original string.
