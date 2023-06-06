package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BookVO;

public class BookDAO {
	
	public ArrayList<BookVO> findByPublisher(String publisher){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book where publisher = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publisher);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVO b = new BookVO();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setPublisher(rs.getString(3));
				b.setPrice(rs.getInt(4));
				list.add(b);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
	
	
	public ArrayList<String> findPublisher(){
		ArrayList<String> list = new ArrayList<String>();
		try {
			String sql = "select distinct publisher from book";
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, stmt, rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
}









