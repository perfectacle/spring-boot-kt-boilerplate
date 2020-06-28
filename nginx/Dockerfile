FROM nginx:alpine
RUN apk add logrotate
COPY /conf/logrotate/nginx /etc/logrotate.d
COPY /conf/logrotate/logrotate.conf /etc/logrotate.conf
CMD ["nginx", "-g", "daemon off;"]