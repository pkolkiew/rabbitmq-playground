package pl.pk.rabbitmqplayground.configuration.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

/**
 * @author pkolkiew
 * Created 12/21/2021
 */
@Configuration
@EnableJdbcRepositories(basePackages = {"pl.pk.rabbitmqplayground"})
class DBJdbcConfiguration extends AbstractJdbcConfiguration {

    @Value("${db.driver-class-name}")
    String driverClassName;
    @Value("${db.url}")
    String url;
    @Value("${db.username}")
    String username;
    @Value("${db.password}")
    String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setDriverClassName(driverClassName);
        driver.setUrl(url);
        driver.setUsername(username);
        driver.setPassword(password);

        driver.setSchema("playground");

        return driver;
    }

    @Bean
    NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

//    @Bean
//    JdbcCustomConversions jdbcCustomConversions(){
//        return new JdbcCustomConversions();
//    }

}
