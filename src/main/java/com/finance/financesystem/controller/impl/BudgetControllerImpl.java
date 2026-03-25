package com.finance.financesystem.controller.impl;

import com.finance.financesystem.controller.BudgetController;
import com.finance.financesystem.dto.BudgetDto;
import com.finance.financesystem.service.BudgetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/budget")
public class BudgetControllerImpl implements BudgetController{

}
