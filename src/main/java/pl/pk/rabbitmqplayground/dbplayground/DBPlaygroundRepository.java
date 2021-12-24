package pl.pk.rabbitmqplayground.dbplayground;

/**
 * @author pkolkiew
 * Created 12/21/2021
 */
interface DBPlaygroundRepository {
    Long saveAll(ParentEntity parentEntity);
}
