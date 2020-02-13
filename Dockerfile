FROM openjdk:8

COPY ./build/libs/wiki-*.jar /usr/src/app/

WORKDIR /usr/src/app

CMD java -jar -Dspring.profiles.active=production /usr/src/app/wiki-*.jar