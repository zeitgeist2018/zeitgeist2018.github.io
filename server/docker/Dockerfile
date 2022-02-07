FROM centos:centos8

ENV ENV prod

EXPOSE 7200

COPY build/libs/*.jar \
     /usr/local/app/

CMD  cd /usr/local/app && \
     java -cp "*" \
     es.cristianlm.Boot
