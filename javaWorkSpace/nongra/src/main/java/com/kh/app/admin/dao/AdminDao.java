package com.kh.app.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.app.seller.vo.SellerVo;
import com.kh.app.util.db.JDBCTemplate;

public class AdminDao {

	public List<SellerVo> request(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM SELLER S JOIN MEMBER M ON (S.MEMBER_NO = M.MEMBER_NO) WHERE REQUEST_QUIT_YN = 'Y'";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<SellerVo> voList = new ArrayList<SellerVo>();
		while(rs.next()) {
			
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
			String permitYn = rs.getString("PERMIT_YN");
			String joinDate = rs.getString("JOIN_DATE");
			
			SellerVo vo = new SellerVo();
			
			vo.setMemberNo(memberNo);
			vo.setId(id);
			vo.setPassword(pwd);
			vo.setNick(nick);
			vo.setName(name);
			vo.setPhone(phone);
			vo.setEmail(email);
			
			vo.setSellerNo(sellerNo);
			vo.setBusinessNo(businessNo);
			vo.setBusinessForm(businessForm);
			vo.setBusineesName(businessName);
			vo.setBusineesPhone(businessPhone);
			
			vo.setBusineesZipCode(businessZipcode);
			vo.setBusineesAdr(businessAdr);
			vo.setDetailedAdr(detailedAdr);
			vo.setCorporationName(copporationName);
			vo.setUptae(uptae);
			
			vo.setUpjong(upjong);
			vo.setReportNumber(reportNumber);
			vo.setBank(bank);
			vo.setDepositor(depositor);
			vo.setAccount(account);
			vo.setPermitYn(permitYn);
			vo.setJoinDate(joinDate);
			
			voList.add(vo);
			
		}
		
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		
		return voList;
	}
	
}
