<%@ page import="java.util.*" %>
<%@ page import="com.cdpc.aio.common.exception.AppException" %>
<%@ page import="com.cdpc.aio.common.mvc.Constants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
	String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
%>
