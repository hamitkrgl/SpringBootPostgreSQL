package com.springBootWithPostgreSQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootWithPostgreSQL.model.Ogretmen;

@Repository
public interface OgretmenRepository extends JpaRepository<Ogretmen, Long> {

}
