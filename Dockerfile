FROM openjdk:8
WORKDIR /source
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JHIPSTER_SLEEP=0 \
    JAVA_OPTS=""
RUN curl -sL https://deb.nodesource.com/setup_12.x | bash -
RUN apt-get install -y nodejs rsync tree nfs-utils
RUN mkdir /mnt/storage
RUN mount -t nfs 10.100.10.5:/documentos /mnt/storage
COPY . /source
RUN rm -f ./.gitignore
RUN rm -f ./.gitattributes
RUN npm install
RUN ./mvnw package -Pprod -DskipTests
RUN rsync -av --ignore-existing ./ /source/
RUN cp -a target/*.war /app.war
RUN rm -rf /source/*
CMD echo "The application will start in ${JHIPSTER_SLEEP}s..." && \
   sleep ${JHIPSTER_SLEEP} && \
   java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.war
EXPOSE 8443
