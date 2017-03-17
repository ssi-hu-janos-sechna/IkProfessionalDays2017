FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
RUN gradle clean assemble
ADD /buil/libs/ConfigServer-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]