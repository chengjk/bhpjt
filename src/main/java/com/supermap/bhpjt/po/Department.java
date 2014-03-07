package com.supermap.bhpjt.po;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="bhpjt",name="DEPARTMENT")
@SequenceGenerator(name="autoid",sequenceName="SEQ_AUTOID")
@Access(AccessType.FIELD)
public class Department implements Serializable {

	/**
	 * auto
	 */
	private static final long serialVersionUID = -2460100942814188088L;
	
	@Id
	@GeneratedValue(generator="autoid",strategy=GenerationType.SEQUENCE)
	private int id; 
	
	private String nameFull;
	private String nameBrief;
	private int parentId;
	private String leader;
	private String telephone;
	private String remarker;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameFull() {
		return nameFull;
	}
	public void setNameFull(String nameFull) {
		this.nameFull = nameFull;
	}
	public String getNameBrief() {
		return nameBrief;
	}
	public void setNameBrief(String nameBrief) {
		this.nameBrief = nameBrief;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRemarker() {
		return remarker;
	}
	public void setRemarker(String remarker) {
		this.remarker = remarker;
	}
	
	

}
