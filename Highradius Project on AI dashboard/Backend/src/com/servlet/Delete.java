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

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Crud deleteData = new Crud();
			Connection con = deleteData.getConnection();
			String sql_query = "UPDATE winter_internship_updated set is_deleted = 1 where sl_no=?";
			PreparedStatement st=con.prepareStatement(sql_query);
			
			st.setString(1, request.getParameter("sl_no"));
			
			response.setHeader("Access-Control-Allow-Origin", "*");
			
			st.executeUpdate();
			con.close();
			
		}catch(Exception e) {
//			e.printStackTrace();
		}
	}

}