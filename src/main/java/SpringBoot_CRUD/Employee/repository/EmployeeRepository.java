package SpringBoot_CRUD.Employee.repository;

import SpringBoot_CRUD.Employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
}