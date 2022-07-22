package com.springBootWithPostgreSQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootWithPostgreSQL.model.Konu;

@Repository
public interface KonuRepository extends JpaRepository<Konu, Long> {

}
