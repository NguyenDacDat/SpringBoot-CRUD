package SpringBoot_CRUD.Employee.service;

import SpringBoot_CRUD.Employee.entity.EmployeeEntity;
import SpringBoot_CRUD.Employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {
    List<EmployeeEntity> getAllEmployees();
    EmployeeEntity getEmployeeById(Integer id);
    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
    void deleteEmployeeById(Integer id);
}