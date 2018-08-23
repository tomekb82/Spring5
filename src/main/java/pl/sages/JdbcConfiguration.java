package pl.sages;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import pl.sages.persistance.model.*;

import java.sql.*;

@Configuration
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

  @Bean
  public Statement dbReader(DataSource dataSource) throws SQLException {
      Statement statement = dataSource.getConnection().createStatement();

      this.printDbResults(statement, User.class);
      this.printDbResults(statement, Cinema.class);
      this.printDbResults(statement, Room.class);
      this.printDbResults(statement, Movie.class);
      this.printDbResults(statement, Show.class);
      this.printDbResults(statement, Reservation.class);

      return statement;
  }

  private void printDbResults(Statement statement, Class entity) throws SQLException {
      String prefixUrl = "select * from ";
      String entityName = entity.getSimpleName().toLowerCase();
      ResultSet resultSet = statement.executeQuery(prefixUrl + entityName);
      ResultSetMetaData rsmd = resultSet.getMetaData();
      int columnsNumber = rsmd.getColumnCount();

      System.out.println(entityName.toUpperCase() + ':');
      while (resultSet.next()) {
          for (int i = 1; i <= columnsNumber; i++) {
              if (i > 1) System.out.print(",  ");
              String columnValue = resultSet.getString(i);
              System.out.print(rsmd.getColumnName(i) +": " + columnValue);
          }
          System.out.println("");
      }
      System.out.println("==============================================");
  }
}
