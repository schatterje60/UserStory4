package com.sc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.dao.DbConnectorDao;
import com.sc.model.Project;

/**
 * Servlet implementation class ViewAllController
 */
@WebServlet("/ViewAllController")
public class ViewAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		   try{
	            PrintWriter out = response.getWriter();
	            DbConnectorDao db= new DbConnectorDao();
	        List<Project> plist=db.showAll();
	        out.println("<table align='center' border='1'>"+"<tr><th>id</th><th>title</th><th>description</th><th>domain</th></tr>");
	        for(Project p:plist) {

	            out.println("<tr><td>"+p.getId()+"</td><td>"+p.getTitle()+"</td><td>"+p.getDescription()+"</td><td>"+p.getDomain()+"</td>");
	        }
	        out.println("</table>");

	    }

	        catch (ClassNotFoundException e) 
		   {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        catch (SQLException e) 
		   {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
