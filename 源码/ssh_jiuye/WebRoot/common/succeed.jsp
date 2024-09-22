<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
       <script type="text/javascript">
           <s:if test="message==null">
           </s:if>
           <s:else>
           		alert("<s:property value='message'/>");
           </s:else>
           
           <s:if test="path==null">
           </s:if>
           <s:else>
           		document.location.href="<%=path%>/<s:property value='path'/>";
           </s:else>
           
       </script>
  </head>
  
  <body>
       
  </body>
</html>
