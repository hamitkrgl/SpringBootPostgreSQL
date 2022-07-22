package com.springBootWithPostgreSQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBootWithPostgreSQL.model.Ders;

public interface DersRepository extends JpaRepository<Ders, Long> {

}
