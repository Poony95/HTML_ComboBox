<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BookDAO dao = new BookDAO();
	ArrayList<String> list = dao.findPublisher();
	Gson gson = new Gson();
	String data = gson.toJson(list);
	out.print(data);
%>