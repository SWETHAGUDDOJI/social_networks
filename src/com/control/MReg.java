package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.MBean;
import com.dao.Dao;

/**
 * Servlet implementation class MReg
 */
@WebServlet("/MReg")
public class MReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MReg() {
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
		String email = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String mob = request.getParameter("mob");
		String agc = request.getParameter("agc");
		String sql = "insert into medical values(?,?,?,?,?,?)";
		MBean mb = new MBean();
		mb.setName(name);
		mb.setEmail(email);
		mb.setPwd(pwd);
		mb.setMob(mob);
		mb.setAgc(agc);
		int i = Dao.setMedical(sql, mb);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Register Successfully...');");
			o.println("window.location='medical.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Please enter valid Details');");
			o.println("window.location='mreg.jsp';</script>");
		}
	}

}
