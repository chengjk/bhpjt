package com.supermap.bhpjt.po;

import javax.persistence.Entity;

@Entity
public class ProjectFull extends Project {

	/**
	 * auto
	 */
	private static final long serialVersionUID = 9006107940187367861L;
	/**
	 * ��Ŀ����
	 *        
	 */
	private double projectRate;
	/**
	 * ����������
	 *        
	 */
	private double yeartaskRate;
	/**
	 * �������
	 *        
	 */
	private double figureRate;
	
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
	
	
	private String photos;
	
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
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	
	
	

}
