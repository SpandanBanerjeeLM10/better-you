
//Defines the java class which belongs to the package 
package com.example.springsecurity;

// importing all the necessary classes
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//making MvcConfig class as the configuration class
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	//mapping the html pages 	
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("demo");
        registry.addViewController("/plan").setViewName("plan");
        registry.addViewController("/physical").setViewName("physical");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/mindfulness").setViewName("mindfulness");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/demo").setViewName("demo");
        registry.addViewController("/denied").setViewName("denied");
        
    }
}



