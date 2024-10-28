package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// logstash.bat -f 'c:\logstah-8.15.2\config\xxx.conf'
/*
 *   input {
  jdbc {
    jdbc_driver_library => "C:\logstash-8.15.2\lib\mysql-connector-j-8.0.33.jar"
    jdbc_driver_class => "com.mysql.jdbc.Driver"
    jdbc_connection_string => "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC"
    jdbc_user => "root"
    jdbc_password => "happy"
    statement => "SELECT * FROM PRODUCT"
  }
}

output {
  elasticsearch {
    hosts => ["http://127.0.0.1:9200"]
    index => "product"
    document_type => "_doc"
    #user => "elastic"
    #password => "changeme"
  }
}

elasticsearch => yml 
   Enable security features  => false변경
   xpack.security.enabled: false
   xpack.security.enrollment.enabled: true


 */
@SpringBootApplication
public class SpringBootProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject1Application.class, args);
	}

}
