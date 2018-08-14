package com.sample.swagger.config;

import com.fasterxml.classmate.TypeResolver;
import com.sample.swagger.dto.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private TypeResolver typeResolver;
    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sample.swagger.controller"))
                .build()
                .apiInfo(this.getApiInfo("tester123", "1.0.0"));
//        return new Docket(DocumentationType.SWAGGER_2)
//                .additionalModels(typeResolver.resolve(TestDTO.class));
    }
    private ApiInfo getApiInfo(String title, String version) {
        return new ApiInfoBuilder()
                .title(title)
                .version(version)
                .build();

    }
    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sample.swagger.controller"))
                .paths(PathSelectors.regex("/user.*"))
                .build()
                .groupName("user");
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("test");
    }
}
