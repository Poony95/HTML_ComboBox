<%@page import="com.sist.vo.EmpVO"%>
<%@page import="com.sist.dao.EmpDAO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int dno = Integer.parseInt(request.getParameter("dno"));
	EmpDAO dao = new EmpDAO();
	ArrayList<EmpVO> list = dao.findByDno(dno);
	Gson gson = new Gson();
	String str = gson.toJson(list);
	out.print(str);
%>










