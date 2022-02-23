FROM azul/zulu-openjdk-alpine:8u292-8.54.0.21

ENV KAFKA_HOME /usr/local/kafka

RUN apk add --no-cache bash \
  && wget http://apache.cs.utah.edu/kafka/3.0.0/kafka_2.13-3.0.0.tgz \
  && tar -xzf kafka_2.13-3.0.0.tgz \
  && mv kafka_2.13-3.0.0 $KAFKA_HOME

COPY ./run-zookeeper-and-kafka.sh /scripts/
COPY ./custom-server.properties $KAFKA_HOME/config/
RUN chmod +x /scripts/run-zookeeper-and-kafka.sh

CMD ["/scripts/run-zookeeper-and-kafka.sh"]