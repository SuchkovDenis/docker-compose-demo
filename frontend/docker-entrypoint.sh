#!/bin/sh

# Add ENV variables to nginx.conf
envsubst '${BACKEND_HOST} ${BACKEND_PORT}' < /etc/nginx/templates/default.conf.template > /etc/nginx/conf.d/default.conf

# Run Nginx
exec "$@"
