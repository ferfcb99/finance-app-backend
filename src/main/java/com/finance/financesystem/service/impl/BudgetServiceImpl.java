package com.finance.financesystem.service.impl;

import com.finance.financesystem.dto.BudgetDto;
import com.finance.financesystem.dto.CategoryDto;
import com.finance.financesystem.dto.UserSystemDto;
import com.finance.financesystem.entity.Budget;
import com.finance.financesystem.entity.Category;
import com.finance.financesystem.entity.UserSystem;
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
        List<BudgetDto> budgetDtoList = new ArrayList<>();

        for(Budget budget : budgets){
            BudgetDto budgetDto = new BudgetDto();
            UserSystemDto userSystemDto = new UserSystemDto();
            CategoryDto categoryDto = new CategoryDto();

            budgetDto.setId(budget.getId());
            budgetDto.setLimitAmount(budget.getLimitAmount());
            budgetDto.setMonth(budget.getMonth());
            budgetDto.setYear(budget.getYear());
            budgetDto.setStatus(budget.getStatus());

            userSystemDto.setId(budget.getUserSystem().getId());
            userSystemDto.setName(budget.getUserSystem().getName());
            userSystemDto.setEmail(budget.getUserSystem().getEmail());
            userSystemDto.setPassword(budget.getUserSystem().getPassword());
            userSystemDto.setCurrency(budget.getUserSystem().getCurrency());
            userSystemDto.setStatus(budget.getUserSystem().getStatus());
            userSystemDto.setLastLogin(budget.getUserSystem().getLastLogin());

            categoryDto.setId(budget.getCategory().getId());
            categoryDto.setName(budget.getCategory().getName());
            categoryDto.setType(budget.getCategory().getType());
            categoryDto.setDescription(budget.getCategory().getDescription());
            categoryDto.setColor(budget.getCategory().getColor());
            categoryDto.setIcon(budget.getCategory().getIcon());
            categoryDto.setStatus(budget.getCategory().getStatus());

            budgetDto.setUserSystemDto(userSystemDto);
            budgetDto.setCategoryDto(categoryDto);

            budgetDtoList.add(budgetDto);

        }
        return budgetDtoList;
    }

    @Override
    public BudgetDto getByIdBudget(Long id) {
        logger.info("Entro al metodo de getByIdBudget del servicio");
        Budget budgetById = this.budgetRepository.findById(id).get();

        BudgetDto budgetDto = new BudgetDto();
        UserSystemDto userSystemDto = new UserSystemDto();
        CategoryDto categoryDto = new CategoryDto();

        budgetDto.setId(budgetById.getId());
        budgetDto.setLimitAmount(budgetById.getLimitAmount());
        budgetDto.setMonth(budgetById.getMonth());
        budgetDto.setYear(budgetById.getYear());
        budgetDto.setStatus(budgetById.getStatus());

        userSystemDto.setId(budgetById.getUserSystem().getId());
        userSystemDto.setName(budgetById.getUserSystem().getName());
        userSystemDto.setEmail(budgetById.getUserSystem().getEmail());
        userSystemDto.setPassword(budgetById.getUserSystem().getPassword());
        userSystemDto.setCurrency(budgetById.getUserSystem().getCurrency());
        userSystemDto.setStatus(budgetById.getUserSystem().getStatus());
        userSystemDto.setLastLogin(budgetById.getUserSystem().getLastLogin());

        categoryDto.setId(budgetById.getCategory().getId());
        categoryDto.setName(budgetById.getCategory().getName());
        categoryDto.setType(budgetById.getCategory().getType());
        categoryDto.setDescription(budgetById.getCategory().getDescription());
        categoryDto.setColor(budgetById.getCategory().getColor());
        categoryDto.setIcon(budgetById.getCategory().getIcon());
        categoryDto.setStatus(budgetById.getCategory().getStatus());

        budgetDto.setUserSystemDto(userSystemDto);
        budgetDto.setCategoryDto(categoryDto);
        budgetDto.setYear(budgetDto.getYear());
        

        return budgetDto;
    }

    @Override
    public BudgetDto createBudget(BudgetDto budgetDto) {
        logger.info("Entro al metodo createBudget del servicio");

        Budget budgetCreate = new Budget();
        budgetCreate.setId(null);
        budgetCreate.setLimitAmount(budgetDto.getLimitAmount());
        budgetCreate.setMonth(budgetDto.getMonth());
        budgetCreate.setYear(budgetDto.getYear());
        budgetCreate.setStatus(budgetDto.getStatus());
        budgetCreate.setAlertThreshold(budgetDto.getAlertThreshold());

        UserSystem userSystem = new UserSystem();
        userSystem.setId(budgetDto.getUserSystemDto().getId());
        userSystem.setName(budgetDto.getUserSystemDto().getName());
        userSystem.setEmail(budgetDto.getUserSystemDto().getEmail());
        userSystem.setPassword(budgetDto.getUserSystemDto().getPassword());
        userSystem.setCurrency(budgetDto.getUserSystemDto().getCurrency());
        userSystem.setStatus(budgetDto.getUserSystemDto().getStatus());
        userSystem.setLastLogin(budgetDto.getUserSystemDto().getLastLogin());

        Category category = new Category();
        category.setId(budgetDto.getCategoryDto().getId());
        category.setName(budgetDto.getCategoryDto().getName());
        category.setType(budgetDto.getCategoryDto().getType());
        category.setDescription(budgetDto.getCategoryDto().getDescription());
        category.setColor(budgetDto.getCategoryDto().getColor());
        category.setIcon(budgetDto.getCategoryDto().getIcon());
        category.setStatus(budgetDto.getCategoryDto().getStatus());

        budgetCreate.setUserSystem(userSystem);
        budgetCreate.setCategory(category);

        budgetCreate = this.budgetRepository.save(budgetCreate);
        budgetDto.setId(budgetCreate.getId());



        return budgetDto;
    }

    @Override
    public BudgetDto deteByIdBudget(Long id) {
        logger.info("Entro el metodo deteByIdBudget del servicio");

        Budget budgetDeleted = this.budgetRepository.findById(id).get();

        this.budgetRepository.deleteById(id);

        BudgetDto budgetDto = new BudgetDto();
        UserSystemDto userSystemDto = new UserSystemDto();
        CategoryDto categoryDto = new CategoryDto();

        budgetDto.setId(budgetDeleted.getId());
        budgetDto.setLimitAmount(budgetDto.getLimitAmount());
        budgetDto.setMonth(budgetDeleted.getMonth());
        budgetDto.setYear(budgetDeleted.getYear());
        budgetDto.setStatus(budgetDeleted.getStatus());
        budgetDto.setAlertThreshold(budgetDeleted.getAlertThreshold());

        userSystemDto.setId(budgetDeleted.getUserSystem().getId());
        userSystemDto.setName(budgetDeleted.getUserSystem().getName());
        userSystemDto.setEmail(budgetDeleted.getUserSystem().getEmail());
        userSystemDto.setPassword(budgetDeleted.getUserSystem().getPassword());
        userSystemDto.setCurrency(budgetDeleted.getUserSystem().getCurrency());
        userSystemDto.setStatus(budgetDeleted.getUserSystem().getStatus());
        userSystemDto.setLastLogin(budgetDeleted.getUserSystem().getLastLogin());

        categoryDto.setId(budgetDeleted.getCategory().getId());
        categoryDto.setName(budgetDeleted.getCategory().getName());
        categoryDto.setType(budgetDeleted.getCategory().getType());
        categoryDto.setDescription(budgetDeleted.getCategory().getDescription());
        categoryDto.setColor(budgetDeleted.getCategory().getColor());
        categoryDto.setIcon(budgetDeleted.getCategory().getIcon());
        categoryDto.setStatus(budgetDeleted.getCategory().getStatus());

        budgetDto.setUserSystemDto(userSystemDto);
        budgetDto.setCategoryDto(categoryDto);

        return budgetDto;
    }
}
