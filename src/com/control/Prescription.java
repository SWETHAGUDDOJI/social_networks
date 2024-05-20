package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PBean;
import com.dao.Dao;

/**
 * Servlet implementation class Prescription
 */
@WebServlet("/Prescription")
public class Prescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prescription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String med = request.getParameter("med");
		String sql = "select * from diseases where id="+id;
		System.out.println(sql);
		List<String> lt = Dao.getMedDis(sql);
		String hid = "", dis = "", sym = "";
		Iterator<String> itr = lt.iterator();
		while(itr.hasNext()){
			hid = itr.next();
			dis = itr.next();
			sym = itr.next();
		}
		Date d = new Date();
		String da = "" + d;
		PBean pb = new PBean();
		pb.setId(id);
		pb.setHid(hid);
		pb.setDis(dis);
		pb.setSym(sym);
		pb.setMed(med);
		pb.setDa(da);
		sql = "insert into remedy values(?,?,?,?,?,?,?)";
		int i = Dao.setRemedy(sql, pb);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Medicine Details Sent Successfully...');");
			o.println("window.location='mhome.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Medicine details not sent');");
			o.println("window.location='mdis.jsp';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
