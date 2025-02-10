# Spring Security Example Project

Этот проект демонстрирует базовую интеграцию Spring Security в Spring Boot приложение. Он включает в себя примеры настройки аутентификации, авторизации и защиты endpoints.

## Описание

Проект создан для изучения и демонстрации возможностей Spring Security. В нем реализованы следующие функции:

- Базовая аутентификация (Basic Authentication)
- Настройка ролей пользователей (User Roles)
- Защита endpoints в зависимости от ролей
- Пример кастомной конфигурации безопасности

## Технологии

- Java 17
- Spring Boot 3.x
- Spring Security
- Maven

## Запуск проекта

1. Клонируйте репозиторий:

    ```bash
   git clone https://github.com/SirRamzi/spring-security.git
    ```
2. Перейдите в директорию проекта:
    ```bash
   cd spring-security
    ```
3. Соберите проект с помощью Maven:
    ```bash
   mvn clean install
   ```
4. Запустите приложение:
    ```bash
   mvn spring-boot:run
   ```
5. Приложение будет доступно по адресу: http://localhost:8080.