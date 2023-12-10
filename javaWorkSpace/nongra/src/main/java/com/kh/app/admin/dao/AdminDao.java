package com.kh.app.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.app.member.vo.MemberVo;
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
		
		String sql = "SELECT COUNT(*) FROM SELLER S JOIN MEMBER M ON (S.MEMBER_NO = M.MEMBER_NO) WHERE REQUEST_QUIT_YN = 'N' AND PERMIT_YN = 'N'";
	
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
		String sql = "SELECT COUNT(*) FROM SELLER S JOIN MEMBER M ON (S.MEMBER_NO = M.MEMBER_NO) WHERE QUIT_YN = 'N' AND PERMIT_YN = 'N' AND "+map.get("option")+" LIKE '%'|| ? ||'%'";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,map.get("searchValue") );
		ResultSet rs = pstmt.executeQuery();
		
		int listCount = 0;
		while(rs.next()) {
			listCount = rs.getInt(1);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return listCount;
		
	}

	public List<SellerVo> search(Connection conn, Map<String, String> map, PageVo pvo) throws Exception {
		
		// 쿼리문 
		String searchType = map.get("option");
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , A.* FROM ( SELECT * FROM SELLER S JOIN MEMBER M ON (S.MEMBER_NO = M.MEMBER_NO) WHERE QUIT_YN = 'N' AND PERMIT_YN = 'N' AND "+searchType+" LIKE '%' || ?|| '%' ORDER BY S.SELLER_NO ) A ) WHERE RNUM BETWEEN ? AND ?";
				
		// pstmt 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, map.get("searchValue"));
		pstmt.setInt(2, pvo.getStartRow());
		pstmt.setInt(3, pvo.getLastRow());
				
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

	public List<SellerVo> memberBen(Connection conn, PageVo pvo) throws Exception {
		
		// 쿼리문 
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , A.* FROM ( SELECT * FROM MEMBER WHERE QUIT_YN = 'N' ORDER BY MEMBER_NO ) A ) WHERE RNUM BETWEEN ? AND ?";
		
		// pstmt 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
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
				String joinDate = rs.getString("JOIN_DATE");
				String freezeYn = rs.getString("FREEZE_YN");
				String sellerYn = rs.getString("SELLER_YN");
				
				SellerVo vo = new SellerVo();
				
				vo.setMemberNo(memberNo);
				vo.setId(id);
				vo.setPassword(pwd);
				vo.setNick(nick);
				vo.setName(name);
				
				vo.setPhone(phone);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				vo.setFreezeYn(freezeYn);
				vo.setSellerYn(sellerYn);
	
				voList.add(vo);
				
		}
		
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
			
			return voList;
	}

	public int selectMemberSellerCount(Connection conn) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE QUIT_YN = 'N'";
		
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

	public int selectMemberSearchCount(Connection conn,Map<String, String> map) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE QUIT_YN = 'N' AND SELLER_YN = ? AND "+map.get("option")+" LIKE '%'|| ? ||'%'";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, map.get("memberType"));
		pstmt.setString(2,map.get("searchValue") );
		ResultSet rs = pstmt.executeQuery();
		
		int listCount = 0;
		while(rs.next()) {
			listCount = rs.getInt(1);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return listCount;
		
	}

	// 모든 멤버 검색
	public List<SellerVo> searchMember(Connection conn, Map<String, String> map, PageVo pvo) throws Exception {
	
		// 쿼리문 
				String searchType = map.get("option");
				
				String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , A.* FROM ( SELECT * FROM MEMBER WHERE QUIT_YN = 'N' AND SELLER_YN = ? AND "+searchType+" LIKE '%' || ?|| '%' ORDER BY MEMBER_NO ) A ) WHERE RNUM BETWEEN ? AND ?";
						
				// pstmt 
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, map.get("memberType"));
				pstmt.setString(2, map.get("searchValue"));
				pstmt.setInt(3, pvo.getStartRow());
				pstmt.setInt(4, pvo.getLastRow());
						
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
					String joinDate = rs.getString("JOIN_DATE");
					String freezeYn = rs.getString("FREEZE_YN");
					String sellerYn = rs.getString("SELLER_YN");
					
					SellerVo vo = new SellerVo();
					
					vo.setMemberNo(memberNo);
					vo.setId(id);
					vo.setPassword(pwd);
					vo.setNick(nick);
					vo.setName(name);
					vo.setPhone(phone);
					vo.setEmail(email);
					vo.setJoinDate(joinDate);
					vo.setFreezeYn(freezeYn);
					vo.setSellerYn(sellerYn);
					
					voList.add(vo);
					
			}
						
					JDBCTemplate.close(pstmt);
					JDBCTemplate.close(rs);
					
				return voList;
		
	}

	public int freezeMember(String no, Connection conn, String yn) throws Exception {
		
		if(yn.equals("Y")) {
			yn = "N";
		}else if(yn.equals("N")) {
			yn = "Y";
		}
		System.out.println(yn);
		String sql = "UPDATE MEMBER SET FREEZE_YN = ? WHERE MEMBER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, yn);
		pstmt.setString(2, no);
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}	
	
	public SellerVo checkAllMembers(Connection conn, String no) throws Exception {
		
		
		String sql = "SELECT * FROM MEMBER M LEFT JOIN SELLER S ON (M.MEMBER_NO = S.MEMBER_NO) WHERE M.MEMBER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		SellerVo vo = null;
		if(rs.next()) {
			
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
			String birthDay = rs.getString("BIRTH_DATE");
			String point = rs.getString("POINT");
			String address = rs.getString("ADDRESS");
			String detailAddress = rs.getString("DETAIL_ADDRESS");
			
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
			vo = new SellerVo();
			
			vo.setMemberNo(memberNo);
			vo.setId(id);
			vo.setPassword(pwd);
			vo.setNick(nick);
			vo.setName(name);
			vo.setPhone(phone);
			vo.setEmail(email);
			vo.setBirthDay(birthDay);
			vo.setPoint(point);
			vo.setMemberAddress(address);
			vo.setMemberDetailAddress(detailAddress);
			
			
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

		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return vo;
		
	}

	// 판매자 개인정보 수정
	public int ModifySeller_InfoByAdmin(SellerVo vo, Connection conn) throws Exception {
		
		String sql = "UPDATE MEMBER SET ID = ?, PWD = ?, NICK = ?, NAME = ?, PHONE = ?, EMAIL = ?, MODIFY_DATE = SYSDATE WHERE MEMBER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getNick());
		pstmt.setString(4, vo.getName());
		pstmt.setString(5, vo.getPhone());
		pstmt.setString(6, vo.getEmail());
		pstmt.setString(7, vo.getMemberNo());
		
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	
	}
	
	// 판매자 사업자정보 수정
	public int ModifySeller_businessInfoByAdmin(SellerVo vo, Connection conn) throws Exception {
		
		String sql = "UPDATE SELLER SET BUSINESS_FORM = ?, BUSINESS_NAME = ?, BUSINESS_PHONE = ?, BUSINEES_ZIPCODE = ?, BUSINESS_ADDRESS = ?, UPTAE = ?, UPJONG = ?, BANK = ?, DEPOSITOR = ?, ACCOUNT = ?, CORPORATION_NAME = ? WHERE MEMBER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getBusinessForm());
		pstmt.setString(2, vo.getBusineesName());
		pstmt.setString(3, vo.getBusineesPhone());
		pstmt.setString(4, vo.getBusineesZipCode());
		pstmt.setString(5, vo.getBusineesAdr());

		pstmt.setString(6, vo.getUptae());
		pstmt.setString(7, vo.getUpjong());
		pstmt.setString(8, vo.getBank());
		pstmt.setString(9, vo.getDepositor());
		
		pstmt.setString(10, vo.getAccount());
		pstmt.setString(11, vo.getCorporationName());
		pstmt.setString(12, vo.getMemberNo());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}

	public int ModifyMemberByAdmin(MemberVo vo, Connection conn) throws Exception {
		
		String sql = "UPDATE MEMBER SET ID = ?, PWD = ?, NICK = ?, NAME = ? , EMAIL = ?, PHONE = ?, BIRTH_DATE = ?, POINT = ?, ADDRESS = ?, DETAIL_ADDRESS = ?, MODIFY_DATE = SYSDATE WHERE MEMBER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMemberId());
		pstmt.setString(2, vo.getMemberPwd());
		pstmt.setString(3, vo.getMemberNick());
		pstmt.setString(4, vo.getName());
		pstmt.setString(5, vo.getEmail());
		pstmt.setString(6, vo.getPhone());
		pstmt.setString(7, vo.getBirth());
		pstmt.setString(8, vo.getPoint());
		pstmt.setString(9, vo.getAddr());
		pstmt.setString(10, vo.getAddr2());
		pstmt.setString(11, vo.getNo());
		
		int result = pstmt.executeUpdate();
		
		System.out.println("판매자 개인정보: "+result);
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
		
	}
	
	public int acceptQuitRequestCount(Connection conn) throws Exception {
		
		String sql = "SELECT COUNT(*) FROM SELLER S JOIN MEMBER M ON (S.MEMBER_NO = M.MEMBER_NO) WHERE REQUEST_QUIT_YN = 'Y' AND PERMIT_YN = 'Y'";
	
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

	public List<SellerVo> acceptQuitRequest(Connection conn, PageVo pvo) throws Exception {
		
		// 쿼리문 
				String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , A.* FROM ( SELECT * FROM SELLER S JOIN MEMBER M ON (S.MEMBER_NO = M.MEMBER_NO) WHERE REQUEST_QUIT_YN = 'Y' AND PERMIT_YN = 'Y' ORDER BY S.SELLER_NO ) A ) WHERE RNUM BETWEEN ? AND ?";
				
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
	
	public int QuitRequestOk(String no , Connection conn) throws Exception {
		
		String sql = "UPDATE MEMBER SET QUIT_YN = 'Y' WHERE MEMBER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		
		
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}
}
