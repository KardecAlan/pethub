package com.kardec.pethub.tutor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository("tutorRepository")
public interface TutorRepository extends JpaRepository<Tutor, Long>, JpaSpecificationExecutor<Tutor> {

}
