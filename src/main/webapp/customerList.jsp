<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.zip.GZIPOutputStream"%>
<%@page import="com.sist.vo.CustomerVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.CustomerDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int bookid = Integer.parseInt(request.getParameter("bookid"));
	CustomerDAO dao = new CustomerDAO();
	ArrayList<CustomerVO> list = dao.findByBookid(bookid);
	Gson gson = new Gson();
	String data = gson.toJson(list);
	out.print(data);
%>