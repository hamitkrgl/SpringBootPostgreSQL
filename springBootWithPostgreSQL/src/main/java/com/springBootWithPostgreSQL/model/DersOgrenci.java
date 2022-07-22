package com.springBootWithPostgreSQL.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DersOgrenci")
public class DersOgrenci {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "ders_fk"), nullable = false, referencedColumnName = "id")
	private Ders ders;

	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "ogrenci_fk"), nullable = false, referencedColumnName = "id")
	private Ogrenci ogrenci;

	@Column(name = "devamsizlik")
	private long devamsizlik;

	@Column(name = "notu")
	private long not;

	private DersOgrenci() {
		super();
	}

	private DersOgrenci(Ders ders, Ogrenci ogrenci, long devamsizlik, long not) {
		super();
		this.ders = ders;
		this.ogrenci = ogrenci;
		this.devamsizlik = devamsizlik;
		this.not = not;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDers() {
		return ders.getId();
	}

	public void setDers(Ders ders) {
		this.ders = ders;
	}

	public long getOgrenci() {
		return ogrenci.getId();
	}

	public void setOgrenci(Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}

	public long getDevamsizlik() {
		return devamsizlik;
	}

	public void setDevamsizlik(long devamsizlik) {
		this.devamsizlik = devamsizlik;
	}

	public long getNot() {
		return not;
	}

	public void setNot(long not) {
		this.not = not;
	}

}
