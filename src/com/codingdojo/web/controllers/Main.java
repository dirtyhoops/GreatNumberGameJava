package com.codingdojo.web.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Main
 */
@WebServlet("/index")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer number = (Integer) session.getAttribute("number");
		Integer guess = Integer.parseInt(request.getParameter("guess"));
		Random rand = new Random();
		
		//if there's no session, a new number will be randomized
		if(session.getAttribute("number") == null) {
			session.setAttribute("number", rand.nextInt(100));
		}
		
		//just for checking purposes, prints both guess and the random number everytime the user guess a number
		System.out.println("guess is: " + guess);
		System.out.println("random number is: " + number);
		
		//sets a session depends on the user's guess. if it's right, it sets it to correct, and low if low, and high if high.
		if((int)number == (int)guess) {
			session.setAttribute("number", rand.nextInt(100));
			session.setAttribute("guessResponse", "correct");
		} else if ((int)guess > number) {
			session.setAttribute("guessResponse",  "high");
		} else {
			session.setAttribute("guessResponse", "low");
		}
		
		doGet(request, response);
	}

}
