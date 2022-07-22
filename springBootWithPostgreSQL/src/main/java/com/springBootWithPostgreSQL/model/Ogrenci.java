package com.springBootWithPostgreSQL.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ogrenci")
public class Ogrenci {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Ogr_Number")
	private long ogr_number;

	@Column(name = "Year")
	private long year;

	private Ogrenci() {
		super();
	}

	private Ogrenci(String name, long ogr_number, long year) {
		super();
		this.name = name;
		this.ogr_number = ogr_number;
		this.year = year;
	}

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

	public long getOgr_number() {
		return ogr_number;
	}

	public void setOgr_number(long ogr_number) {
		this.ogr_number = ogr_number;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

}
