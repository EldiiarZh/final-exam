package edu.attractor.demo.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Value("photo/")
    private String pathToPhotoThemePhotos;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/img/**")
//                .addResourceLocations("file:upload/" + pathToPhotoThemePhotos);
//        registry.addResourceHandler("/img/users/**")
//                .addResourceLocations("file:upload/" + pathToUsersPhotos);
//        registry.addResourceHandler("/img/news/**")
//                .addResourceLocations("file:upload/" + pathToNewsPhotos);
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/img/logo/**")
//                .addResourceLocations("file:src/main/resources/static/img/");
    }
}
