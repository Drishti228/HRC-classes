package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.Crud;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Edit() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		
		try {
			Crud editData = new Crud();
			Connection con= editData.getConnection();
			String sql_query="UPDATE winter_internship_updated set invoice_currency=?,cust_payment_terms=?" + "where sl_no=?";
			PreparedStatement st=con.prepareStatement(sql_query);
			
			st.setString(1,request.getParameter("invoice_currency"));	
			st.setString(2,request.getParameter("cust_payment_terms"));
			st.setString(3,request.getParameter("sl_no"));
			
			response.setHeader("Access-Control-Allow-Origin", "*");
			
			st.executeUpdate();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}