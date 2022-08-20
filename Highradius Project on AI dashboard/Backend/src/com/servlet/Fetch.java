package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.Crud;
import com.google.gson.Gson;
import com.pojo.Students;

@WebServlet("/Fetch")
public class Fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 
		Crud fetchdata=new Crud(); 
		
		HashMap<Object,Object> Response=new HashMap<Object,Object>();
		
		ArrayList<Students> mydata =new ArrayList<Students>();
		try {		
			Connection conn=fetchdata.getConnection();
			String sql_query="SELECT * from winter_internship_updated where is_deleted=0;";
			PreparedStatement st=conn.prepareStatement(sql_query);
			ResultSet rs = st.executeQuery();				 
			 	
			 while(rs.next())
			 {
				    Students s = new Students();
					s.setSl_no(rs.getInt("sl_no"));
					s.setBusiness_code(rs.getString("business_code"));
					s.setCust_number(rs.getInt("cust_number"));
					s.setClear_date(rs.getDate("clear_date"));	
					s.setBuisness_year(rs.getInt("buisness_year"));
					s.setDoc_id(rs.getString("doc_id"));
					s.setPosting_date(rs.getDate("posting_date"));
					s.setDocument_create_date(rs.getDate("document_create_date"));
					s.setDue_in_date(rs.getDate("due_in_date"));
					s.setInvoice_currency(rs.getString("invoice_currency"));
					s.setDocument_type(rs.getString("document_type"));
					s.setPosting_id(rs.getInt("posting_id"));
					s.setTotal_open_amount(rs.getFloat("total_open_amount"));															
					s.setBaseline_create_date(rs.getDate("baseline_create_date"));
					s.setCust_payment_terms(rs.getString("cust_payment_terms"));										
					s.setInvoice_id(rs.getInt("invoice_id"));
					s.setIs_deleted(rs.getInt("is_deleted"));
										
					mydata.add(s);		
						
			 }
			 Response.put("s",mydata);
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		//prepare json
		 Gson gson = new Gson();
		 String respData = gson.toJson(Response);
		 response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		 response.setContentType("application/json");	
		 response.getWriter().append(respData);	
											
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}