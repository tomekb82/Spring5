package pl.sages;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import pl.sages.persistance.model.*;

import java.sql.*;

@Configuration
@Profile("jdbc")
@ComponentScan(basePackages = {"pl.sages.persistance.impl.jdbc", "pl.sages.service"})
public class JdbcConfiguration {

  @Bean
  public DataSource hsqlDataSource() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    return builder
        .setType(EmbeddedDatabaseType.HSQL)
        .addScript("db/schema/user.sql")
        .addScript("db/schema/cinema.sql")
        .addScript("db/schema/room.sql")
        .addScript("db/schema/movie.sql")
        .addScript("db/schema/show.sql")
        .addScript("db/schema/reservation.sql")
        .build();
  }

  // przykład dla MySQL
//  @Bean
//  public DataSource mysqlDataSource() {
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//    dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
//    dataSource.setUsername("guest_user");
//    dataSource.setPassword("guest_password");
//
//    return dataSource;
//  }

  @Bean
  public NamedParameterJdbcTemplate getJdbcTemplate(DataSource dataSource) {
    return new NamedParameterJdbcTemplate(dataSource);
  }
}
