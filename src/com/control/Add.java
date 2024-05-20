package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.MedicineBean;
import com.dao.Dao;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
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
		HttpSession session = request.getSession(false);
		String sql = "select agency from medical where email='"+session.getAttribute("uid")+"'";
		String agc = Dao.getName(sql);
		String dis = request.getParameter("dis");
		String sym = request.getParameter("sym");
		String med = request.getParameter("med");
		sql = "insert into disease values(?,?,?,?)";
		MedicineBean mb = new MedicineBean();
		mb.setDis(dis);
		mb.setSym(sym);
		mb.setMed(med);
		mb.setAgc(agc);
		int i = Dao.setMedicine(sql, mb);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Medicine Added Successfully...');");
			o.println("window.location='asym.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Medicine not added');");
			o.println("window.location='asym.jsp';</script>");
		}
	}

}
