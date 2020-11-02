package com.imooc.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile({"dev","test"})
public class SwaggerConfig {

    @Bean // 配置docket以配置Swagger具体参数
    public Docket docket(Environment environment) {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())// 关联配置文档
                .enable(true)// 是否启用
                .select()//扫描方法
                .apis(RequestHandlerSelectors.basePackage("com.imooc.mall.controller"))//扫描包路径
                .paths(PathSelectors.any())//路径过滤
                .build();//构建
    }

    // 配置文档信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot-Swagger2集成")
                .description("API描述")
                .contact("联系人名字")
                .version("1.0")
                .build();
    }

}
