package com.chinasms.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasms.sms.Sender;


public class GetVerifyCodeServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String tel=request.getParameter("tel");
		String code=request.getParameter("code");
		String time=request.getParameter("time");
		Sender sd=new Sender();
		String returnCode=sd.massSend(tel, code, time);
//		String num;
//		if(returnCode == null || "".equals(returnCode)){
//			num ="num=0";
//		}else{
//			String[] ss =  returnCode.split("&");
//			num = ss[0];
//		}
		System.out.println(returnCode);
		response.setCharacterEncoding("utf-8");
        response.getWriter().write(returnCode);  
        response.getWriter().flush(); 
        response.getWriter().close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
