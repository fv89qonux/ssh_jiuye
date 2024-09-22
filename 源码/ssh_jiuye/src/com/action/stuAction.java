package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TStuDAO;
import com.model.TStu;
import com.opensymphony.xwork2.ActionSupport;

public class stuAction extends ActionSupport
{
private Integer stuId;
	
	private String stuXuehao;
	private String stuRealname;
	private String stuSex;
	private String stuAge;


	private String loginName;
	private String loginPw;
	private String del;
	 
	private String message;
	private String path;
	private TStuDAO stuDAO;
	
	
	
	public String stuAdd()
	{
		TStu stu=new TStu();
		stu.setStuXuehao(stuXuehao);
		stu.setStuRealname(stuRealname);
		stu.setStuSex(stuSex);
		stu.setStuAge(stuAge);
		stu.setLoginName(loginName);
		stu.setLoginPw(loginPw);
		stu.setDel("no");
		stuDAO.save(stu);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("msg", "注册成功，请登录");
		return "msg";
	}
	

	public String stuDel()
	{
		TStu stu=stuDAO.findById(stuId);
		stu.setDel("yes");
		stuDAO.attachDirty(stu);
		this.setMessage("删除成功");
		this.setPath("stuMana.action");
		return "succeed";
	}
	
	
	public String stuMana()
	{
		List stuList=stuDAO.getHibernateTemplate().find("from TStu where del='no'");
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("stuList", stuList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String stuEditByMe()
	{
		Map session= ServletActionContext.getContext().getSession();
		TStu stu=(TStu)session.get("stu");
		
		stu.setStuXuehao(stuXuehao);
		stu.setStuRealname(stuRealname);
		stu.setStuSex(stuSex);
		stu.setStuAge(stuAge);
		
		stu.setLoginName(loginName);
		stu.setLoginPw(loginPw);
		stu.setDel("no");
		
		stuDAO.attachDirty(stu);
		session.put("stu", stu);
		this.setMessage("操作成功");
		this.setPath("astu/userinfo/stuinfo.jsp");
		return "succeed";
	}


	public String getDel()
	{
		return del;
	}


	public void setDel(String del)
	{
		this.del = del;
	}


	public String getLoginName()
	{
		return loginName;
	}


	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}


	public String getLoginPw()
	{
		return loginPw;
	}


	public void setLoginPw(String loginPw)
	{
		this.loginPw = loginPw;
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


	public String getStuAge()
	{
		return stuAge;
	}


	public void setStuAge(String stuAge)
	{
		this.stuAge = stuAge;
	}


	public TStuDAO getStuDAO()
	{
		return stuDAO;
	}


	public void setStuDAO(TStuDAO stuDAO)
	{
		this.stuDAO = stuDAO;
	}


	public Integer getStuId()
	{
		return stuId;
	}


	public void setStuId(Integer stuId)
	{
		this.stuId = stuId;
	}


	public String getStuRealname()
	{
		return stuRealname;
	}


	public void setStuRealname(String stuRealname)
	{
		this.stuRealname = stuRealname;
	}


	public String getStuSex()
	{
		return stuSex;
	}


	public void setStuSex(String stuSex)
	{
		this.stuSex = stuSex;
	}


	public String getStuXuehao()
	{
		return stuXuehao;
	}


	public void setStuXuehao(String stuXuehao)
	{
		this.stuXuehao = stuXuehao;
	}
	
}
