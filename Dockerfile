FROM tomcat:jdk17
COPY ./target/DemoMVC.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080 
# ADD http://docker:'Te$t1234'@192.168.56.104:8082/artifactory/assignment-snapshot/com/ss/WebCalculator/0.0.1-SNAPSHOT/WebCalculator-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
ENTRYPOINT ["catalina.sh", "run"]
