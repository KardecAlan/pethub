package com.kardec.pethub.ficha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository("fichaRepository")
public interface FichaRepository extends JpaRepository<Ficha, Long>, JpaSpecificationExecutor<Ficha> {
}
