package com.module2.springBootWebTutorial.springBootWeb.repositories;

import com.module2.springBootWebTutorial.springBootWeb.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

}
