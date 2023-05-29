# Clean Architecture Cryptocurrency App Jetpack Compose 

This Android application is built using clean architecture principles, showcasing the implementation of various modern technologies and libraries. The app follows the MVVM (Model-View-ViewModel) architectural pattern and utilizes Use Cases for business logic separation. It leverages Jetpack Compose for building the user interface.

## Technologies and Libraries Used
- Kotlin: The primary programming language for Android development.
- Dagger-Hilt: Dependency injection framework for managing dependencies.
- Retrofit: A type-safe HTTP client for making API requests.
- Jetpack Compose: A modern UI toolkit for building native Android UIs.
- Flows: Kotlin's reactive streams for handling asynchronous operations.


## Architecture
The app follows the principles of Clean Architecture, ensuring a separation of concerns and testability. It consists of the following layers:
- Presentation: Contains UI components, ViewModels, and Compose UI code.
- Domain: Defines business logic and Use Cases.
- Data: Implements data sources, repositories, and network communication.
- Framework: Includes framework-specific implementations, such as Dagger-Hilt and Retrofit.

## Setup Instructions
1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the app on an emulator or physical device.
4. Customize the code to fit your specific requirements.

## Contribution Guidelines
Contributions to this project are welcome. Please follow the guidelines outlined in the CONTRIBUTING.md file to contribute.

## License
This project is licensed under the [MIT License](LICENSE.txt). Feel free to use, modify, and distribute the code as per the license terms.

For any questions or support, please contact Pankaj Jangid at pankaj0619@gmail.com.
