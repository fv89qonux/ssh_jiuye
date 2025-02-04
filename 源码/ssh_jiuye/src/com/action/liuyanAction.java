package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TLiuyanDAO;
import com.model.TAdmin;
import com.model.TLiuyan;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class liuyanAction extends ActionSupport
{
	private int liuyanId;
	private String liuyanTitle;
	private String liuyanContent;
	
	private TLiuyanDAO liuyanDAO;
	private String message;
	private String path;
	
	
	
	public String liuyanMana()
	{
		List liuyanList=liuyanDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("liuyanList", liuyanList);
		return ActionSupport.SUCCESS;
	}
	
	public String liuyanAdd()
	{
		TLiuyan liuyan=new TLiuyan();
		liuyan.setLiuyanContent(liuyanContent);
		liuyan.setLiuyanTitle(liuyanTitle);
		liuyan.setLiuyanDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		Map session=ActionContext.getContext().getSession();
		
				
		
		liuyanDAO.save(liuyan);
		this.setMessage("���Գɹ�");
		this.setPath("liuyanAll.action");
		return "succeed";
	}
	
	
	public String liuyanDel()
	{
		TLiuyan liuyan=liuyanDAO.findById(liuyanId);
		liuyanDAO.delete(liuyan);
		this.setMessage("����ɾ���ɹ�");
		this.setPath("liuyanMana.action");
		return "succeed";
	}
	
	
	public String liuyanAll()
	{
		List liuyanList=liuyanDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("liuyanList", liuyanList);
		return ActionSupport.SUCCESS;
	}
	

	public String getLiuyanContent()
	{
		return liuyanContent;
	}

	public void setLiuyanContent(String liuyanContent)
	{
		this.liuyanContent = liuyanContent;
	}

	public TLiuyanDAO getLiuyanDAO()
	{
		return liuyanDAO;
	}

	public void setLiuyanDAO(TLiuyanDAO liuyanDAO)
	{
		this.liuyanDAO = liuyanDAO;
	}

	public int getLiuyanId()
	{
		return liuyanId;
	}

	public void setLiuyanId(int liuyanId)
	{
		this.liuyanId = liuyanId;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getLiuyanTitle()
	{
		return liuyanTitle;
	}

	public void setLiuyanTitle(String liuyanTitle)
	{
		this.liuyanTitle = liuyanTitle;
	}
	

}
