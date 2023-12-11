package com.kh.app.seller.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.app.seller.service.SellerService;
import com.kh.app.seller.vo.SellerVo;

@MultipartConfig(
	maxFileSize = 1024*1024*10		
	,maxRequestSize = 1024*1024*50  
)
@WebServlet("/seller/profile")
public class ChangeProfileController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			SellerVo loginSeller = (SellerVo)req.getSession().getAttribute("loginSeller");
			
			String profilePath = "/nongra/resources/upload/img/default_profile.png";
			
			SellerService ss = new SellerService();
			int result = ss.ChangeProfile(profilePath,loginSeller);
			
			if(result != 1) {
				throw new Exception();
			}
			
			loginSeller.setProfile(profilePath);
			System.out.println("성공");
			resp.sendRedirect("/nongra/seller/select");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			SellerVo loginSeller = (SellerVo)req.getSession().getAttribute("loginSeller");
			Part pofile = req.getPart("pofile");
			System.out.println(pofile);
			System.out.println(pofile.getSubmittedFileName());
			
			// 읽
			InputStream in = pofile.getInputStream();
			
			//내보내기
			String sep = File.separator;
			String path = req.getServletContext().getRealPath(sep + "resources" + sep + "upload" + sep + "img");
			String randomName = System.nanoTime() + "_" + UUID.randomUUID();
			String submittedFileName = pofile.getSubmittedFileName();
			int index = submittedFileName.lastIndexOf(".");
			String ext = submittedFileName.substring(index);
			String fileName = sep + randomName + ext;
			File target = new File (path+fileName);
			FileOutputStream out = new FileOutputStream(target);
			
			// 1024	바이트를 전부 읽는다.
			byte[] buf = new byte[1024];
			int size = 0;
			while((size =in.read(buf)) != -1) {
				out.write(buf,0,size);
			}
			
			in.close();
			out.close();
			
			String profilePath = sep+"nongra"+sep+"resources"+sep+"upload"+sep+"img"+fileName;
			
			SellerService ss = new SellerService();
			int result = ss.ChangeProfile(profilePath,loginSeller);
			
			if(result != 1) {
				throw new Exception();
			}
			
			loginSeller.setProfile(profilePath);
			System.out.println("성공");
			resp.sendRedirect("/nongra/seller/select");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
