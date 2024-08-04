package SpringBoot_CRUD.Employee.service;

import SpringBoot_CRUD.Employee.EmployeeApplication;
import SpringBoot_CRUD.Employee.entity.EmployeeEntity;
import SpringBoot_CRUD.Employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceImplement implements EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImplement.class);
    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImplement(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity getEmployeeById(Integer id) {
        Optional <EmployeeEntity> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }else{
            log.info("Employee with id: {} doesn't exist",id);
        }
        return null;
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        employeeEntity.setCreateAt(LocalDateTime.now());
        employeeEntity.setUpdatedAt(LocalDateTime.now());
        EmployeeEntity saveEmployee = employeeRepository.save(employeeEntity);
        log.info("Employee with id: {} saved successfully",saveEmployee.getId());
        return saveEmployee;
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        Optional<EmployeeEntity> existingEmployee = employeeRepository.findById(employeeEntity.getId());
        employeeEntity.setCreateAt(LocalDateTime.now());
        employeeEntity.setUpdatedAt(LocalDateTime.now());
        EmployeeEntity updateEmployee = employeeRepository.save(employeeEntity);
        log.info("Employee with id: {} updated successfully",updateEmployee.getId());
        return updateEmployee;
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }
}