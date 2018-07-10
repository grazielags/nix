package nix.config;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@ComponentScan("nix.api")
public class SwaggerConfiguration {

	public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";

	@Value(value = "${info.version}")
	private String version;

	@Value(value = "${spring.application.name}")
	private String application;

	@Bean
	public Docket customImplementation() {
		ApiInfo apiInfo = new ApiInfo(application, "SIGA", version, "", "", "", "");
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).genericModelSubstitutes(ResponseEntity.class)
				.forCodeGeneration(true).genericModelSubstitutes(ResponseEntity.class)
				.directModelSubstitute(java.time.LocalDate.class, String.class)
				.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
				.directModelSubstitute(java.time.LocalDateTime.class, Date.class)
				.select().paths(regex(DEFAULT_INCLUDE_PATTERN)).build();
	}
	
}
