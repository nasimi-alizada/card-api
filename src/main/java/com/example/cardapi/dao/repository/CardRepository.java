package com.example.cardapi.dao.repository;

import com.example.cardapi.dao.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends JpaRepository<CardEntity,Long>, JpaSpecificationExecutor<CardEntity> {

}
