package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.BudgetController;
import com.finance.financesystem.dto.BudgetDto;
import com.finance.financesystem.service.BudgetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/budget")
public class BudgetControllerImpl implements BudgetController{

    Logger logger = LoggerFactory.getLogger(AccountControllerImpl.class);

    private final BudgetService budgetService;

    public BudgetControllerImpl(BudgetService budgetService){
        this.budgetService = budgetService;

    }
    // metodo para obtener tdodos los datos
    @Override
    @GetMapping(value = "/get-all-budget", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BudgetDto>> getAllBudget() {
        logger.info("Entro al metodo getAllBudget del controlador");
        List<BudgetDto> budgetDtoList = this.budgetService.getAllBudget();

        return ResponseEntity.status(HttpStatus.OK)
                .body(budgetDtoList);
    }

    //metodo para obtener datos por id
    @Override
    @GetMapping(value = "/get-by-budget/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BudgetDto> getByIdBudget(@PathVariable Long id) {
        logger.info("Entro el metodo getByIdBudget del controlador");
        BudgetDto budgetById = this.budgetService.getByIdBudget(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(budgetById);
    }

    // metodo para crear datos
    @Override
    @PostMapping(value = "/create-budget", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BudgetDto> createBudget(@RequestBody BudgetDto budgetDto) {
        logger.info("Entro al metodo createBudget del controlador");
        BudgetDto budgetCreated = this.budgetService.createBudget(budgetDto);

        return ResponseEntity.status(HttpStatus.OK)
                .body(budgetCreated);
    }

    // metodo para eliminar datos
    @Override
    @DeleteMapping(value = "delete-by-id-budget/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BudgetDto> deleteByIdBudget(@PathVariable Long id) {
        logger.info("Entro al metodo deleteByIdBudget del controlador");
        BudgetDto budgetDeleted = this.budgetService.deteByIdBudget(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(budgetDeleted);
    }
}
