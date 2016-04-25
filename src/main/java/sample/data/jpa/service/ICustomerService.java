package sample.data.jpa.service;

import sample.data.jpa.domain.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerService extends JpaRepository<customer, Long> { 
}
