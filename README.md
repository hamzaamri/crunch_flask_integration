
# Crunch Integration with Yocto Project

This project demonstrates the integration of the **Crunch Chat Application** with Yocto, providing an embedded Linux environment with custom layers, image, and systemd service for application management. The project aims to boost Yocto skills through real-world application integration, dependency management, and automated startup processes.

## Project Overview

Crunch is a Flask-based chat application that supports user authentication and real-time communication. In this project, Crunch is integrated into a custom Yocto image, which includes a custom layer (`meta-crunch`), runtime dependencies, and a systemd service to automatically start the application at boot.

The goal is to provide a full Yocto-based embedded Linux environment where Crunch can run with necessary runtime dependencies, including Python packages and Cloudinary integration for media handling.

## Features

- **Yocto Layer Creation:** Custom `meta-crunch` layer to integrate Crunch into the Yocto build system.
- **Runtime Dependencies:** Integration of Python Flask runtime dependencies and package management using `pip`.
- **Custom Distro:** A custom Yocto distro built to enable `systemd` for application management.
- **Systemd Service:** A service created to start Crunch automatically at boot.
- **Python Package Management:** Automated installation of required Python packages via `pip` using a custom shell script.
- **Cloudinary Integration:** The application supports Cloudinary for managing images and media.

## Steps Implemented

1. **Layer Creation:** A new Yocto layer named `meta-crunch` was created to contain all recipes and configurations specific to Crunch.
2. **Recipe Development:** A recipe `crunch_git.bb` was created to fetch the Crunch application from GitHub and include it in the build system.
3. **Python Runtime Dependencies:** The runtime dependencies for Crunch, as listed in its `requirements.txt`, were integrated into the Yocto project.
4. **Custom Distro:** A custom Yocto distro was created to enable `systemd` for service management.
5. **Packagegroup Creation:** A custom package group was developed for all Flask-related recipes.
6. **Python3-pip Integration:** The `python3-pip` package was included as a runtime dependency to manage Python packages.
7. **Cloudinary Installation:** A shell script was created to install the Cloudinary Python package and run the Crunch application.
8. **Systemd Service:** A systemd service was created to ensure the Crunch application starts at boot.
9. **License Integration:** The MIT license from the Crunch project was applied to the repository.
10. **Custom Image Creation:** A custom image based on `core-image-minimal` was created to integrate the Crunch application.
11. **Testing:** The Crunch application was tested to ensure proper functionality and startup behavior.

## License

This project is licensed under the MIT License, as per the original Crunch project.

---


