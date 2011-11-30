package org.foo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name = "STUDY")
public class Study {
	
	@Id @GeneratedValue
	@Column (name = "ID")
	private Long id;

	@NotEmpty()
	@Size (min = 0, max = 64)
	@Column (name = "IRB_ID")
	private String irbId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIrbId() {
		return irbId;
	}
	public void setIrbId(String irbId) {
		this.irbId = irbId;
	}
	

}
