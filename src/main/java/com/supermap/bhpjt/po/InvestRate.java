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
 * Ͷ�ʽ��ȱ�
 * 
 * @author Administrator
 * @version 1.0
 * @updated 24-����-2014 10:44:24
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
	 * ��Ŀ<font color="#010101">ID</font>
	 *        
	 */
	private int projectId;
	/**
	 * �ۼ����Ͷ�ʣ���Ԫ��
	 *        
	 */
	private double investTotal;
	/**
	 * ��ȼƻ�Ͷ�ʣ���Ԫ��
	 *        
	 */
	private double investYear;
	/**
	 * ����ʱ��
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