# Проек для демонстрации docker-compose

## Запуск приложения
Для запуска приложения выполните одну из следующих команд, в зависимости от установленной версии Docker Compose:
```
docker-compose up --build
```
или
```
docker compose up --build
```

## Примечание для старых версий Docker Compose
В старых версиях Docker Compose необходимо явно указывать версию формата YAML-файла. Для этого в начале файла docker-compose.yaml добавляется ключ version, например:
```
version: "3.8"

services:
  app:
    image: my-app
    ...
```
Подробнее о версиях и их возможностях можно узнать в официальной документации Docker Compose.