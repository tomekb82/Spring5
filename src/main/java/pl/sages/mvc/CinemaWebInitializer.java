package pl.sages.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pl.sages.JpaConfiguration;

public class CinemaWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{JpaConfiguration.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{ WebConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }

  // wybór profilu w MVC:
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    super.onStartup(servletContext);
    servletContext.setInitParameter("spring.profiles.active", "jpa");
  }
}
