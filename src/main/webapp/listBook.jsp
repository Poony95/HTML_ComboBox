<%@page import="com.sist.vo.BookVO"%>
<%@page import="com.sist.dao.BookDAO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String publisher = request.getParameter("publisher");
	BookDAO dao = new BookDAO();
	ArrayList<BookVO> list = dao.findByPublisher(publisher);
	Gson gson = new Gson();
	String data = gson.toJson(list);
	out.print(data);
%>