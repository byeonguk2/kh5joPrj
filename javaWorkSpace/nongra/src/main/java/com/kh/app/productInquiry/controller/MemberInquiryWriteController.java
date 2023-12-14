package com.kh.app.productInquiry.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.productInquiry.service.ProductInquiryService;
import com.kh.app.productInquiry.vo.ProductInquiryVo;
import com.kh.app.review.service.ReviewService;
import com.kh.app.review.vo.ReviewVo;


@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10 , 
		maxRequestSize =  1024*1024*10 *5 
		)   // 50 MB
@WebServlet("/member/InquiryWrite")

// 상품문의 파일받기
public class MemberInquiryWriteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();		
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		String memberNo = loginMember.getNo();

		String salesNo = req.getParameter("salesNo"); 
		String content = req.getParameter("content");
		String secretYn = req.getParameter("secretYn");
		ProductInquiryVo vo = new ProductInquiryVo();
		
	try {
			
		vo.setConsumerNo(memberNo);
		vo.setSalesNo(salesNo);
		vo.setContent(content);
		vo.setSecretYn(secretYn);
		
		
		
		Collection<Part> parts = req.getParts();
		ArrayList<Part> fileList = new ArrayList<Part>();
		for (Part part : parts) {
            if (part.getSubmittedFileName() != null) {
            		fileList.add(part);
            }
		}
         
		ArrayList<String> strlist = new ArrayList<String>();
         
        for(Part part : fileList) {
        	Part f = part;
        	
        	//읽기 준비
  	      InputStream in = f.getInputStream();
  	      
  	      //내보내기 준비
  	      String sep = File.separator;
  	      String path = req.getServletContext().getRealPath(sep + "resources" + sep + "upload" + sep + "img" + sep +"inquiry");
  	      String randomName = System.currentTimeMillis() + "_" + UUID.randomUUID();
  	      
  	      //원본 파일면
  	      String submittedFileName = f.getSubmittedFileName();
  	      
  	      int index = submittedFileName.lastIndexOf(".");
  	      String ext = submittedFileName.substring(index);
  	      String fileName = sep +  randomName   + ext;
  	      String src = sep + "nongra" +sep +"resources" + sep + "upload" + sep + "img" + sep + "inquiry" + fileName;
  	      System.out.println(src);
  	      strlist.add(src);
  	    
  	      File target = new File(path + fileName);
  	      FileOutputStream out = new FileOutputStream(target);
  	      
  	      byte[] buf = new byte[1024];
  	      int size = 0;
  	      while( (size = in.read(buf)) != -1) {
  	         out.write(buf, 0, size);
  	      }
  	      
  	      // 정리
  	      in.close();
  	      out.close();
        }
        
      

		ProductInquiryService rs = new ProductInquiryService();
		
		//service
		int result = rs.memberInquiryWrite(vo,strlist);
		System.out.println("사진작성 성공");
		// result (==view)
		if(result !=1 ) {
			throw new Exception();
		}
		
	
		
		//-> getRequestDispatcher()는 요청을 그대로 들고 가는 걸 알고 있으면 된다.
		resp.sendRedirect("/nongra/member/manageInquiry"); 
		session.setAttribute("alertMsg", "문의작성 성공");	
		
	} catch (Exception e) {
		e.printStackTrace();
	System.out.println("리뷰 멤버 페이지 에러");
		session.setAttribute("alertMsg", "문의작성 실패");
		resp.sendRedirect("/nongra/member/manageInquiry"); ;
		}
	}// method	
} //class 