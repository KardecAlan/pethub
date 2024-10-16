package com.kardec.pethub.repository;

import com.kardec.pethub.model.HistoricoClinico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository("historicoClinicoRepository")
public interface HistoricoClinicoRepository extends JpaRepository<HistoricoClinico, Long>, JpaSpecificationExecutor<HistoricoClinico> {
}
