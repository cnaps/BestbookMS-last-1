# BestBookMS

- 도메인 모델

![image](https://github.com/cnaps/BestBookMS/assets/15258916/1d4260a9-b866-466e-b1dd-e01f72152603)

- 도메인 모델과 구현 모델 차이
  - listBestBook은 BestBook의 책임이 아님
 
- 로컬에 몽고DB가 설치되어 있지 않고, 환경설정이 되지 않으면 빌드 에러 


- 몽고 DB 
  - 컨테이너로 생성
  ```
    docker run -d -p 27017:27017 --name mongodb mongo
  ```
 - GUI로 몽고 db관리 
   - MongoDB Compass
   - https://www.mongodb.com/try/download/atlascli

- 문제 해결
  - swagger-ui 가 보이지 않을 때
    - 스프링 부트 버전을 확인 할 것 : 2.7.4에서는 성공

- 도커 파일 생성
  - Dockerfile 생성
  ```
    FROM adoptopenjdk/openjdk11
    CMD ["./mvnw", "clean", "package"]
    ARG JAR_FILE_PATH=target/*.jar
    COPY ${JAR_FILE_PATH} app.jar
    EXPOSE 8080
    ENTRYPOINT ["java", "-jar", "app.jar"]
     ```

- 빌드
  - 어플리케이션 빌드

    ```
    mvn clean package 
    ```

- 컨테이너 생성
  - 도커 컨테이너 이미지 생성

    ```
     docker build -t bestbookms:0.0.1 . 
    ```

    ```
    docker image 
    ```

  - 도커 컨테이너 실행

    ``` 
    docker run --name bestbookMS --network demonet -p 8083:8084 bestbookms:0.0.1
    ```
