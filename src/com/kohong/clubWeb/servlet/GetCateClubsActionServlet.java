package com.kohong.clubWeb.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kohong.clubWeb.model.ClubDAO;

@WebServlet("/getCateClubsAction")
public class GetCateClubsActionServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		
		List<String> result = new ArrayList();
		try {
			result = new ClubDAO().getCateClubs(category);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("/results/getCateClubs.jsp").forward(request, response);
	
	}
}
