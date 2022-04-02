FROM openjdk:11

EXPOSE 9070

ADD target/customer-loan-provider.jar customer-loan-provider.jar

ENTRYPOINT ["java","-jar","customer-loan-provider.jar"]