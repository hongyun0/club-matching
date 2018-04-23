package com.kohong.clubWeb.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.kohong.clubWeb.model.ClubDAO;
import com.kohong.clubWeb.model.ConnectionPool;

public class GetCategoriesAction implements Action {

	@Override
	public String excute(HttpServletRequest request) throws ServletException, IOException {
		List<String> result = new ArrayList();
		try {
			result = new ClubDAO(ConnectionPool.getConnection()).getCategories();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", result);
		return "results/getCategories.jsp";
	}

}
