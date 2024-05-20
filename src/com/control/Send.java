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

import com.bean.SendBean;
import com.dao.Dao;
import com.dao.Encode;
import com.dao.PortNumber;

/**
 * Servlet implementation class Send
 */
@WebServlet("/Send")
public class Send extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Send() {
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
		String hid = (String) session.getAttribute("uid");
		System.out.println("userid is"+hid);
		String [] sd = request.getParameterValues("sd");
		System.out.println("request galues"+sd);
		String str = "";
		String dis = "", sym = "";
		String sql = "";
		for(int i = 0; i < sd.length; i++){
			str = sd[i] + "," + str;
			sql = "select disease from udisease where pid='"+sd[i]+"'";
			System.out.println(sql);
			dis = Dao.getName(sql);
			sql = "select symptom from udisease where pid='"+sd[i]+"'";
			System.out.println("sql"+sql);
			sym = Dao.getName(sql);
		}
		String key = PortNumber.getKeys();
		String[] users = Encode.encode(str, key);
		Date d = new Date();
		String da = "" + d;
		SendBean sb = new SendBean();
		sb.setHid(hid);
		sb.setEnc(users[0]);
		sb.setUsers(users[1]);
		sb.setDis(dis);
		sb.setSym(sym);
		sb.setDa(da);
		sb.setKey(key);
		sql = "insert into diseases values(0,?,?,?,?,?,?,?,?)";
		int i = Dao.setDiseases(sql, sb);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('List Sent Successfully...');");
			o.println("window.location='hhome.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('List not sent');");
			o.println("window.location='premedy.jsp';</script>");
		}
	}

}
