package pl.pk.rabbitmqplayground.dbplayground;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pkolkiew
 * Created 12/21/2021
 */
@AllArgsConstructor
class DBPlaygroundJdbcRepository implements DBPlaygroundRepository {

    private SimpleJdbcInsert parentInsertJdbcTemplate;
    private SimpleJdbcInsert childInsertJdbcTemplate;

    @Override
    @Transactional
    public Long saveAll(ParentEntity parentEntity) {
        Map<String, Object> parentParams = new HashMap<>();
        parentParams.put("username", parentEntity.getUsername());
        parentParams.put("insert_date", parentEntity.getInsertDate());

        final Number parentIdNumber = parentInsertJdbcTemplate.executeAndReturnKey(parentParams);
        Long parId = parentIdNumber.longValue();

        for (ChildEntity childEntity : parentEntity.getChilds()) {
            childEntity.setParParId(parId);

            Map<String, Object> childParams = new HashMap<>();
            childParams.put("par_par_id", childEntity.getParParId());
            childParams.put("username", childEntity.getUsername());
            childParams.put("insert_date", childEntity.getInsertDate());

            childInsertJdbcTemplate.executeAndReturnKey(childParams);
        }

        return parId;
    }

//    @Override
//    public DBPlaygroundResponseDto findById(int parId) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("parId", parId);
//
//        namedParameterJdbcOperations.queryForObject("SELECT * FROM PARENT_CHILD WHERE par_id=:parId", params, );
//
//        return null;
//    }
}
