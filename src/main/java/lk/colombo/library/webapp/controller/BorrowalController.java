package lk.colombo.library.webapp.controller;

import lk.colombo.library.webapp.model.Borrowal;
import lk.colombo.library.webapp.service.BorrowalService;
import lk.colombo.library.webapp.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("/borrowals")
public class BorrowalController implements Serializable {

    public static final Logger logger = LoggerFactory.getLogger(BorrowalController.class);

    @Autowired
    private BorrowalService borrowalService;

    @GetMapping
    public ResponseEntity<List<Borrowal>> getAllBorrowals() {
        List<Borrowal> borrowals = borrowalService.getAllBorrowals();
        if (borrowals.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(borrowals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrowal> getBorrowalById(@PathVariable(value = "id") Long id) {
        Borrowal borrowal = borrowalService.findById(id);
        if (borrowal == null) {
            logger.error("Borrowal with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Borrowal with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(borrowal, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveBorrowal(@RequestBody Borrowal borrowal) {
        logger.info("Creating Borrowal : {}", borrowal);
        if (borrowalService.isBorrowalExist(borrowal)) {
            logger.error("Unable to create. A Borrowal with same details already exist");
            return new ResponseEntity(new CustomErrorType("Unable to create. A Borrowal with same details already exist"), HttpStatus.CONFLICT);
        }
        borrowalService.saveBorrowal(borrowal);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
