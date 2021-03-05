FROM openjdk:8
WORKDIR /source
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JHIPSTER_SLEEP=0 \
    JAVA_OPTS=""
RUN curl -sL https://deb.nodesource.com/setup_12.x | bash -
RUN apt-get install -y nodejs rsync tree nfs-common rstat-client  rstatd && \
    apt-get clean
RUN echo "rpcbind : 10.100.10.0/24 127.0.0.1" >> /etc/hosts.allow && \
    mkdir -p /run/sendsigs.omit.d && \
    touch /run/sendsigs.omit.d/rpcbind
RUN update-rc.d rpcbind enable && update-rc.d nfs-common enable && \
    /etc/init.d/nfs-common start && \
    /etc/init.d/rpcbind start
RUN mkdir /mnt/storage && \
    mount -t nfs  -o nolock 10.100.10.5:/documentos /mnt/storage
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
