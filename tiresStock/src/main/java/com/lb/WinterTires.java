package com.lb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "wintertires")
public class WinterTires {

	private Long id;
	private String name;
	private String dimension;
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public Long getId() {
		return id;
	}

	@Column (name = "dimension")
	public String getDimension() {
		return dimension;
	}

	@Column (name = "dimension")
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	@Column (name= "name")
	public void setName(String name) {
		this.name = name;
	}

	@Column (name= "name")
	public String getName() {
		return name;
	}
	
}
