package com.math012.projectpagNet.repository;

import com.math012.projectpagNet.model.CnabModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CnabRepository extends JpaRepository<CnabModel, Integer> {
}
