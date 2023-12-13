package com.kh.app.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.app.admin.vo.AdminVo;
import com.kh.app.admin.vo.MemberDTO;
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

	// 모든 회원 조회
	public List<MemberDTO> findAllMembers(Connection conn, PageVo pvo) throws Exception {
		
		// SQL 쿼리문 
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , A.* FROM ( SELECT * FROM MEMBER M LEFT JOIN SELLER S ON (M.MEMBER_NO = S.MEMBER_NO) WHERE M.QUIT_YN = 'N' ORDER BY M.MEMBER_NO ) A ) WHERE RNUM BETWEEN ? AND ?";
		
		// pstmt 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pvo.getStartRow());
		pstmt.setInt(2, pvo.getLastRow());
		
		// rs
		ResultSet rs = pstmt.executeQuery();
		
		// 모든 회원 정보 받아오기 
		List<MemberDTO> memberVoList = new ArrayList<MemberDTO>();

	 	// rs반복
		while(rs.next()) {
				
			// member 테이블 값 
			String memberNo = rs.getString("MEMBER_NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String name = rs.getString("NAME");
			String phone = rs.getString("PHONE");
			String address = rs.getString("ADDRESS");
			String detailAddress = rs.getString("DETAIL_ADDRESS");
			String birthDate = rs.getString("BIRTH_DATE");
			String profile = rs.getString("PROFILE");
			String quitYn = rs.getString("QUIT_YN");
			String joinDate = rs.getString("JOIN_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			int point = rs.getInt("POINT");
			String email = rs.getString("EMAIL");
			String freezeYn = rs.getString("FREEZE_YN");
			String sellerYn = rs.getString("SELLER_YN");
			
			// seller 테이블 값
			String sellerNo = rs.getString("SELLER_NO");
			String businessNo = rs.getString("MEMBER_NO");
			String businessForm = rs.getString("BUSINESS_NO");
			String businessName = rs.getString("BUSINESS_FORM");
			String businessPhone = rs.getString("BUSINESS_NAME");
			String busineesZipcode = rs.getString("BUSINESS_PHONE");
			String businessAddress = rs.getString("BUSINESS_ADDRESS");
			String detailedAdr = rs.getString("DETAILED_ADR");
			String corporationName = rs.getString("CORPORATION_NAME");
			String uptae = rs.getString("UPTAE");
			String upjong = rs.getString("UPJONG");
			String reportNumber = rs.getString("REPORT_NUMBER");
			String bank = rs.getString("BANK");
			String permitYn = rs.getString("PERMIT_YN");
			String depositor = rs.getString("DEPOSITOR");
			String account = rs.getString("ACCOUNT");
			String requestQuitYn = rs.getString("REQUEST_QUIT_YN");
			String modifyYn = rs.getString("MODIFY_YN");

			// 생성자로 할당
			MemberDTO memberDTO = new MemberDTO(memberNo, id, pwd, nick, name, phone, detailAddress, profile, quitYn, joinDate, modifyDate, email, freezeYn, sellerYn, sellerNo, businessNo, businessForm, businessName, businessPhone, busineesZipcode, businessAddress, corporationName, uptae, upjong, reportNumber, bank, permitYn, depositor, account, requestQuitYn, modifyYn); 
			
			memberVoList.add(memberDTO);
				
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
			
		// return
		return memberVoList;
		
	}

	// 모든 회원의 수 구하기
	public int totalOfAllMembers(Connection conn) throws Exception {
		
		// sql
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE QUIT_YN = 'N'";
		
		// pstmt
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// rs 
		ResultSet rs = pstmt.executeQuery();
		
		// listConut 기본값으로 설정
		int memberCount = 0;
		
		// 회원 모든수 구하기
		if(rs.next()) {
			memberCount = rs.getInt(1);
		}
		
		// close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		// return
		return memberCount;
		
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
	public List<MemberDTO> searchMember(Connection conn, Map<String, String> map, PageVo pvo) throws Exception {
	
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
				List<MemberDTO> voList = new ArrayList<MemberDTO>();

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
					
					MemberDTO vo = new MemberDTO();
					
					vo.setMemberNo(memberNo);
					vo.setId(id);
					vo.setPwd(pwd);
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
	public int ModifySeller_InfoByAdmin(MemberDTO memberDTO, Connection conn) throws Exception {
		
		// sql 
		String sql = "UPDATE MEMBER SET ID = ?, PWD = ?, NICK = ?, NAME = ?, PHONE = ?, EMAIL = ?, MODIFY_DATE = SYSDATE WHERE MEMBER_NO = ?";
		
		// pstmt
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberDTO.getId());
		pstmt.setString(2, memberDTO.getPwd());
		pstmt.setString(3, memberDTO.getNick());
		pstmt.setString(4, memberDTO.getName());
		pstmt.setString(5, memberDTO.getPhone());
		pstmt.setString(6, memberDTO.getEmail());
		pstmt.setString(7, memberDTO.getMemberNo());
		
		// result
		int result = pstmt.executeUpdate();
		
		// close
		JDBCTemplate.close(pstmt);
		
		// return
		return result;
	
	}
	
	// 판매자 사업자정보 수정
	public int ModifySeller_businessInfoByAdmin(MemberDTO memberDTO, Connection conn) throws Exception {
		
		// sql
		String sql = "UPDATE SELLER SET BUSINESS_FORM = ?, BUSINESS_NAME = ?, BUSINESS_PHONE = ?, BUSINEES_ZIPCODE = ? , DETAILED_ADR = ? , BUSINESS_ADDRESS = ?, UPTAE = ?, UPJONG = ?, BANK = ?, DEPOSITOR = ?, ACCOUNT = ?, CORPORATION_NAME = ? WHERE MEMBER_NO = ?";
		
		// pstmt
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, memberDTO.getBusinessForm());
		pstmt.setString(2, memberDTO.getBusinessName());
		pstmt.setString(3, memberDTO.getBusinessPhone());
		pstmt.setString(4, memberDTO.getBusineesZipcode());
		pstmt.setString(5, memberDTO.getDetailAddress());
		pstmt.setString(6, memberDTO.getAddress());

		pstmt.setString(7, memberDTO.getUptae());
		pstmt.setString(8, memberDTO.getUpjong());
		pstmt.setString(9, memberDTO.getBank());
		pstmt.setString(10, memberDTO.getDepositor());
		
		pstmt.setString(11, memberDTO.getAccount());
		pstmt.setString(12, memberDTO.getCorporationName());
		pstmt.setString(13, memberDTO.getMemberNo());
		
		// result 
		int result = pstmt.executeUpdate();
		
		// close 
		JDBCTemplate.close(pstmt);
		
		// return
		return result;
		
	}
	
	// 소비자 정보 수정
	public int ModifyMemberByAdmin(MemberDTO dto, Connection conn) throws Exception {
		
		// sql
		String sql = "UPDATE MEMBER SET ID = ?, PWD = ?, NICK = ?, NAME = ? , EMAIL = ?, PHONE = ?, BIRTH_DATE = ?, POINT = ?, ADDRESS = ?, DETAIL_ADDRESS = ?, MODIFY_DATE = SYSDATE WHERE MEMBER_NO = ?";
		
		// pstmt
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPwd());
		pstmt.setString(3, dto.getNick());
		pstmt.setString(4, dto.getName());
		pstmt.setString(5, dto.getEmail());
		pstmt.setString(6, dto.getPhone());
		pstmt.setString(7, dto.getBirthDate());
		pstmt.setInt(8, dto.getPoint());
		pstmt.setString(9, dto.getAddress());
		pstmt.setString(10, dto.getDetailAddress());
		pstmt.setString(11, dto.getMemberNo());
		
		// result
		int result = pstmt.executeUpdate();
		
		//	close
		JDBCTemplate.close(pstmt);
		
		// return
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
				String sql = "SELECT * FROM ( SELECT ROWNUM RNUM , A.* FROM ( SELECT * FROM SELLER S JOIN MEMBER M ON (S.MEMBER_NO = M.MEMBER_NO) WHERE REQUEST_QUIT_YN = 'Y' AND QUIT_YN = 'N' AND PERMIT_YN = 'Y' ORDER BY S.SELLER_NO ) A ) WHERE RNUM BETWEEN ? AND ?";
				
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

	public AdminVo login(Connection conn, AdminVo vo) throws Exception {
		
		String sql = "SELECT * FROM ADMIN WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getAdminId());
		pstmt.setString(2, vo.getAdminPwd());
		
		ResultSet rs = pstmt.executeQuery();
		
		AdminVo loginAdmin = null;
		if(rs.next()) {
			loginAdmin = new AdminVo(); 
			loginAdmin.setManagerNo(rs.getString("MANAGER_NO"));
			loginAdmin.setAdminId(rs.getString("ID"));
			loginAdmin.setAdminPwd(rs.getString("PAW"));
			loginAdmin.setAdminNick(rs.getString("NICK"));
			
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return loginAdmin;
		
	}
}
