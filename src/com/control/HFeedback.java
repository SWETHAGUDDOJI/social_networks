package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.HFeedBean;
import com.dao.Dao;

/**
 * Servlet implementation class HFeedback
 */
@WebServlet("/HFeedback")
public class HFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HFeedback() {
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
		String rev = request.getParameter("rev");
		int rate = Integer.parseInt(request.getParameter("rate"));
		String sql = "Select name from hospital where hid='"+hid+"'";
		String hname = Dao.getName(sql);
		HFeedBean hb = new HFeedBean();
		hb.setHid(hid);
		hb.setHname(hname);
		hb.setRev(rev);
		hb.setRate(rate);
		hb.setUid(uid);
		sql = "insert into hreview values(?,?,?,?,?)";
		int i = Dao.setHReview(sql, hb);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Review Posted Successfully...');");
			o.println("window.location='uhome.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Review not posted');");
			o.println("window.location='uremedy.jsp';</script>");
		}
	}

}
