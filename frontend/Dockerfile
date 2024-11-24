# Установка базового образа с Node.js
FROM node:18 AS build

# Указываем рабочую директорию
WORKDIR /app

ARG REACT_APP_BACKEND_URL
ENV REACT_APP_BACKEND_URL=${REACT_APP_BACKEND_URL}

# Копируем package.json и package-lock.json
COPY package*.json ./

# Устанавливаем зависимости
RUN npm install

# Копируем исходный код приложения
COPY . .

# Сборка React-приложения
RUN npm run build

# Финальный этап: создание минимального образа с Nginx для запуска приложения
FROM nginx:alpine

# Копируем собранное приложение в папку Nginx
COPY --from=build /app/build /usr/share/nginx/html

# Пробрасываем порт
EXPOSE 80

# Запуск Nginx
CMD ["nginx", "-g", "daemon off;"]
