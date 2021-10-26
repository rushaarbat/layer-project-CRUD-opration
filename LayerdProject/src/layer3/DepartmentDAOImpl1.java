package layer3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import layer2.Department;

public class DepartmentDAOImpl implements DepartmentDAO {

	Connection conn;
	 
	public DepartmentDAOImpl() {
		try {
			System.out.println("DepartmentDAOImpl : Loading the driver...getting the connection...");
			//1 - registration of Driver
			  DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
						System.out.println("Driver registerdd....");
						
						//2 - establish the connection
			   conn = DriverManager.getConnection(
							"jdbc:hsqldb:hsql://localhost/mydb", "SA", "");
						System.out.println("Connected...."+conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void insertDepartment(Department dobj) {
		// TODO Auto-generated method stub
		System.out.println("DepartmentDAOImpl : insertDepartment(Department) -  inserting department...");
		try {
				//3. - decide your statement   DQL / DML / PLSQL
			PreparedStatement pst = conn.prepareStatement("insert into dept3 values (?,?,?)");;
			pst.setInt(1, dobj.getDepartmentNumber());
			pst.setString(2, dobj.getDepartmentName());
			pst.setString(3, dobj.getDepartmentlocation());
			int rows = pst.executeUpdate();
			System.out.println("Row created : "+rows);

			pst.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Department selectDepartment(int dno) {
		// TODO Auto-generated method stub
		System.out.println("DepartmentDAOImpl : selecting department by deptno");
		Department dept = null;
		try {
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from dept3 where deptno="+dno);
				if(rs.next() ) {
					dept = new Department();
					dept.setDepartmentNumber(rs.getInt(1));
					dept.setDepartmentName(rs.getString(2));
					dept.setDepartmentlocation(rs.getString(3));
					
				}
		} catch (SQLException e) {	e.printStackTrace(); }
		return dept;
	}

	@Override
	public List<Department> selectDepartments() {
		List<Department>  deptList = new ArrayList<Department>();
		try {
			System.out.println("DepartmentDAOImpl : Selecting all departments...");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from dept");
				while(rs.next() ) {
					Department dept=new Department();
					dept.setDepartmentNumber(rs.getInt(1));
					dept.setDepartmentName(rs.getString(2));
					dept.setDepartmentlocation(rs.getString(3));
					deptList.add(dept);// add the obj to the list
				}
		} catch (SQLException e) {	e.printStackTrace(); }
		return deptList;
	}

	@Override
	public void updateDepartment(Department dobj) {
		try {
			System.out.println("DepartmentDAOImpl : Updating department...");
		
		PreparedStatement pst = conn.prepareStatement("update dept3 set where Name=?, Location=? and dNumbe=? ");;
		
		pst.setString(1, dobj.getDepartmentName());
		pst.setString(2, dobj.getDepartmentlocation());
		pst.setInt(3, dobj.getDepartmentNumber());
		int rows = pst.executeUpdate();
		System.out.println("Row updatede : "+rows);

		pst.close();
		conn.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	

	}

	@Override
	public void deleteDepartment(int dno) {
		System.out.println("DepartmentDAOImpl : Deleting department");
		try {
			
			
		PreparedStatement pst = conn.prepareStatement("delete from dept3 wher dno=?");;
		
		
		pst.setInt(1, dobj.getDepartmentNumber());
		int rows = pst.executeUpdate();
		System.out.println("Row deleted : "+rows);

		pst.close();
		conn.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}

}
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import layer2.Department;

public class DepartmentDAOImpl1 implements DepartmentDAO {

	Connection con;
	public DepartmentDAOImpl() {
		try {
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver registerdd....");
			
			//2 - establish the connection
Connection conn = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/mydb", "SA", "");
			System.out.println("Connected...."+con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void insertDepartment(Department dobj) {
		System.out.println("DepartmentDAOImpl : insertDepartment(Department) - inserting department...");
PreparedStatement pst = con.prepareStatement("insert into dept values (?,?,?)");
pst.setInt(1,dobj.getDepartmentNumber());
pst.setString(2,dobj.getDepartmentName());
pst.setString(3,dobj.getDepartmentlocation());

int rows = pst.executeUpdate();
System.out.println(" row created ; " +rows);
pst.close();
con.close();
	}

	@Override
	public Department selectDepartment(int dno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> selectDepartment() {
		List<Department> deptList =new ArrayList<Department>();
try {
	System.out.println("DepartmentDAOImpl  : Selecting all Department,,,");
	Statements st =con.createStatement();
	ResultSet rs =st.executeQuery("select * from dept");
	while(rs.next()) {
		Department dept =new Department();
		dept.setDepartmentNumber(rs.getInt(1));
		dept.setDepartmentName(rs.getString(2));
		dept.setDepartmentlocation(rs.getString(3));
		deptList.add(dept); //add the obj to the list
	}
} catch (SQLException e) {
	
	e.printStackTrace();
}
		return null;
	}

	@Override
	public void updateDepartment(Department dobj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletDepartment(int dno) {
		// TODO Auto-generated method stub

	}

}*/
