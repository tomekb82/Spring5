package pl.spring.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ImportResource("classpath:context.xml")
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"pl.spring.mvc.controllers"})
public class WebConfig implements WebMvcConfigurer {

  // view producer configuration
  // Simple InternalResourceViewResolver:
  // home -> will be mapped to /WEB-INF/views/home.jsp
  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    resolver.setExposeContextBeansAsAttributes(true);
    return resolver;
  }

  // static resources handling
  @Override
  public void configureDefaultServletHandling (DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }
}
