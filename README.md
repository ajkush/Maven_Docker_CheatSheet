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
    
    EXPOSE 8080 :- (1)inside docker file
    docker run -p 8080:8080 -it rest-example    :- (2)map port
        
Dockerfile (Its Filename. w/o extension)

    FROM <image>, or FROM <image>:<tag>, or FROM <image>@<digest>
    MAINTAINER authors_name    
    ADD config.json projectRoot/ :- will add the config.json file to <WORKDIR>/projectRoot, archive extraction, downloading files through URL)
    COPY <source path or URL> <destination path > ):- (Simple to copy from Source to destination)
    RUN apt-get update
    RUN apt-get install -y openjdk-8-jre 
    CMD java -jar rest-example-0.1.0.jar
    LABEL "key"="value"
    ENV JAVA_HOME /var/lib/java8
    USER tomcat
    HEALTHCHECK --interval=5m --timeout=2s --retries=3 CMD curl -f http://localhost/ping || exit 1  
    
Creating an image using Maven
    Plugin:- https://github.com/fabric8io/docker-maven-plugin
    2 Tasks: 
        1.) Building and pushing Docker images which contain build artifacts
        2.) Starting and stopping Docker containers for integration testing and development.
    Fabric8 Docker plugin provides a couple of Maven goals:
        docker:build    docker:push    docker:start docker:stop docker:watch (it run docker:build, docker:run )  docker:remove  docker:volume-create, docker:volume-remove  
    
    
    Steps to build image using maven : 
    1.) Include plugin into maven.
    2.) Run build command ( mvn clean package docker:build )
    
        Maven Docker plugin config: 
            <configuration> have 2 tags: 
                <build> :- configuration specifying how images are built
                <run>:- configuration describing how containers should be created and started
                
                
                <plugin>
                    <groupId>io.fabric8</groupId>
                    <artifactId>docker-maven-plugin</artifactId>
                    <version>0.20.1</version>
                    <configuration>
                      <images>
                        <image>
                          <name>build-name:${project.version}
                          </name>
                          <alias>build-name</alias>
                          <build>
                            <from>openjdk:latest</from>
                            <assembly>
                              <descriptorRef>artifact</descriptorRef>
                            </assembly>
                            <cmd>java -jar maven/${project.name}-${project.version}.jar</cmd>
                          </build>
                          <run>
                            <wait>
                              <log>Hello World!</log>
                            </wait>
                          </run>
                        </image>
                      </images>
                    </configuration>
                  </plugin>
    
        
            Maven build command : mvn clean package docker:build
    
Maven CheatSheet:

    mvn spring-boot:run
    mvn -o clean install :- -o work offline
    mvn clean package
    mvn versions:display-dependency-updates
    
Git Command
    
    echo "# GitCheatSheet" >> README.md
    git init
    git add README.md
    git commit -m "first commit"
    git remote add origin https://github.com/ajkush/GitCheatSheet.git
    git push -u origin master
    
    git status
Create a new branch

    git checkout -b new-branch existing-branch

Switching between branches locally

    git checkout master
	
Show Branch

    git branch
    git branch -a
    
Stage your changes:
To add and discard changes

    (use "git add <file>..." to update what will be committed)
    (use "git checkout -- <file>..." to discard changes in working directory)

Commit your changes

    git commit -m "added my github name"

Remove Local Branch

    git branch -d the_local_branch

Remove or edit *staged* commit

	git commit -m "Something terribly misguided"
	git reset HEAD~
	<< edit your files files as necessary >>
	git add ...
	git commit -c ORIG_HEAD

Fetch / Pull forcefully all tha changes

	git fetch --all
	git reset --hard origin/master
	git pull origin master


Swagger:
    
    Include swagger and UI maven dependency and access below URL.
    http://localhost:8082/swagger-ui.html#/
    
Vue.js:

	npm install -g vue-cli
	npm install
	npm run dev

Http Response Codes:

	https://httpstatuses.com


Feign declerative client:

	enable logging:
	
	feign:
	  client:
	    config:
	      default:
		loggerLevel: FULL
	
	Add property: 
	
		logging.level.<package>.ApiClient=DEBUG
		
Check application Performance:

		<dependency>
		  <groupId>org.openjdk.jmh</groupId>
		  <artifactId>jmh-core</artifactId>
		  <version>1.17.4</version>
		</dependency>
		<dependency>
		  <groupId>org.openjdk.jmh</groupId>
		  <artifactId>jmh-generator-annprocess</artifactId>
		  <version>1.17.4</version>
		</dependency>		


Kubernetes :

	minikube stop
	minikube delete
	minikube status
	minikube start
	minikube addons enable ingress
	minikube dashboard
	minikube ip

	helm list

	Delete and apply stable release:
	helm delete <SERVICE>
	helm repo add nginx-stable https://helm.nginx.com/stable
	helm install nginx-ing nginx-stable/nginx-ingress
	helm install -f values.yaml --set vault.roleId=<ROLEID> --set vault.secretId=<SECRETID> <SERVICE> .

	kubectl get all
	kubectl get ing
	kubectl get ing --all-namespaces
	kubectl edit po <POD>

	kubectl get endpointslices
