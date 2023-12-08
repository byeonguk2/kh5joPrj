/*
 * package com.kh.app.review.controller;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import com.kh.app.admin.controller.requestOkControlle; import
 * com.kh.app.review.service.ReviewService;
 * 
 * @WebServlet() public class AdminManagerReviewDeleteController extends
 * HttpServlet{
 * 
 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
 * resp) throws ServletException, IOException {
 * 
 * 
 * try {
 * 
 * //data String deleteNo = req.getParameter("DeleteNo"); //service
 * ReviewService rs = new ReviewService();
 * 
 * //result int result = rs.AdminManagerReviewDelete(deleteNo);
 * 
 * if(result !=1) { throw new Exception(); }
 * 
 * 
 * 
 * } catch (Exception e) { }
 * 
 * req.getRequestDispatcher("WEB-INF/views/review/adminManageReview.jsp"); } }
 */