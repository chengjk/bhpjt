
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

/**
 * 用户关注表
 * 
 * @author Administrator
 * @version 1.0
 * @created 24-二月-2014 10:44:22
 */

@Entity
@Table(schema="bhpjt",name="FOCUS")
@SequenceGenerator(name="autoid",sequenceName="SEQ_AUTOID")
@Access(AccessType.FIELD)
public class Focus implements Serializable {

	/**
	 * auto
	 */
	private static final long serialVersionUID = 3211470559634845710L;
	/**
	 * <font color="#000000">ID</font>
	 *        
	 */
	@Id
	@GeneratedValue(generator="autoid",strategy=GenerationType.SEQUENCE)
	private int id;
	/**
	 * 用户<font color="#010101">ID</font>
	 *        
	 */
	private int userId;
	/**
	 * 项目<font color="#010101">ID</font>
	 *        
	 */
	private int projectId;

	public Focus(){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	

	
	

}