package sample.data.jpa.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.data.jpa.domain.entity.historyorderinfo;

public interface HistoryorderinfoJpaManager extends JpaRepository<historyorderinfo, Long> {

}
