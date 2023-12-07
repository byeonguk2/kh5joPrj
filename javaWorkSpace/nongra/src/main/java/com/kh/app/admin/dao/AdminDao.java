package com.kh.app.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.app.page.vo.PageVo;
import com.kh.app.seller.vo.SellerVo;
import com.kh.app.util.db.JDBCTemplate;

public class AdminDao {

	public List<SellerVo>request(Connection conn, PageVo pvo) throws Exception {
		
		// 쿼리문 
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , A.* FROM ( SELECT * FROM SELLER S JOIN MEMBER M ON (S.MEMBER_NO = M.MEMBER_NO) WHERE QUIT_YN = 'N' AND PERMIT_YN = 'N' ORDER BY S.SELLER_NO ) A ) WHERE RNUM BETWEEN ? AND ?";
		
		// pstmt 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		System.out.println(pvo.getStartRow()+"||"+pvo.getLastRow());
		pstmt.setInt(2, pvo.getLastRow());
		
		// rs
		ResultSet rs = pstmt.executeQuery();
		
		// 판매자 리스트 
		List<SellerVo> voList = new ArrayList<SellerVo>();

	 	// rs반복
		while(rs.next()) {
				
				// member 테이블 값 
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
				
				String joinDate = rs.getString("JOIN_DATE");
				String permitYn = rs.getString("PERMIT_YN");
				String requestYn = rs.getString("REQUEST_QUIT_YN");
				String modifyYn = rs.getString("MODIFY_YN");
				
				// 파일 정보 가져오기
				
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
				vo.setRequestYn(requestYn);
				
				vo.setModifyYn(modifyYn);
				
				voList.add(vo);
				
		}
		
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			
		return voList;
	}

	public int selectrequestSellerCount(Connection conn) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM SELLER S JOIN MEMBER M ON (S.MEMBER_NO = M.MEMBER_NO) WHERE QUIT_YN = 'N' AND PERMIT_YN = 'N'";
	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		int listCount = 0;
		
		if(rs.next()) {
			listCount = rs.getInt(1);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return listCount;
		
	}

	public SellerVo selectBusinessInfo(Connection conn, String no) throws Exception {
		
		String sql = "SELECT * FROM SELLER WHERE SELLER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		SellerVo vo = null;
		if(rs.next()) {
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
			
			
			vo = new SellerVo();
			
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
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return vo;
	}

	public List<SellerVo> selectBusinessFile(Connection conn, String no) throws Exception {
		
		String sql = "SELECT * FROM BUSINESS_FILE WHERE SELLER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		List<SellerVo> SellerFileList = new ArrayList<SellerVo>();
		
		while(rs.next()) {
			SellerVo vo = new SellerVo();
			String fileSrc = rs.getString("FILE_SRC");
			vo.setFileSrc(fileSrc);
			SellerFileList.add(vo);
		}
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return SellerFileList;
	}
	
	public int requestOk(String no , Connection conn) throws Exception {
		
		String sql = "UPDATE SELLER SET PERMIT_YN = 'Y' WHERE SELLER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		
		
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int selectSearchSellerCount(Connection conn, Map<String, String> map) throws Exception {
		
		String searchValue = map.get("searchType");
		
		String sql = "SELECT COUNT(*) FROM BOARD WHERE STATUS = 'O' AND "+searchValue+" LIKE '%'|| ? ||'%'";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,map.get("searchValue") );
		ResultSet rs = pstmt.executeQuery();
		
		int listCount = 0;
		while(rs.next()) {
			listCount = rs.getInt("COUNT(*)");
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return listCount;
		
	}
	
}
