package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public Set<PatientEntity> findAllByLastname(String lastName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PatientEntity> query = cb.createQuery(PatientEntity.class);
        Root<PatientEntity> root = query.from(PatientEntity.class);

        query.select(root).where(cb.equal(cb.lower(root.get("lastName")), lastName.toLowerCase()));

        return entityManager.createQuery(query).getResultStream().collect(Collectors.toSet());
    }
}
