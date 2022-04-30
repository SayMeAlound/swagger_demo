package com.zhao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Auther: zhaomo
 * @Date: 2020/03/30 21:01
 * @Description:
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    //配置了Swagger的Docket的bean实例
    //enable是否启动swagger,如果为false则swagger不能再浏览器中访问
    @Bean
    public Docket docket(Environment environment){

        Profiles profiles = Profiles.of("dev");

        //获取生产项目环境  判断是否处在自己设置的环境当中
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("zhaomo")
                .enable(flag)
                .select()
                //RequestHandlerSelectors  配置要扫描接口的方式
                // basePackage :指定要扫描的包
                //any() 扫描全部
                //none()   不扫描
                //withClassAnnotation:    扫描类上的注解
                //withMethodAnnotation:  扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.zhao.controller"))
                // paths 过滤什么路径
                // .paths(PathSelectors.ant("/zhao/**"))
                .build();
    }

    //配置Swagger信息 apiInfo
    private ApiInfo apiInfo(){

        Contact contact = new Contact("zhaomo", "http://www.baidu.com", "1598575883@qq.com");
        return new ApiInfo(
                        "ZhaoMo的API文档",
                        "即使再小的帆也能远航",
                        "1.0",
                        "http://www.baidu.com",
                            contact,
                         "Apache 2.0",
                        "http://www.apache.org/licenses/LICENSE-2.0",
                         new ArrayList()
        );
    }
}
