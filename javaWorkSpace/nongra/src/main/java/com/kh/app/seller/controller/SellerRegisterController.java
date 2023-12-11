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

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10  ,
		maxRequestSize = 1024*1024*10 * 5
)

@WebServlet("/seller/register")
public class SellerRegisterController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		req.getRequestDispatcher("/WEB-INF/views/seller/sellerItem/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Part part = req.getPart("part");
		
		InputStream in = part.getInputStream();
		
		String sep = File.separator;
		String path = req.getServletContext().getRealPath(sep + "resources" + sep + "upload" + sep + "img");
		String randomName = "thumbnail_" + System.nanoTime() + "_" + UUID.randomUUID();
		String submittedFileName = part.getSubmittedFileName();
		int index = submittedFileName.lastIndexOf(".");
		String ext = submittedFileName.substring(index);
		String fileName = sep + randomName + ext;
		File target = new File(path + fileName);
		FileOutputStream out = new FileOutputStream(target);
		
		byte[] buf = new byte[1024];
		int size = 0;
		while ((size = in.read(buf)) != -1) {
			out.write(buf , 0 , size);
		}
		
		in.close();
		out.close();
		
		String title = req.getParameter("title");
		String price = req.getParameter("price");
		String stock = req.getParameter("stock");
		String origin = req.getParameter("origin");
		String filePath = sep+"nongra"+ sep +"resources" + sep +"upload"+sep+"img"+fileName;
	}
	
	
}
