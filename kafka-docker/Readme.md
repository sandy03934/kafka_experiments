# Kafka Commands

---
## Create Topic
---

Create a topic named my-topic with partition count three and replication-factor 3:

````
docker-compose exec kafka  kafka-topics --create --topic test --partitions 1 --replication-factor 1 --if-not-exists --zookeeper zookeeper:2181
````
