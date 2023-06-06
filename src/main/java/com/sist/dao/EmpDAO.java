package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.EmpVO;

import db.ConnectionProvider;


public class EmpDAO {
	
	public EmpVO findByEno(int eno) {
		EmpVO emp = new EmpVO();
		String sql = "select * from emp where eno=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				emp.setEno(rs.getInt(1));
				emp.setEno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setDno(rs.getInt(3));
				emp.setSalary(rs.getInt(4));
				emp.setComm(rs.getInt(5));
				emp.setHiredate(rs.getDate(6));
				emp.setPhone(rs.getString(7));
				emp.setAddr(rs.getString(8));
				emp.setMgr(rs.getInt(9));
				emp.setJob(rs.getString(10));
				emp.setEmail(rs.getString(11));
				emp.setJumin(rs.getString(12));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return emp;
	}
	
	public ArrayList<EmpVO> findByDno(int dno){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			String sql = "select * from emp where dno="+dno;
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				EmpVO e = new EmpVO();
				e.setEno(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setDno(rs.getInt(3));
				e.setSalary(rs.getInt(4));
				e.setComm(rs.getInt(5));
				e.setHiredate(rs.getDate(6));
				e.setPhone(rs.getString(7));
				e.setAddr(rs.getString(8));
				e.setMgr(rs.getInt(9));
				e.setJob(rs.getString(10));
				e.setEmail(rs.getString(11));
				e.setJumin(rs.getString(12));
				list.add(e);
			}
			ConnectionProvider.close(conn, stmt, rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
}










