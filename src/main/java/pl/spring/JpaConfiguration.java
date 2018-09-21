package pl.spring;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Profile("jpa")
@EnableTransactionManagement
@EnableJpaRepositories
@ComponentScan(basePackages = {"pl.spring"}, excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX,pattern="pl\\.spring\\.mvc\\..*"))
public class JpaConfiguration {

  @Bean
  public DataSource hsqlDataSource() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    return builder
        .setType(EmbeddedDatabaseType.HSQL)
        .addScript("db/schema/album.sql")
        //.addScript("db/schema/photo.sql")
        .build();
  }

  @Bean
  public PropertiesFactoryBean jpaProperties() {
    PropertiesFactoryBean factoryBean =  new PropertiesFactoryBean();
    factoryBean.setLocation(new ClassPathResource("jpa.properties"));
    return factoryBean;
  }

  @Bean
  @Autowired
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource hsqlDataSource, Properties jpaProperties) {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setPackagesToScan("pl.spring");
    entityManagerFactoryBean.setDataSource(hsqlDataSource);
    entityManagerFactoryBean.setJpaProperties(jpaProperties);
    entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    return entityManagerFactoryBean;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

}
