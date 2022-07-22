package com.springBootWithPostgreSQL.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ogretmen")
public class Ogretmen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "IS_GICIK")
	private boolean is_gıcık;

	private Ogretmen() {
		super();
	}

	private Ogretmen(String name, boolean is_gıcık) {
		super();
		this.name = name;
		this.is_gıcık = is_gıcık;
	}

	// yenisi
	private Ogretmen(long id, String name, boolean is_gıcık) {
		super();
		this.id = id;
		this.name = name;
		this.is_gıcık = is_gıcık;
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

	public boolean isIs_gıcık() {
		return is_gıcık;
	}

	public void setIs_gıcık(boolean is_gıcık) {
		this.is_gıcık = is_gıcık;
	}

}
