package sample.data.jpa.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.data.jpa.domain.entity.employee;


public interface EmployeeJpaManager extends JpaRepository<employee, Long> {

}
