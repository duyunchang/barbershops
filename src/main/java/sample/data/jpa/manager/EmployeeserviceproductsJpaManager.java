package sample.data.jpa.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.data.jpa.domain.entity.employeeserviceproducts;

public interface EmployeeserviceproductsJpaManager extends JpaRepository<employeeserviceproducts, Long> {

}
