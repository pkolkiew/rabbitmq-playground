package pl.pk.rabbitmqplayground.dbplayground;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

/**
 * @author pkolkiew
 * Created 12/21/2021
 */
@Configuration
class DBPlaygroundConfiguration {

    @Bean
    DBPlaygroundFacade dbPlaygroundFacade(DBPlaygroundRepository repository, DBPlaygroundJdbcCrudRepository crudRepository) {
        return new DBPlaygroundFacade(repository, crudRepository);
    }

    @Bean
    DBPlaygroundRepository dbPlaygroundRepository(@Qualifier("simpleJdbcInsertParentTable") SimpleJdbcInsert simpleJdbcInsertParentTable,
                                                  @Qualifier("simpleJdbcInsertChildTable") SimpleJdbcInsert simpleJdbcInsertChildTable) {
        return new DBPlaygroundJdbcRepository(simpleJdbcInsertParentTable, simpleJdbcInsertChildTable);
    }

    @Bean
    SimpleJdbcInsert simpleJdbcInsertParentTable(DataSource dataSource) {
        return new SimpleJdbcInsert(dataSource)
                .withTableName("PARENT_TABLE")
                .withSchemaName("playground")
                .usingGeneratedKeyColumns("par_id");
    }

    @Bean
    SimpleJdbcInsert simpleJdbcInsertChildTable(DataSource dataSource) {
        return new SimpleJdbcInsert(dataSource)
                .withTableName("CHILD_TABLE")
                .withSchemaName("playground")
                .usingGeneratedKeyColumns("chi_id");
    }

}
