package com.kardec.pethub.repository;

import com.kardec.pethub.model.Tutelado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository("tuteladoRepository")
public interface TuteladoRepository extends JpaRepository<Tutelado, Long>, JpaSpecificationExecutor<Tutelado> {
}
