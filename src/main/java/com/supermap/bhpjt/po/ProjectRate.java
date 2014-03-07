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
 * 项目进度表
 * 
 * @author Administrator
 * @version 1.0
 * @created 24-二月-2014 10:44:25
 */

@Entity
@Table(schema="bhpjt",name="PROJECTRATE")
@SequenceGenerator(name="autoid",sequenceName="SEQ_AUTOID")
@Access(AccessType.FIELD)
public class ProjectRate implements Serializable {

	/**
	 * auto
	 */
	private static final long serialVersionUID = -4834311367372511603L;
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
	 * 项目进度
	 *        
	 */
	private double projectRate;
	/**
	 * 年度任务进度
	 *        
	 */
	private double yeartaskRate;
	/**
	 * 形象进度
	 *        
	 */
	private double figureRate;
	/**
	 * 更新时间
	 *        
	 */
	private Date updateTime;
	/**
	 * <font color="#000000">项目照片</font>
	 *        
	 */
	private String photos;

	public ProjectRate(){

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

	public double getProjectRate() {
		return projectRate;
	}

	public void setProjectRate(double projectRate) {
		this.projectRate = projectRate;
	}

	public double getYeartaskRate() {
		return yeartaskRate;
	}

	public void setYeartaskRate(double yeartaskRate) {
		this.yeartaskRate = yeartaskRate;
	}

	public double getFigureRate() {
		return figureRate;
	}

	public void setFigureRate(double figureRate) {
		this.figureRate = figureRate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	

}