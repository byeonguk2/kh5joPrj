package com.kh.app.review.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.review.service.ReviewService;
import com.kh.app.review.vo.ReviewVo;

//리뷰 좋아요
@WebServlet("/member/reviewLike")
public class MemberLikeController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		
		try {
			
			//BODY 에 담긴 데이터 읽기
			BufferedReader br = req.getReader();
			String temp = "";
			String bodyData = "";
			while ( (temp = br.readLine()) !=null ) {
				bodyData += temp;
			}	
			
			//데이터
			Gson gson = new Gson();
			ReviewVo vo = gson.fromJson(bodyData, ReviewVo.class);
			vo.setConsumerNo(loginMember.getNo());
			
			//서비스
			ReviewService service = new ReviewService();
			int result = service.reviewLike(vo);
			//result
			if(result !=1 ) {
				throw new Exception();
			}
			
			System.out.println("좋아요 성공");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("좋아요 취소 실패");
		}
	}
}
