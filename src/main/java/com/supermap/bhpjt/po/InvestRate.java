package com.supermap.bhpjt.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 投资进度表
 * 
 * @author Administrator
 * @version 1.0
 * @updated 24-二月-2014 10:44:24
 */
@Entity
@Table(schema="bhpjt",name="InvestRate")
@SequenceGenerator(name="autoid",sequenceName="SEQ_AUTOID")
@Access(AccessType.FIELD)
public class InvestRate implements Serializable {

	/**
	 * auto
	 */
	private static final long serialVersionUID = 3966400889562368370L;
	/**
	 * <font color="#000000">ID</font>
	 *        
	 */
	@Id
	@GeneratedValue(generator="autoid",strategy=GenerationType.SEQUENCE)
	private int id;
	/**
	 * 项目<font color="#010101">ID</font>
	 *        
	 */
	private int projectId;
	/**
	 * 累计完成投资（万元）
	 *        
	 */
	private double investTotal;
	/**
	 * 年度计划投资（万元）
	 *        
	 */
	private double investYear;
	/**
	 * 更新时间
	 *        
	 */
	private Date updateTime;

	public InvestRate(){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public double getInvestTotal() {
		return investTotal;
	}

	public void setInvestTotal(double investTotal) {
		this.investTotal = investTotal;
	}

	public double getInvestYear() {
		return investYear;
	}

	public void setInvestYear(double investYear) {
		this.investYear = investYear;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	

	
}