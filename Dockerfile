FROM tomcat:jdk17
EXPOSE 8080 
ADD http://docker:'Te$t1234'@192.168.56.103:8082/artifactory/assignment-snapshot/com/ss/WebCalculator/0.0.1-SNAPSHOT/WebCalculator-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]
