package pl.pk.rabbitmqplayground.dbplayground;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pkolkiew
 * Created 12/21/2021
 */

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/dbplay")
class DBPlaygroundEndpoint {

    private final DBPlaygroundFacade facade;

    @GetMapping("/save")
    public ResponseEntity<?> saveMsg() {
        try {
            log.info("/dbplay/save invoked");
            facade.save();
            log.info("dbplay saved");
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getList() {
        try {
            log.info("/dbplay/get invoked");
            return ResponseEntity.ok().body(facade.findById());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

}
