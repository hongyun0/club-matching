package com.kohong.clubWeb.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.kohong.clubWeb.model.ConnectionPool;
import com.kohong.clubWeb.model.MemberDAO;

public class IsMemberIdAction implements Action {

	@Override
	public String excute(HttpServletRequest request) throws ServletException, IOException {
		String id = request.getParameter("id");
		boolean result = false;
		try {
			result = new MemberDAO(ConnectionPool.getConnection()).isMemberId(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", result);
		return "results/isExist.jsp";
	}

}
