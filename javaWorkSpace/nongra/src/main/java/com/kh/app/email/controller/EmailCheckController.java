package com.kh.app.email.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.app.email.service.EmailService;

@WebServlet("/email/check")
public class EmailCheckController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//화면에 보여줄 메세지
		String AuthenticationKey = "";
		String alertMsg = "";
		try {
			
			// 이메일 데이터를 받아옴
			String email = req.getParameter("email");
			System.out.println(email);
			
			// 이메일 서비스
			EmailService emailSevice = new EmailService();
			
			// 체크 서비스 호출
			boolean result = emailSevice.EmailCheck(email);
			
			if(!result) {
				alertMsg = "존재하지 않는 이메일 입니다.";
				throw new Exception("이메일이 존재하지 않음..");
			}
			
			// 인증번호 생성기
			StringBuffer temp = new StringBuffer();
			Random rnd = new Random();
			for (int i = 0; i < 10; i++) {
				int rIndex = rnd.nextInt(3);
				switch (rIndex) {
				case 0:
					// a-z
					temp.append((char) ((int) (rnd.nextInt(26)) + 97));
					break;
				case 1:
					// A-Z
					temp.append((char) ((int) (rnd.nextInt(26)) + 65));
					break;
				case 2:
					// 0-9
					temp.append((rnd.nextInt(10)));
					break;
				}
			}
			
			AuthenticationKey = temp.toString();
			
			// 아이디 비밀번호는 맞음 
		      String host = "smtp.naver.com";            
		      final String user = "quddnr3688@naver.com";   
		      final String password = "B1PDX878VKSV";         
		      
		      String to = email;
		      
		      // Get the session object
		      Properties props = new Properties();
		      props.put("mail.smtp.host", host);
		      props.put("mail.smtp.auth", "true");
		      props.put("mail.smtp.starttls.enable", "true");
		      props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // TLS 프로토콜 명시

		      Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		          protected PasswordAuthentication getPasswordAuthentication() {
		              return new PasswordAuthentication(user, password);
		          }
		      });
		      
		      boolean sendOk = false;
		      PrintWriter out = resp.getWriter();
		         
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(user));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Subject
	         message.setSubject("[농라] 이메일 인증번호입니다.");
	         
	         // Text
	         message.setText("인증번호는 "+AuthenticationKey+" 입니다.");

	         // send the message
	         Transport.send(message);
	         
	         sendOk = true;

	         if(sendOk) {
	        	 Gson gson = new Gson();
	        	 alertMsg = "이메일이 발송 되었습니다. "
	        	 		+ "인증번호 유효시간은 10분입니다.";
	        	 String[] success = {alertMsg};
	        	 String successJson = gson.toJson(success);
	        	 HttpSession servletSession = req.getSession();
	        	 req.getSession().setAttribute("AuthenticationKey", AuthenticationKey);
	        	 servletSession.setMaxInactiveInterval(5*60); 
	        	 resp.getWriter().write(successJson);
	         }else {
	        	alertMsg = "이메일 발송이 실패했습니다.";
	            throw new MessagingException();
	         }

		}catch (Exception e) {
			e.printStackTrace();
			Gson gson = new Gson();
			AuthenticationKey = "";
			String[] success = {alertMsg};
			String failJson = gson.toJson(success);
			resp.getWriter().write(failJson);
		}
		
	}
	
}
