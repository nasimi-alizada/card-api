package com.example.cardapi.service.specification;

import com.example.cardapi.dao.entity.CardEntity;
import com.example.cardapi.model.criteria.CardCriteria;
import com.example.cardapi.util.PredicateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import static com.example.cardapi.constant.CriteriaConst.CARD_HOLDER;
import static com.example.cardapi.util.PredicateUtil.applyLikePattern;

@AllArgsConstructor
public class CardSpecification implements Specification<CardEntity> {

    private CardCriteria cardCriteria;



    @Override
    public Predicate toPredicate(Root<CardEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {


        var predicates = PredicateUtil.builder()
                .addNullSafety(cardCriteria.getCardholder(),
                        cardholder -> criteriaBuilder.like(root.get(CARD_HOLDER), applyLikePattern(cardholder)))
                .build();


        return criteriaBuilder.and(predicates);
    }
}
