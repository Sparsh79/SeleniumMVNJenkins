FROM openjdk:8-jre-alpine

COPY out/artifacts/SeleniumMVNJenkins_jar2

CMD java -jar SeleniumMVNJenkins_jar2.jar