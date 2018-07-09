Docker Images: 

	Instructions are placed in the Dockerfile, Dockerfile is used to create docker image.
	Docker is natively supported in Linux, but has to be run in a VM on Windows and macOS.
	Docker image is used to run java code(not Dockerfile).
 

Docker Container:


	A running instance of an image is called a container. Docker launches them using the Docker images as read-only templates. 
	
	
    Run Docker
	docker run [OPTIONS] IMAGE [COMMAND] [ARG...]
	docker stop  :- Stop container, data loss
	docker ps -a 	:- Docker client will list a table containing container IDs
	docker rm $(docker ps -a -q -f status=exited)  	:- Remove container
	docker commit <container-id> <image-name> 	:- commit writable changes
    
    docker search <image-name>  :- Search docker image
    docker pull ubuntu:16.04  :- Pull docker image
    
    
Docker Networking:


    docker network ls  :- Docker will output the list of available networks containing
    docker network create  <network name>
    docker run -it --net=<network name> <application>  :- eg docker run -it --net=myNetwork tomcat  
    docker network rm
    docker network connect
    docker network disconnect
    docker network inspect
        

Maven CheatSheet:

    mvn spring-boot:run