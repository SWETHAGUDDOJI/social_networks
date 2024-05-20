package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HBean;
import com.dao.Dao;

/**
 * Servlet implementation class HReg
 */
@WebServlet("/HReg")
public class HReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		String name = request.getParameter("name");
		String hid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String mob = request.getParameter("mob");
		String area = request.getParameter("area");
		String sql = "insert into hospital values(?,?,?,?,?,?)";
		HBean hb = new HBean();
		hb.setName(name);
		hb.setHid(hid);
		hb.setPwd(pwd);
		hb.setMob(mob);
		hb.setArea(area);
		int i = Dao.setHospital(sql, hb);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Register Successfully...');");
			o.println("window.location='hospital.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Please enter valid Details');");
			o.println("window.location='hreg.jsp';</script>");
		}
	}

}
