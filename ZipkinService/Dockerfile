FROM java:alpine
RUN apk add --update curl && \
    rm -rf /var/cache/apk/*

VOLUME /tmp
ADD ZipkinService-1.0.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]