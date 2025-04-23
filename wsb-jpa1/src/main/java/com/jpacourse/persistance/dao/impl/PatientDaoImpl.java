package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.enums.BloodType;
import jakarta.persistence.criteria.*;
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

    @Override
    public Set<PatientEntity> getPatientsWithMoreThanXVisits(int noOfVisits) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PatientEntity> query = cb.createQuery(PatientEntity.class);
        Root<PatientEntity> root = query.from(PatientEntity.class);
        Join<Object, Object> visitJoin = root.join("visits");

        query.select(root)
                .groupBy(root)
                .having(cb.gt(cb.count(visitJoin), noOfVisits));

        return entityManager.createQuery(query).getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Set<PatientEntity> getPatientsHavingOneOfBloodTypes(Set<BloodType> bloodTypes) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PatientEntity> query = cb.createQuery(PatientEntity.class);
        Root<PatientEntity> root = query.from(PatientEntity.class);
//        Join<Object, Object> visitJoin = root.join("visits");

        Predicate bloodTypePredicate = root.get("bloodType").in(bloodTypes);
        query.select(root).where(bloodTypePredicate);

        return entityManager.createQuery(query).getResultStream().collect(Collectors.toSet());
    }
}
