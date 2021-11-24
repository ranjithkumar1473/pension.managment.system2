package pension.managment.system2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pension.managment.system2.Application;

@SpringBootApplication
public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		
		LOG.info("Start");
		SpringApplication.run(Application.class);
		LOG.info("End");

	}

}
