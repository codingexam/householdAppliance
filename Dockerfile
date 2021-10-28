FROM java:8

EXPOSE 8090

ADD target/householdAppliance.jar householdAppliance.jar

ENTRYPOINT ["java","-jar",householdAppliance.jar]