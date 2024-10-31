# Sử dụng OpenJDK làm base image
FROM openjdk:17

# Thiết lập thư mục làm việc
WORKDIR /myapp

# Sao chép file JAR từ target vào thư mục làm việc
COPY target/employee-service-0.0.1-SNAPSHOT.jar /myapp/spring-employee-service.jar

# Khai báo port mà ứng dụng sẽ sử dụng
EXPOSE 8888

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "spring-employee-service.jar"]


## Xây dựng image
#docker build -t spring-employee-service .
#
## Chạy container
#docker run -p 8081:8081 spring-employee-service
#docker run -p 8877:8888 spring-employee-service

#docker tag tenimages tenrepo:0.1RELEASE

#docker push tenimage

#docker tag openzipkin/zipkin:latest phamngochai3010yka/microservice_tasc:zipkin
#
#docker push phamngochai3010yka/microservice_tasc:zipkin

#docker run --name mysql-phamhaiyka -e MYSQL_ROOT_PASSWORD=haihang2502 -d -p 3307:3306 mysql:latest

#docker exec -it mysql-phamhaiyka mysql -uroot -p
#
#SHOW DATABASES;



