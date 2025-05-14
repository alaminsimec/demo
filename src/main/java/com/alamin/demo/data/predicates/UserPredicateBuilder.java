package com.alamin.demo.data.predicates;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class UserPredicateBuilder {
    public static List<Predicate> buildPredicates(
            CriteriaBuilder cb,
            Root<?> root,
            String email,
            String role,
            String phone
    ) {
        List<Predicate> predicates = new ArrayList<>();

        if (email != null && !email.isEmpty()) {
            predicates.add(cb.equal(root.get("email"), email));
        }

        if (role != null && !role.isEmpty()) {
            predicates.add(cb.equal(root.get("role"), role));
        }

        if (phone != null && !phone.isEmpty()) {
            predicates.add(cb.equal(root.get("phone"), phone));
        }

        return predicates;
    }
}

