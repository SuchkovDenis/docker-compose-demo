#!/bin/sh

# Подставляем переменные окружения в шаблон nginx.conf
envsubst '${BACKEND_HOST} ${BACKEND_PORT}' < /etc/nginx/templates/default.conf.template > /etc/nginx/conf.d/default.conf

# Запускаем Nginx
exec "$@"
