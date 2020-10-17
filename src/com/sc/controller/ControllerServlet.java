package com.sc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.dao.DbConnectorDao;
import com.sc.model.Project;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/Welcome")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Id=Integer.parseInt(request.getParameter("Id"));
		String Title=request.getParameter("Title");
		String Description=request.getParameter("Description");
		String Domain=request.getParameter("Domain");
		Project p=new Project(Id,Title,Description,Domain);
		
		try {
				DbConnectorDao dbdao = new DbConnectorDao();
		
				boolean b=dbdao.insertProject(p);
				if(b==true)
				request.getRequestDispatcher("success.jsp").include(request,response);
			}
			catch (ClassNotFoundException e)
			{
				
				e.printStackTrace();
			}
	}
}
