FROM fabric8/tomcat-7:latest
EXPOSE 8080
ADD http://docker:'Te$t1234'@http://192.168.56.103:8082/artifactory/assignment-snapshot /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]
