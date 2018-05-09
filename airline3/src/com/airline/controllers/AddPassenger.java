package com.airline.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPassenger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
		view.forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("errors", false);
		
		String firstName = request.getParameter("first-name");
		System.out.println("firstname: " + firstName);
		
		if (firstName.length() == 0) {
			System.out.println("Error: empty First Name");
			
			request.setAttribute("errors", true);
			request.setAttribute("error_firstname", true);
		}
		
		String lastName = request.getParameter("last-name");
		System.out.println("lastname: " + lastName);
		if (lastName.length() == 0) {
			System.out.println("Error: empty Last Name");
			
			request.setAttribute("errors", true);
			request.setAttribute("error_lastname", true);
		}
		
		String gender = request.getParameter("gender");
		System.out.println("gender: " + gender);
		
		String dob_raw = request.getParameter("dob");
		String dobArray[] = dob_raw.split("\\/");
		String pattern = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(dob_raw);
		
		if (m.find()) {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(dobArray[2])); 
			cal.set(Calendar.MONTH, Integer.parseInt(dobArray[1])-1); 
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dobArray[0])); 
			
			Date dob =  cal.getTime();
			System.out.println(dob);
		}
		else {
			System.out.println("Error: Invalid date of birth");
			request.setAttribute("errors", true);
			request.setAttribute("error_dob", true);
		
		}
		
		if((boolean) request.getAttribute("errors")) {
			doGet(request, response);
		}
		
	}

}
