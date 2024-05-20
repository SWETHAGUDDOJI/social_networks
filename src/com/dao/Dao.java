package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.HBean;
import com.bean.HFeedBean;
import com.bean.MBean;
import com.bean.MedBean;
import com.bean.MedicineBean;
import com.bean.PBean;
import com.bean.RemBean;
import com.bean.SendBean;
import com.bean.UBean;
import com.bean.UserBean;

public class Dao {

	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/vtjcc11_2022", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}

	public static int setHospital(String sql, HBean hb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hb.getHid());
			ps.setString(2, hb.getName());
			ps.setString(3, hb.getPwd());
			ps.setString(4, hb.getMob());
			ps.setString(5, hb.getArea());
			ps.setString(6, "pending");
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public static int setMedical(String sql, MBean mb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mb.getName());
			ps.setString(2, mb.getEmail());
			ps.setString(3, mb.getPwd());
			ps.setString(4, mb.getMob());
			ps.setString(5, mb.getAgc());
			ps.setString(6, "pending");
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public static int setUser(String sql, UserBean ub) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ub.getName());
			ps.setString(2, ub.getEmail());
			ps.setString(3, ub.getPwd());
			ps.setString(4, ub.getMob());
			ps.setString(5, ub.getDob());
			ps.setString(6, ub.getAdd());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public static boolean getData(String sql) {
		// TODO Auto-generated method stub
		boolean b = false;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			b = rs.next();
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public static String getName(String sql) {
		// TODO Auto-generated method stub
		String name = "";
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			name = rs.getString(1);
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}

	public static List<String> getHospital(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
				lt.add(rs.getString(6));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static List<String> getMedical(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
				lt.add(rs.getString(6));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static List<String> getUsers(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
				lt.add(rs.getString(6));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static int update(String sql) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public static List<String> getCDisease(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
				lt.add(rs.getString(6));
				lt.add(rs.getString(7));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	
	public static List<String> getCRemedy(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
				lt.add(rs.getString(6));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	
	public static List<String> getRDisease(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(5));
				lt.add(rs.getString(6));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	
	public static List<String> getMedicine(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static int setMedicine(String sql, MedicineBean mb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mb.getDis());
			ps.setString(2, mb.getSym());
			ps.setString(3, mb.getMed());
			ps.setString(4, mb.getAgc());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public static List<String> getPDisease(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
				lt.add(rs.getString(6));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	
	public static List<String> getPDet(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
				lt.add(rs.getString(6));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	
	public static List<String> getPHospital(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static int sendRequest(String sql, UBean ub) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ub.getUid());
			ps.setString(2, ub.getHid());
			ps.setString(3, ub.getDis());
			ps.setString(4, ub.getSym());
			ps.setString(5, ub.getDa());
			ps.setString(6, "pending");
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public static List<String> getPMedicine(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	
	public static List<String> getHReview(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static int setHReview(String sql, HFeedBean hb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hb.getHid());
			ps.setString(2, hb.getHname());
			ps.setString(3, hb.getRev());
			ps.setInt(4, hb.getRate());
			ps.setString(5, hb.getUid());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public static int setMReview(String sql, MedBean mb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mb.getPid());
			ps.setString(2, mb.getHid());
			ps.setString(3, mb.getMed());
			ps.setString(4, mb.getRev());
			ps.setInt(5, mb.getRate());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public static List<String> getMReview(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	
	public static List<String> getHRemedy(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(6));
				lt.add(rs.getString(1));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static int setDiseases(String sql, SendBean sb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sb.getHid());
			ps.setString(2, sb.getEnc());
			ps.setString(3, sb.getUsers());
			ps.setString(4, sb.getDis());
			ps.setString(5, sb.getSym());
			ps.setString(6, sb.getDa());
			ps.setString(7, "pending");
			ps.setString(8, sb.getKey());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public static List<String> getHMedicine(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
				lt.add(rs.getString(6));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static int setPMed(String sql, RemBean rb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, rb.getPid());
			ps.setString(2, rb.getHid());
			ps.setString(3, rb.getDis());
			ps.setString(4, rb.getMed());
			ps.setString(5, rb.getDa());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public static List<String> getPDiseases(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static List<String> getMedDis(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(2));
				lt.add(rs.getString(5));
				lt.add(rs.getString(6));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}

	public static int setRemedy(String sql, PBean pb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pb.getId());
			ps.setString(2, pb.getHid());
			ps.setString(3, pb.getDis());
			ps.setString(4, pb.getSym());
			ps.setString(5, pb.getMed());
			ps.setString(6, pb.getDa());
			ps.setString(7, "pending");
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public static int getCount(String sql){
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			i = rs.getInt(1);
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
