package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class UpdateCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		WriteDAO dao = new WriteDAO();
		WriteDTO [] arr = null;
		int cnt=0;
		
		//매개변수 가져오기 
		String uid = request.getParameter("uid");
		String name = request.getParameter("subject");
		String content = request.getParameter("content");
		
		if(name != null && content !=null) {
			
			try {
				cnt = dao.update(Integer.parseInt(uid), name, content);
				request.setAttribute("updateOk", cnt);
				request.setAttribute("uid",Integer.parseInt(uid));
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
