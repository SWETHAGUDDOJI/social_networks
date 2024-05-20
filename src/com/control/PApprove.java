package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Dao;
import com.dao.PortNumber;

/**
 * Servlet implementation class PApprove
 */
@WebServlet("/PApprove")
public class PApprove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PApprove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		String hid = request.getParameter("da");
		HttpSession session = request.getSession(false);
		String name = (String) session.getAttribute("name");
		String pid = name.substring(0,2) + PortNumber.getPort();
		String sql = "update udisease set pid='"+pid+"' where date1='"+hid+"'";
		int i = Dao.update(sql);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Patient Request Accepted Successfully...');");
			o.println("window.location='papp.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Patient Request not Accepted');");
			o.println("window.location='papp.jsp';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
