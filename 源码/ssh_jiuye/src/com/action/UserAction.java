package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TStuDAO;
import com.dao.TUserDAO;
import com.model.TStu;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport
{
    private Integer userId;
	
	private String userName;
	private String userPw;
	private String userRealname;
	private String userAddress;


	private String userTel;
	private String userEmail;
	private String userQq;
	private String userDel;
	
	
	private String message;
	private String path;
	
	private TUserDAO userDAO;
	private TStuDAO stuDAO;
	
	
	public String userAdd()
	{
		TUser user=new TUser();
		
		user.setUserName(userName);
		user.setUserPw(userPw);
		user.setUserAddress(userAddress);
		user.setUserTel(userTel);
		
		user.setUserRealname(userRealname);
		user.setUserEmail(userEmail);
		user.setUserQq(userQq);
		user.setUserDel("no");
		
		userDAO.save(user);
		
		this.setMessage("操作成功");
		this.setPath("userMana.action");
		return "succeed";
	}
	
	
	
	public String userLogin()
	{
		HttpServletRequest req=ServletActionContext.getRequest();
		String userType=req.getParameter("userType");
		
		if(userType.equals("qiye"))
		{
			String sql="from TUser where userName=? and userPw=? and userDel='no'";
			Object[] con={userName,userPw};
			List userList=userDAO.getHibernateTemplate().find(sql,con);
			if(userList.size()==0)
			{
				this.setMessage("用户名或密码错误");
				this.setPath("qiantai/default.jsp");
			}
			else
			{
				 Map session= ServletActionContext.getContext().getSession();
				 TUser user=(TUser)userList.get(0);
				 session.put("user", user);
				 session.put("userType", "qiye");
				 this.setMessage("成功登录");
				 this.setPath("qiantai/default.jsp");
			}
		}
		if(userType.equals("stu"))
		{
			String sql="from TStu where loginName=? and loginPw=? and del='no'";
			Object[] con={userName,userPw};
			List stuList=stuDAO.getHibernateTemplate().find(sql,con);
			if(stuList.size()==0)
			{
				this.setMessage("用户名或密码错误");
				this.setPath("qiantai/default.jsp");
			}
			else
			{
				 Map session= ServletActionContext.getContext().getSession();
				 TStu stu=(TStu)stuList.get(0);
				 session.put("userType", "stu");
				 session.put("user", stu);
				 
				 this.setMessage("成功登录");
				 this.setPath("qiantai/default.jsp");
			}
		}
		
		return "succeed";
	}
	
	
	public String userLogout()
	{
		Map session= ServletActionContext.getContext().getSession();
		session.remove("userType");
		session.remove("user");
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	
	
	public String userDel()
	{
		TUser user=userDAO.findById(userId);
		user.setUserDel("yes");
		userDAO.attachDirty(user);
		this.setMessage("删除成功");
		this.setPath("userMana.action");
		return "succeed";
	}
	
	
	public String userXinxi()
	{
		TUser user=userDAO.findById(userId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("user", user);
		return ActionSupport.SUCCESS;
	}
	
	
	public String userMana()
	{
		String sql="from TUser where userDel='no'";
		List userList=userDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
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
	public TStuDAO getStuDAO()
	{
		return stuDAO;
	}
	public void setStuDAO(TStuDAO stuDAO)
	{
		this.stuDAO = stuDAO;
	}
	public String getUserAddress()
	{
		return userAddress;
	}
	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}
	public TUserDAO getUserDAO()
	{
		return userDAO;
	}
	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	public String getUserDel()
	{
		return userDel;
	}
	public void setUserDel(String userDel)
	{
		this.userDel = userDel;
	}
	public String getUserEmail()
	{
		return userEmail;
	}
	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}
	public Integer getUserId()
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getUserPw()
	{
		return userPw;
	}
	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}
	public String getUserQq()
	{
		return userQq;
	}
	public void setUserQq(String userQq)
	{
		this.userQq = userQq;
	}
	public String getUserRealname()
	{
		return userRealname;
	}
	public void setUserRealname(String userRealname)
	{
		this.userRealname = userRealname;
	}
	public String getUserTel()
	{
		return userTel;
	}
	public void setUserTel(String userTel)
	{
		this.userTel = userTel;
	}
		
}
