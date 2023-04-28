
# Springboot and RabbitMq via Docker



## Information

 - it is a structure of message-queueing
 - RabbitMQ just transfers data which is coming from Producer to its subcriber which is called as Consumer by turns
 - Here is the explanation of the project
    - In Producer part, the project sends a message containg text or POJO to Rabbit Server
    - As Producer has no idea about queue , the message is transmitted to the queue over the exchange according to the queue routing key
    - Then Consumer part listens the queue which works with FIFO logic and consume the message. After that, it completes the process
## Run the App
1) Install Docker Desktop. Here is the installation link : https://docs.docker.com/docker-for-windows/install/
2) Open Terminal under resources folder to run RabbitMq on Docker Container
   