<%@ page import="java.util.*,com.cdpc.aio.ams.web.po.TblSysSysfun" %>
<%@ page import="com.cdpc.aio.ams.common.exception.AppException" %>
<%@ page import="com.cdpc.aio.ams.common.mvc.Constants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="j" uri="/jxtl.tld"%>

<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
	String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
%>