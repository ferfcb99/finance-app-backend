package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.BudgetController;
import com.finance.financesystem.dto.BudgetDto;
import com.finance.financesystem.service.BudgetService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/budget")
public class BudgetControllerImpl implements BudgetController{

    private final BudgetService budgetService;

    public BudgetControllerImpl(BudgetService budgetService){
        this.budgetService = budgetService;
    }
    @Override
    @GetMapping(value = "/get-all-budget", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BudgetDto>> getAllBudget(){
        return null;
    }


    @Override
    @GetMapping(value = "/get-by-id-budget/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BudgetDto> getByIdBudget(@PathVariable("id") Long id) {
        return null;
    }


    @Override
    @PostMapping(value = "/create-budget", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BudgetDto> createBudget(@RequestBody BudgetDto budgetDto) {
        return null;
    }

}
