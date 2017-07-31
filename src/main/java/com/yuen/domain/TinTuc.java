package com.yuen.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tintuc")
public class TinTuc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "linkhinh")
    private String linkhinh;
  
    @Column(name = "idnguon")
    private int idnguon;

    public TinTuc() {
        super();
    }

	public TinTuc(int id, String name, String linkhinh, int idnguon) {
		super();
		this.id = id;
		this.name = name;
		this.linkhinh = linkhinh;
		this.idnguon = idnguon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinkhinh() {
		return linkhinh;
	}

	public void setLinkhinh(String linkhinh) {
		this.linkhinh = linkhinh;
	}

	public int getIdnguon() {
		return idnguon;
	}

	public void setIdnguon(int idnguon) {
		this.idnguon = idnguon;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}