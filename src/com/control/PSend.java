package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.RemBean;
import com.dao.Dao;
import com.dao.Encode;

/**
 * Servlet implementation class PSend
 */
@WebServlet("/PSend")
public class PSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PSend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		HttpSession session = request.getSession();
		String hid = (String) session.getAttribute("uid");
		String id = request.getParameter("id");
		String sql = "select users from diseases where hid="+hid;
		String str = Dao.getName(sql);
		sql = "select key1 from diseases where hid="+hid;
		String key = Dao.getName(sql);
		String users = Encode.decode(str, key);
		String da = request.getParameter("da");
		sql = "select medicine from remedy where hid='"+hid+"' and date1='"+da+"'";
		System.out.println(sql);
		String med = Dao.getName(sql);
		sql = "select disease from remedy where hid='"+hid+"' and date1='"+da+"'";
		System.out.println(sql);
		String dis = Dao.getName(sql);
		int i = 0;
		sql = "insert into umedicine values(?,?,?,?,?)";
	//	StringTokenizer st = new StringTokenizer(users, ",");
		//while(st.hasMoreTokens()){
			String pid = id;
			RemBean rb = new RemBean();
			rb.setPid(pid);
			rb.setHid(hid);
			rb.setDis(dis);
			rb.setMed(med);
			rb.setDa(da);
			i = Dao.setPMed(sql, rb);
			System.out.println("vlueeeee ===" +pid);
			System.out.println("vlueeeee ===" +hid);
			System.out.println("vlueeeee ===" +dis);
			System.out.println("vlueeeee ===" +med);
			
	//	}
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Patient Medicine Sent Successfully...');");
			o.println("window.location='hhome.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Patient Medicine not sent');");
			o.println("window.location='premedy1.jsp';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
