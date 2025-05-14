package com.alamin.demo.data.repositories;

import com.alamin.demo.data.model.User;
import com.alamin.demo.data.predicates.UserPredicateBuilder;
import com.alamin.demo.enums.PredicateMode;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findByEmailAndRoleAndPhone(String email, String role, String phone, PredicateMode mode){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);

        var predicates = UserPredicateBuilder.buildPredicates(cb, userRoot, email, role, phone);

        Predicate finalPredicate;
        if (mode == PredicateMode.OR) {
            finalPredicate = cb.or(predicates.toArray(new Predicate[0]));
        } else {
            finalPredicate = cb.and(predicates.toArray(new Predicate[0]));
        }

        query.select(userRoot).where(finalPredicate);

        return entityManager.createQuery(query).getResultList();
    }
}
