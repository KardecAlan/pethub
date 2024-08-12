package com.kardec.pethub.historicoclinico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository("historicoClinicoRepository")
public interface HistoricoClinicoRepository extends JpaRepository<HistoricoClinico, Long>, JpaSpecificationExecutor<HistoricoClinico> {
}
