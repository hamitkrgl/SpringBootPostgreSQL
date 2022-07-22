package com.springBootWithPostgreSQL.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ders")
public class Ders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "konu_fk"), nullable = false)
	private Konu konu;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "ogr_fk"), nullable = false)
	private Ogretmen ogretmen;

	private Ders() {
		super();
	}

	private Ders(Konu konu, Ogretmen ogretmen) {
		super();
		this.konu = konu;
		this.ogretmen = ogretmen;
	}

	// yenisi
	private Ders(long id, Konu konu, Ogretmen ogretmen) {
		super();
		this.id = id;
		this.konu = konu;
		this.ogretmen = ogretmen;
	}

	// yenisi
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getKonu() {
		return konu.getId();
	}

	public void setKonu(Konu konu) {
		this.konu.setId(konu.getId());
	}

	public long getOgretmen() {
		return ogretmen.getId();
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen.setId(ogretmen.getId());
	}
}
