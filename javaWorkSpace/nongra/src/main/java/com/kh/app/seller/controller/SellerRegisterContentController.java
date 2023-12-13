package com.kh.app.seller.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kh.app.option.vo.OptionVo;
import com.kh.app.sales.service.SalesService;
import com.kh.app.sales.vo.SalesVo;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10 ,
		maxFileSize = 1024 * 1024 * 10  ,
		maxRequestSize = 1024 * 1024 * 10 * 5
)

@WebServlet("/seller/registerContent")
public class SellerRegisterContentController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/seller/sellerItem/registerContent.jsp").forward(req, resp);
	}
	
	@SuppressWarnings({ "unused", "unused" })
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		HttpSession session = req.getSession();
		try {
			String file = null;
			List<String> fileNameList = new ArrayList<String>();
			SalesVo salesVo = (SalesVo)session.getAttribute("register");
			List<OptionVo> optionVoList = new ArrayList<OptionVo>();
			
			String title = salesVo.getTitle();
			String price = salesVo.getPrice();
			String stock = salesVo.getStock();
			String origin = salesVo.getOrigin();
			String categoryNo1 = salesVo.getCategoryNo();
			String categoryNo2 = salesVo.getCategoryNo2();
			String thumbnail = salesVo.getFileName();
			String sellerNo = salesVo.getSellerNo();
			
			
			Collection<Part> parts = req.getParts();
			for (Part part : parts) {
				System.out.println("part ::: " + part);
				System.out.println("part.getName() : " + part.getName());
				
				//json 읽기
				if(part.getName().equals("jsonData")) {
					BufferedReader br = new BufferedReader(new InputStreamReader(part.getInputStream()));
					String str = br.readLine();
					System.out.println("str : " + str);
					Type optionVoListType = new TypeToken<List<OptionVo>>() {}.getType();
					optionVoList = gson.fromJson(str, optionVoListType);
					System.out.println("optionVo: " + optionVoList);
					for (OptionVo optionVo : optionVoList) {
						System.out.println(optionVo);
					}
				// 파일 처리
				}else if(part.getName().equals("file")) {
					    InputStream in = part.getInputStream();
		
				        String sep = File.separator;
				        String path = req.getServletContext().getRealPath(sep + "resources" + sep + "upload" + sep + "img");
				        String randomName = "content_"+ System.nanoTime() + "_" + UUID.randomUUID();
				        String submittedFileName = part.getSubmittedFileName();
				        int index = submittedFileName.lastIndexOf(".");
				        String ext = submittedFileName.substring(index);
				        String fileName = sep + randomName + ext;
				        File target = new File(path + fileName);
				        FileOutputStream out = new FileOutputStream(target);
				        
				        
				        byte[] buf = new byte[1024];
				        int size = 0;
				        while ((size = in.read(buf)) != -1) {
				            out.write(buf, 0, size);
				        }
				        file = sep +"resources" + sep +"upload"+sep+"img"+fileName;
				        fileNameList.add(file);
				        in.close();
				        out.close();
					}
				
				
			}

			
			SalesVo vo = new SalesVo();
			vo.setTitle(title);
			vo.setPrice(price);
			vo.setStock(stock);
			vo.setOrigin(origin);
			vo.setCategoryNo(categoryNo1);
			vo.setCategoryNo2(categoryNo2);
			vo.setSellerNo(sellerNo);
			vo.setFileName(thumbnail);
			System.out.println(vo.getFileName());
			System.out.println(vo);
			SalesService ss = new SalesService();
			int result = ss.salesRegister(vo , fileNameList ,optionVoList);
		
			if(result != 1) {
				throw new Exception();
			}
			
			req.removeAttribute("register");
			System.out.println("성공");
			resp.getWriter().write("성공");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("상품 등록 하는 중에 오류 발생");
		}
		
	}
	
}
