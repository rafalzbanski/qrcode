# QR Code Generator Application

This is a Spring Boot web application that generates QR codes based on user input. It allows you to customize the content, size, error correction level, and image format of the generated QR code. The generated QR code can be viewed directly in the browser or downloaded as a PDF.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [License](#license)

## Features

- Generate QR codes with customizable content.
- Choose different error correction levels (L, M, Q, H).
- Generate QR codes in different sizes (150x150 to 350x350).
- Generate QR codes in different formats (PNG, JPEG, GIF).
- Save the generated QR code as a PDF.

## Technologies

This project uses the following technologies:

- Java 17
- Spring Boot 3.3.3
- Thymeleaf for server-side HTML rendering
- Google ZXing for generating QR codes
- jsPDF for saving QR codes as PDFs
- Bootstrap 5.1.3 for frontend styling

## Project Structure

```plaintext
src
├── main
│   ├── java
│   │   └── pl
│   │       └── rafalzbanski
│   │           └── qrcode
│   │               ├── app
│   │               │   └── QRCodeApplication.java   // Main application class
│   │               ├── config
│   │               │   ├── BufferedImageHttpMessageConverter.java   // Handles BufferedImage HTTP conversion
│   │               │   └── QRConfig.java   // Spring configuration
│   │               ├── controller
│   │               │   └── QRCodeController.java   // Handles QR code generation requests
│   │               └── service
│   │                   └── QRCodeService.java   // Business logic for generating QR codes
│   └── resources
│       ├── static
│       └── templates
│           └── qrcode.html   // Thymeleaf template for QR code generation
├── test
│   └── java
├── build.gradle               // Project build configuration
└── README.md                  // Project documentation
```
## Installation

### Prerequisites

- Java 17
- Maven or Gradle build system
- Spring Boot 3.3.3

### Clone the Repository

```bash
git clone https://github.com/rafalzbanski/qrcode.git
cd qrcode-generator
```

### Build the Project
Bbuild the project using Gradle:

```bash
./gradlew build
```

If you'd like to clean and then build the project:
```bash
./gradlew clean build
```
## Running the Application

After building the project, you can run the application using:

```bash
./gradlew bootRun
```
The application will start, and it will be accessible at [http://localhost:8080/api/](http://localhost:8080/api/).

## Usage

1. Open your browser and navigate to [http://localhost:8080/api/](http://localhost:8080/api/).
2. Fill out the form:
   - Enter the desired content (text or URL) in the "Contents" field.
   - Specify the QR code size between 150-350 (default is 250).
   - Choose the error correction level (`L`, `M`, `Q`, `H`) or leave it as the default (`L`).
   - Select the image type (`png`, `jpeg`, or `gif`), or use the default (`png`).
3. Click the "Generate QR Code" button to generate and display the QR code.
4. To save the generated QR code as a PDF, click the "Save as PDF" button.

### Example Input
- **Contents**: https://example.com
- **Size**: 300
- **Error Correction Level**: M
- **Image Type**: PNG

## Endpoints

- **GET /api/qrcode**  
  This API endpoint generates a QR code based on the provided parameters.

  - **Query Parameters**:
    - `contents` (required): The text or URL to encode in the QR code.
    - `size` (optional): The size of the QR code (150-350). Default is 250.
    - `correction` (optional): The error correction level (`L`, `M`, `Q`, `H`). Default is `L`.
    - `type` (optional): The image type (`png`, `jpeg`, `gif`). Default is `png`.

  Example request:

GET [/api/qrcode?contents=https://example.com&size=300&correction=M&type=png](/api/qrcode?contents=https://example.com&size=300&correction=M&type=png)


This request will generate a PNG QR code with:
- **Contents**: `https://example.com`
- **Size**: `300x300 pixels`
- **Error Correction Level**: `M` (Medium)
- **Type**: PNG image format

This endpoint serves the homepage with the QR code generation form, which allows you to generate QR codes by filling out the fields and submitting the form.

## License

This project is licensed under the MIT License. See the [LICENSE](https://choosealicense.com/licenses/mit/) for more details.
