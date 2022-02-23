#!/bin/bash

#Zookeeper needs to be run before kafka

# start zookeeper with the default configurations provided in the kafka tar
$KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties &

# start kafka broker with the default configurations provided in the kafka tar
$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/custom-server.properties