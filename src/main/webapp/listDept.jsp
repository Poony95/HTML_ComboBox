<%@page import="com.google.gson.Gson"%>
<%@page import="com.sist.vo.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.DeptDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DeptDAO dao = new DeptDAO();
	ArrayList<DeptVO> list = dao.findAll();
	Gson gson = new Gson();
	String str = gson.toJson(list);
	out.print(str);
%>