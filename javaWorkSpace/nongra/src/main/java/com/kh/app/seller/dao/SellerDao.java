package com.kh.app.seller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.app.seller.vo.SellerVo;
import com.kh.app.util.db.JDBCTemplate;


public class SellerDao {

	public int idCheck(Connection conn, String id) throws Exception {
		
		String sql = "SELECT COUNT(ID) FROM MEMBER WHERE ID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		int returnId = 0;
		
		if(rs.next()) {
			returnId = rs.getInt(1);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return returnId;
	}

	public int join(SellerVo joinVo, Connection conn) throws Exception {
		
		String sql = "INSERT ALL INTO MEMBER( MEMBER_NO ,ID ,NICK ,PWD ,EMAIL ,NAME ,PHONE ) VALUES (SEQ_MEMBER.NEXTVAL,?,?,?,?,?,?) INTO SELLER( SELLER_NO ,BUSINESS_NO ,BUSINESS_FORM ,BUSINESS_NAME ,BUSINESS_PHONE ,CORPORATION_NAME ,UPTAE ,UPJONG,BUSINEES_ZIPCODE ,BUSINESS_ADDRESS ,DETAILED_ADR ,REPORT_NUMBER ,BANK ,DEPOSITOR ,ACCOUNT ) VALUES (SEQ_SELLER.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?) SELECT * FROM DUAL";
		
		System.out.println("들어");
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, joinVo.getId());
		pstmt.setString(2, joinVo.getNick());
		pstmt.setString(3, joinVo.getPassword());
		pstmt.setString(4, joinVo.getEmail());
		pstmt.setString(5, joinVo.getName());
		pstmt.setString(6, joinVo.getPhone());
		pstmt.setString(7, joinVo.getBusinessNo());
		pstmt.setString(8, joinVo.getBusinessForm());
		pstmt.setString(9, joinVo.getBusineesName());
		pstmt.setString(10, joinVo.getBusineesPhone());
		pstmt.setString(11, joinVo.getCorporationName());
		pstmt.setString(12, joinVo.getUptae());
		pstmt.setString(13, joinVo.getUpjong());
		pstmt.setString(14, joinVo.getBusineesZipCode());
		pstmt.setString(15, joinVo.getBusineesAdr());
		pstmt.setString(16, joinVo.getDetailedAdr());
		pstmt.setString(17, joinVo.getReportNumber());
		pstmt.setString(18, joinVo.getBank());
		pstmt.setString(19, joinVo.getDepositor());
		pstmt.setString(20, joinVo.getAccount());
		
		int result = pstmt.executeUpdate();
		
		System.out.println(result);
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public String selectNo(SellerVo vo, Connection conn) throws Exception {
		
		String sql = "SELECT SELLER_NO FROM SELLER WHERE BUSINESS_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getBusinessNo());
		ResultSet rs = pstmt.executeQuery();
		String sellerNo = null;
		
		if(rs.next()) {
			sellerNo = rs.getString("SELLER_NO");
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return sellerNo;
	}

	public int insertNo(SellerVo vo, Connection conn) throws Exception {
		
		String sql = "UPDATE MEMBER SET SELLER_NO = ? WHERE ID = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getSellerNo());
		pstmt.setString(2, vo.getId());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public SellerVo login(SellerVo vo, Connection conn) throws Exception {
		
		String sql = "SELECT * FROM MEMBER M JOIN SELLER S ON (M.SELLER_NO = S.SELLER_NO) WHERE M.ID = ? AND M.PWD = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPassword());
		
		ResultSet rs = pstmt.executeQuery();
		
		SellerVo loginSeller = null;
		if(rs.next()) {
			
			String memberNo = rs.getString("MEMBER_NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String name = rs.getString("NAME");
			String phone = rs.getString("PHONE");
			String email = rs.getString("EMAIL");
			
			// 여기부터 사업자정보 
			String sellerNo  = rs.getString("SELLER_NO");
			String businessNo = rs.getString("BUSINESS_NO");
			String businessForm = rs.getString("BUSINESS_FORM");
			String businessName = rs.getString("BUSINESS_NAME");
			String businessPhone = rs.getString("BUSINESS_PHONE");
			
			String businessZipcode = rs.getString("BUSINEES_ZIPCODE");
			String businessAdr = rs.getString("BUSINESS_ADDRESS");
			String detailedAdr = rs.getString("DETAILED_ADR");
			String copporationName = rs.getString("CORPORATION_NAME");
			String uptae = rs.getString("UPTAE");
			
			String upjong = rs.getString("UPJONG");
			String reportNumber = rs.getString("REPORT_NUMBER");
			String bank = rs.getString("BANK");
			String depositor = rs.getString("DEPOSITOR");
			String account = rs.getString("ACCOUNT");
			
			loginSeller = new SellerVo();
			
			loginSeller.setMemberNo(memberNo);
			loginSeller.setId(id);
			loginSeller.setPassword(pwd);
			loginSeller.setNick(nick);
			loginSeller.setName(name);
			loginSeller.setPhone(phone);
			loginSeller.setEmail(email);
			
			loginSeller.setSellerNo(sellerNo);
			loginSeller.setBusinessNo(businessNo);
			loginSeller.setBusinessForm(businessForm);
			loginSeller.setBusineesName(businessName);
			loginSeller.setBusineesPhone(businessPhone);
			
			loginSeller.setBusineesZipCode(businessZipcode);
			loginSeller.setBusineesAdr(businessAdr);
			loginSeller.setDetailedAdr(detailedAdr);
			loginSeller.setCorporationName(copporationName);
			loginSeller.setUptae(uptae);
			
			loginSeller.setUpjong(upjong);
			loginSeller.setReportNumber(reportNumber);
			loginSeller.setBank(bank);
			loginSeller.setDepositor(depositor);
			loginSeller.setAccount(account);
		}
		System.out.println("들어옴");
		System.out.println(loginSeller);
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return loginSeller;
	}

}
