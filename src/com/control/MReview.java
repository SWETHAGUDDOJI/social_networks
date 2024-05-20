package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.MedBean;
import com.dao.Dao;

/**
 * Servlet implementation class MReview
 */
@WebServlet("/MReview")
public class MReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MReview() {
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
		String pid = request.getParameter("pid");
		String hid = request.getParameter("hid");
		String med = request.getParameter("med");
		String rev = request.getParameter("rev");
		int rate = Integer.parseInt(request.getParameter("rate"));
		MedBean mb = new MedBean();
		mb.setPid(pid);
		mb.setHid(hid);
		mb.setMed(med);
		mb.setRev(rev);
		mb.setRate(rate);
		String sql = "insert into mfeedback values(?,?,?,?,?)";
		int i = Dao.setMReview(sql, mb);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Medicine Review Posted Successfully...');");
			o.println("window.location='uhome.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Medicine Review not posted');");
			o.println("window.location='uremedy.jsp';</script>");
		}
	}

}
