package SpringBoot_CRUD.Employee.controller;

import SpringBoot_CRUD.Employee.entity.EmployeeEntity;
import SpringBoot_CRUD.Employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/v1")
@RequiredArgsConstructor
@Validated
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/employee/v1/
     * Purpose: Fetches all the employees in the employee table
     * @return List of Employees
     */
    @GetMapping("/")
    public ResponseEntity <List<EmployeeEntity>> getAllEmployees(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }
    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/employee/v1/1 (or any other id)
     * Purpose: Fetches employee with the given id
     * @param id - employee id
     * @return Employee with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeBydId(@PathVariable Integer id){
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }
    /**
     * This method is called when a POST request is made
     * URL: localhost:8080/employee/v1/
     * Purpose: Save an Employee entity
     * @param employeeEntity - Request body is an Employee entity
     * @return Saved Employee entity
     */
    @PostMapping("/")
    public ResponseEntity <EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity employeeEntity){
        return ResponseEntity.ok().body(employeeService.saveEmployee(employeeEntity));
    }
    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/employee/v1/
     * Purpose: Update an Employee entity
     * @param employeeEntity - Employee entity to be updated
     * @return Updated Employee
     */
    @PutMapping("/")
    public ResponseEntity<EmployeeEntity>updateEmployee(@RequestBody EmployeeEntity employeeEntity){
        return ResponseEntity.ok().body(employeeService.updateEmployee(employeeEntity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().body("Deleted employee successfully");

    }

}