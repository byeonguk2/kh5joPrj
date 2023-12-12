package com.kh.app.email.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.email.service.EmailService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/email/updatePwd")
public class ShowPwdController extends HttpServlet {

	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     
		try {
			
			BufferedReader reader = req.getReader();

			// 받아온 JSON 문자열을 읽어서 StringBuilder에 저장
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            
            Gson gson = new Gson();
            MemberVo vo = gson.fromJson(sb.toString(), MemberVo.class);
			
			System.out.println(vo);
			
			EmailService es = new EmailService();
			int result = es.updatePwd(vo);
			
			System.out.println(result);
			
			if(result != 1) {
				throw new Exception();
			}
			
			resp.getWriter().write("비밀번호 변경이 성공했습니다.");
			
		}catch (Exception e) {
			e.printStackTrace();

			resp.getWriter().write("비밀번호 변경이 실패했습니다.");
		}
		
	}
}
