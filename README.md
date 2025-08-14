# Rebooked Backend

A Spring Boot application that serves as the backend for the Rebooked platform, a book trading and sharing marketplace.

## Technologies Used

- Java 21
- Spring Boot
- MongoDB
- Gradle
- JWT Authentication
- OpenAPI (Swagger) Documentation
- Cloudinary for Image Storage
- Gmail SMTP for Email Services

## Prerequisites

- JDK 21 or later
- MongoDB
- Gradle
- A Cloudinary account
- Gmail account (for email services)

## Environment Variables

```env
BASE_URL=http://localhost:6001/api
CLIENT_URL=http://localhost:3000
CLOUDINARY_API_KEY=your_cloudinary_key
CLOUDINARY_API_SECRET=your_cloudinary_secret
CLOUDINARY_FOLDER_NAME=your_folder_name
CLOUDINARY_NAME=your_cloudinary_name
EMAIL_HOST=gmail
EMAIL_PASSWORD=your_app_specific_password
EMAIL_USER=your_email@gmail.com
GOOGLE_CLIENT_ID=your_google_client_id
GOOGLE_CLIENT_SECRET=your_google_client_secret
JWT_EXPIRATION_TIME=3600000
MONGODB_URI=mongodb://localhost:27017/rebooked
PORT=5001
SECRET_KEY=your_jwt_secret_key
```

## Getting Started

1. Clone the repository:

```bash
git clone https://github.com/yourusername/rebooked-backend.git
cd rebooked-backend
```

2. Set up environment variables:

   - Create a copy of the environment variables listed above
   - Replace the placeholder values with your actual credentials

3. Start MongoDB:

```bash
mongod
```

4. Run the application:

```bash
./gradlew bootRun
```

The application will start on the specified PORT (default: 5001).

## API Documentation

Once the application is running, you can access the Swagger UI documentation at:

```
http://localhost:5001/api/documentation
```

## Features

- User Authentication (JWT)
- Social Login (Google, Facebook)
- Email Verification
- Password Reset
- Book Management
- Category Management
- Chat System
- File Upload (Cloudinary)

## API Endpoints

### Authentication

- POST `/auth/register` - Register a new user
- POST `/auth/login` - User login
- POST `/auth/google/login` - Google login
- POST `/auth/facebook/login` - Facebook login
- GET/POST `/auth/confirm-email` - Email verification
- GET/POST `/auth/forgot-password` - Password reset

### Categories

- GET `/categories` - Get all categories
- GET `/categories/top` - Get top categories by book count

### Books

- CRUD operations for books
- Book search and filtering
- Book trading functionality

## Development

To run tests:

```bash
./gradlew test
```

To build the project:

```bash
./gradlew build
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
