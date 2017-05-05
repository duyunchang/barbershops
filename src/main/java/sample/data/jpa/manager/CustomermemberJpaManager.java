package sample.data.jpa.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.data.jpa.domain.entity.customermember;

public interface CustomermemberJpaManager extends JpaRepository<customermember, Long> {

}
