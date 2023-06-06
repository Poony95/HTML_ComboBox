<%@page import="com.sist.vo.EmpVO"%>
<%@page import="com.sist.dao.EmpDAO"%>
<%@page import="com.google.gson.Gson"%>

<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int eno =  Integer.parseInt(request.getParameter("eno"));
	EmpDAO dao = new EmpDAO();
	EmpVO emp = dao.findByEno(eno);
	Gson gson = new Gson();
	String data = gson.toJson(emp);
	out.print(data);
%>