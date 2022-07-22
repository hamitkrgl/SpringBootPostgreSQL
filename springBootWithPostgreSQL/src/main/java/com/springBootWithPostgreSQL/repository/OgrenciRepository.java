package com.springBootWithPostgreSQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBootWithPostgreSQL.model.Ogrenci;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

}
