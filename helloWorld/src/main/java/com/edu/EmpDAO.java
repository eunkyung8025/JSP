package com.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO {
	
	
	public int upadateMember(String name, String pass, String role) {
		String sql="update members "
				+ "set member_password=?, "
				+ "	   member_role=? "
				+ "where member_id=?";
		connect();
		int r=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, role);
			pstmt.setString(3, name);
			
			r = pstmt.executeUpdate();
			System.out.println(r+"건 변경됨.");

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return r;
		
		
	}
	
	
	//user_name, user_pass, role -> 입력
	
	public int insertMember(String name, String pass, String role) {
		String sql="insert into members values(?,?,?)";
		connect();
		
		int r=0;
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,name);
			pstmt.setString(2,pass);
			pstmt.setString(3,role);
			
			r = pstmt.executeUpdate(); //insert, update, delete
			System.out.println(r+"건 입력됨");
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disconnect();
		}
		return r;
				
	}
	
	public List<Employee> getEmpInfo(String name) {
		String sql="select * from employees where first_name=?";
		connect(); //conn객체를 생성해주는 메소드 & DB연결
		List<Employee> list=new ArrayList<>();

		try {
			//결과 처리
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			//처리 결과를 rs에 담아줌
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				list.add(emp);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
		
	}
	
	
	public List<Employee> empList() {
		String sql="select * from employees";
		connect(); //conn객체를 생성해주는 메소드 & DB연결
		List<Employee> list=new ArrayList<>();

		try {
			//결과 처리
			pstmt = conn.prepareStatement(sql);
			//처리 결과를 rs에 담아줌
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));
				list.add(emp);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
		
	}
	
	
	
}
