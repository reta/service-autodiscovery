Service autodiscovery using Apache ZooKeeper
==============

### Please download and run Apache ZooKeeper first: 
 - http://zookeeper.apache.org/

### Run server, call service
 - java -jar jax-rs-2.0-service\target\jax-rs-2.0-service-0.0.1-SNAPSHOT.one-jar.jar 8080
 - curl http://localhost:8080/rest/api/people
 
### Run client
 - java -jar jax-rs-2.0-client\target\jax-rs-2.0-client-0.0.1-SNAPSHOT.one-jar.jar
