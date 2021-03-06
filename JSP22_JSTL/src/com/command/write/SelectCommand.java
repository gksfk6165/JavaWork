package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class SelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		WriteDAO dao = new WriteDAO();
		WriteDTO [] arr = null;
	
		
		//매개변수 받아오기
		String uid  = request.getParameter("uid");
		
		try {
			arr = dao.selectByUid(Integer.parseInt(uid));
			
			request.setAttribute("update", arr);
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
	
	}

}
