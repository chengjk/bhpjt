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

@Entity
@Table(schema="bhpjt",name="PROJECT")
@SequenceGenerator(name="autoid",sequenceName="SEQ_AUTOID")
@Access(AccessType.FIELD)
public class Project implements Serializable {
	/**
	 * auto
	 */
	private static final long serialVersionUID = -2962712222933221601L;
	@Id
	@GeneratedValue(generator="autoid",strategy=GenerationType.SEQUENCE)
	private int id;          //NUMBER(8) NOT NULL,    -- ID 
	private String name;        //VARCHAR2(50),    -- 项目名称 
	private String garden;      //VARCHAR2(50),    -- 落户园区 
	private String unit;        //VARCHAR2(50),    -- 引荐单位 
	private String investor;    //VARCHAR2(50),    -- 投资主体 
	private String corporate;   //VARCHAR2(50),    -- 法人代表 
	private String phone;       //VARCHAR2(15),    -- 法人电话 
	private double investAll ;  //NUMBER(8,2),    -- 投资总额（万元） 
	private String dutyunit;    //VARCHAR2(50),    -- 责任单位 
	private String leader;      //VARCHAR2(30),    -- 包靠领导 
	private String general;     //VARCHAR2(600),    -- 项目概况 
	private String sort;        //VARCHAR2(50),    -- 项目类别 
	private double x;           //NUMBER(8,8),    -- 经度 
	private double y;           //NUMBER(8,8),    -- 纬度 
	private Date updateTime;  //DATE    -- 更新时间 
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
	public String getGarden() {
		return garden;
	}
	public void setGarden(String garden) {
		this.garden = garden;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getInvestor() {
		return investor;
	}
	public void setInvestor(String investor) {
		this.investor = investor;
	}
	public String getCorporate() {
		return corporate;
	}
	public void setCorporate(String corporate) {
		this.corporate = corporate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getInvestAll() {
		return investAll;
	}
	public void setInvestAll(double investAll) {
		this.investAll = investAll;
	}
	public String getDutyunit() {
		return dutyunit;
	}
	public void setDutyunit(String dutyunit) {
		this.dutyunit = dutyunit;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getGeneral() {
		return general;
	}
	public void setGeneral(String general) {
		this.general = general;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	

}
