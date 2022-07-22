package com.springBootWithPostgreSQL.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Konu")
public class Konu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Name")
	private String name;

	private Konu() {
		super();
	}

	private Konu(String name) {
		super();
		this.name = name;
	}

	// yenisi
	private Konu(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// yenisi
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
