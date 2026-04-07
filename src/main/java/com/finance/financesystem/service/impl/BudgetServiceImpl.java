package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.BudgetDto;
import com.finance.financesystem.dto.CategoryDto;
import com.finance.financesystem.dto.UserSystemDto;
import com.finance.financesystem.entity.Budget;
import com.finance.financesystem.entity.Category;
import com.finance.financesystem.entity.UserSystem;
import com.finance.financesystem.mapper.BudgetMapper;
import com.finance.financesystem.repository.BudgetRepository;
import com.finance.financesystem.service.BudgetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final BudgetRepository budgetRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository){
        this.budgetRepository = budgetRepository;
    }

    @Override
    public List<BudgetDto> getAllBudget() {
        logger.info("Entro al metodo de getAllBudget del servicio");
        List<Budget> budgets = this.budgetRepository.findAll();

        return BudgetMapper.toListDto(budgets);
    }

    @Override
    public BudgetDto getByIdBudget(Long id) {
        logger.info("Entro al metodo de getByIdBudget del servicio");
        Budget budgetById = this.budgetRepository.findById(id).get();
        
        return BudgetMapper.toDto(budgetById);
    }

    @Override
    public BudgetDto createBudget(BudgetDto budgetDto) {
        logger.info("Entro al metodo createBudget del servicio");
        Budget budgetCreate = BudgetMapper.toEntity(budgetDto);

        budgetCreate = this.budgetRepository.save(budgetCreate);
        budgetDto.setId(budgetCreate.getId());



        return BudgetMapper.toDto(budgetCreate);
    }

    @Override
    public BudgetDto deteByIdBudget(Long id) {
        logger.info("Entro el metodo deteByIdBudget del servicio");
        Budget budgetDeleted = this.budgetRepository.findById(id).get();

        this.budgetRepository.deleteById(id);

        return BudgetMapper.toDto(budgetDeleted);
    }
}
