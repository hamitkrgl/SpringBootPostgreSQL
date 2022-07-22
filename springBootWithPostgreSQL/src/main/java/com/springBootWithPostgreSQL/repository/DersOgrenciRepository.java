package com.springBootWithPostgreSQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBootWithPostgreSQL.model.DersOgrenci;

public interface DersOgrenciRepository extends JpaRepository<DersOgrenci, Long> {

}
