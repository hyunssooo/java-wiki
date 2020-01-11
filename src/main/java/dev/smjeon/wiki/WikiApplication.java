package dev.smjeon.wiki;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WikiApplication {
    private static final String PROPERTIES = "spring.config.location="
            + "classpath:/github.yml,"
            + "classpath:/kakao.yml,"
            + "classpath:/application.yml";

	public static void main(String[] args) {
        new SpringApplicationBuilder(WikiApplication.class)
                .properties(PROPERTIES)
                .run(args);
	}
}
