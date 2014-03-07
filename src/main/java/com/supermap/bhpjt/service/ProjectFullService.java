package com.supermap.bhpjt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.supermap.bhpjt.dao.IInvestRateDao;
import com.supermap.bhpjt.dao.IProjectDao;
import com.supermap.bhpjt.dao.IProjectRateDao;
import com.supermap.bhpjt.po.InvestRate;
import com.supermap.bhpjt.po.Project;
import com.supermap.bhpjt.po.ProjectFull;
import com.supermap.bhpjt.po.ProjectRate;

@Service
public class ProjectFullService {

	@Autowired
	private IProjectDao pdao;
	@Autowired
	private IProjectRateDao prdao;
	@Autowired
	private IInvestRateDao irdao;
	@Autowired
	private JdbcTemplate jdbc;
	
	/**
	 * 新建项目
	 * @param p
	 * @return
	 */
	public int createPoject(ProjectFull pf){
		Date dt=new Date();
		Project p=pf;
		p.setUpdateTime(dt);
		int pid=pdao.save(p).getId();
		
		//投资进度
		InvestRate ir=new InvestRate();
		ir.setProjectId(pid);
		ir.setInvestTotal(pf.getInvestTotal());
		ir.setInvestYear(pf.getInvestYear());
		ir.setUpdateTime(dt);
		
		//项目进度
		ProjectRate pr=new ProjectRate();
		pr.setProjectId(pid);
		pr.setProjectRate(pf.getProjectRate());
		pr.setYeartaskRate(pf.getYeartaskRate());
		pr.setFigureRate(pf.getFigureRate());
		pr.setPhotos(pf.getPhotos());
		pr.setUpdateTime(dt);

		irdao.save(ir);
		prdao.save(pr);
		
		return pid;
	}
	/**
	 * 更新项目
	 * @param p
	 * @return
	 */
	public int update(ProjectFull p){
		return pdao.save(p).getId();
	}
	
	/**
	 * 查找给定时间点后的所有项目
	 * @param d
	 * @return
	 */
	public Iterable<ProjectFull> findNews(Date d){
		List<ProjectFull> pfs=new ArrayList<ProjectFull>();
		ProjectFull pf=null;
		Iterable<Project> ps=pdao.findNewsByUpdateTime(d);
		
	   	Iterator<Project> itps= ps.iterator();
	   	
	   	while(itps.hasNext()){
	   		pf=new ProjectFull();
	   		pf=(ProjectFull)itps.next();
	   		
	   		//add prate;
	   		ProjectRate pr=prdao.getLatestRateForProject(pf.getId());
	   		if(pr==null)pr=new ProjectRate();
	   		pf.setProjectRate(pr.getProjectRate());
	   		pf.setFigureRate(pr.getFigureRate());
	   		pf.setYeartaskRate(pr.getYeartaskRate());
	   		pf.setPhotos(pr.getPhotos());
	   		// add irate
	   		InvestRate ir=irdao.getLatestRateForProject(pf.getId());
	   		if(ir==null){
	   			ir=new InvestRate();
	   		}
	   		pf.setInvestYear(ir.getInvestYear());
	   		pf.setInvestTotal(ir.getInvestTotal());
	   		
	   		pfs.add(pf);
	   		
	   	}
		return pfs;
	}
	
	
	
	
	
}
