# Kafka Commands

---
## Create Topic
---

Create a topic named my-topic with partition count three and replication-factor 3:

```
./kafka-topics.sh --zookeeper localhost:2181 --create --topic my-topic --partitions 3 --replication-factor 3
```

## List all the topics
---
List all the topics in the kafka cluster

```
./kafka-topics.sh --zookeeper localhost:2181 --list
```

## Describe a topic
---
Describe an individual topic

```
./kafka-topics.sh --zookeeper localhost:2181 --topic my-topic --describe
```

> Topic:my-topic	PartitionCount:3	ReplicationFactor:3	Configs:
	Topic: my-topic	Partition: 0	Leader: 1	Replicas: 1,2,0	Isr: 1,2,0
	Topic: my-topic	Partition: 1	Leader: 2	Replicas: 2,0,1	Isr: 2,0,1
	Topic: my-topic	Partition: 2	Leader: 0	Replicas: 0,1,2	Isr: 0,1,2




