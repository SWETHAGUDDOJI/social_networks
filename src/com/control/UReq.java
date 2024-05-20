package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UBean;
import com.dao.Dao;

/**
 * Servlet implementation class UReq
 */
@WebServlet("/UReq")
public class UReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UReq() {
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
		String uid = (String) session.getAttribute("uid");
		String hid = request.getParameter("hid");
		String dis = request.getParameter("dis");
		String sym = request.getParameter("sym");
		Date d = new Date();
		String da = "" + d;
		String sql = "insert into udisease values(?,?,?,?,?,?)";
		UBean ub = new UBean();
		ub.setUid(uid);
		ub.setHid(hid);
		ub.setDis(dis);
		ub.setSym(sym);
		ub.setDa(da);
		int i = Dao.sendRequest(sql, ub);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Request Sent Successfully...');");
			o.println("window.location='uhome.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Request not sent');");
			o.println("window.location='uhospital.jsp';</script>");
		}
	}

}
