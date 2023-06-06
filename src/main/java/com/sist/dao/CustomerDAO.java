package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.CustomerVO;

public class CustomerDAO {
	/*
 		select distinct c.custid, name, address, phone
 		from customer c, orders o
 		where c.custid = o.custid and
 		bookid = 2;
	 */
	
	
	public ArrayList<CustomerVO> findByBookid(int bookid){
		String  sql= "select distinct c.custid, name, address, phone,fname "
				+ " 		from customer c, orders o "
				+ " 		where c.custid = o.custid and "
				+ " 		bookid = ?";
		
		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				CustomerVO c = new CustomerVO();
				c.setCustid(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setAddress(rs.getString(3));
				c.setPhone(rs.getString(4));
				c.setFname(rs.getString(5));
				list.add(c);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
}












