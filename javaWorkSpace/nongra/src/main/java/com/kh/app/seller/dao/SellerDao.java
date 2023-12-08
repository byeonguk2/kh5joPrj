package com.kh.app.seller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.kh.app.seller.vo.SellerVo;
import com.kh.app.util.db.JDBCTemplate;


public class SellerDao {

	// 아이디 체크 로직
	public int idCheck(Connection conn, String id) throws Exception {
		
		// sql문 (WHERE문을 이용해 ID를 조회후 COUNT가 성공하면 1 실패하면 0 반환 )
		String sql = "SELECT COUNT(ID) FROM MEMBER WHERE ID = ?";
		
		// pstmt
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// 회원가입시 받은 아이디 
		pstmt.setString(1, id);
		
		//rs 
		ResultSet rs = pstmt.executeQuery();
		
		// 0상태로 초기화
		int num = 0;
		
		//만약에 rs.next가 존재한다면 1으로 반환 
		if(rs.next()) {
			num = rs.getInt(1);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		// return 
		return num;
	}
	
	// 판매자 회원가입 
	public int join(SellerVo joinVo, Connection conn, String[] strArr) throws Exception {
		
		// sql 쿼리문 
		String sql = "INSERT ALL INTO MEMBER ( MEMBER_NO ,ID ,NICK ,PWD ,EMAIL ,NAME ,PHONE , SELLER_YN) VALUES (SEQ_MEMBER.NEXTVAL,?,?,?,?,?,?,'Y') INTO SELLER ( SELLER_NO ,MEMBER_NO ,BUSINESS_NO ,BUSINESS_FORM ,BUSINESS_NAME ,BUSINESS_PHONE ,CORPORATION_NAME ,UPTAE ,UPJONG ,BUSINEES_ZIPCODE ,BUSINESS_ADDRESS ,DETAILED_ADR ,REPORT_NUMBER ,BANK ,DEPOSITOR ,ACCOUNT ) VALUES (SEQ_SELLER.NEXTVAL,SEQ_MEMBER.CURRVAL,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?) INTO BUSINESS_FILE ( FILE_NO,SELLER_NO,FILE_SRC ) VALUES ( SEQ_BUSINESS_FILE.NEXTVAL,SEQ_SELLER.CURRVAL,?) INTO BUSINESS_FILE ( FILE_NO,SELLER_NO,FILE_SRC ) VALUES ((SELECT GET_ITEM_SEQ()FROM DUAL),SEQ_SELLER.CURRVAL,?) SELECT * FROM DUAL";
		
		// pstmt 생성 
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// 인서트문에 값 넣기 
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
		
		pstmt.setString(21, strArr[0]);
		pstmt.setString(22, strArr[1]);
		
		// result로 업데이트된 행 수 가져오기 
		int result = pstmt.executeUpdate();
		
		// pstmt close
		JDBCTemplate.close(pstmt);
		
		// result return
		return result;
	}
	
	// 판매자 로그인
	public SellerVo login(SellerVo vo, Connection conn) throws Exception {
		
		String sql = "SELECT * FROM SELLER S JOIN MEMBER M ON (S.MEMBER_NO = M.MEMBER_NO) WHERE QUIT_YN ='N' AND M.ID = ? AND M.PWD = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPassword());
		
		ResultSet rs = pstmt.executeQuery();
		
		SellerVo loginSeller = null;
		if(rs.next()) {
			
			System.out.println(rs.getString("MEMBER_NO"));
			
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
			loginSeller.setPermitYn(permitYn);
			loginSeller.setJoinDate(joinDate);
			
		}
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		
		return loginSeller;
	}

	public int nickCheck(Connection conn, String nick) throws Exception {
		// sql문 (WHERE문을 이용해 ID를 조회후 COUNT가 성공하면 1 실패하면 0 반환 )
		String sql = "SELECT COUNT(NICK) FROM MEMBER WHERE NICK = ?";
		
		// pstmt
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// 회원가입시 받은 아이디 
		pstmt.setString(1,nick);
		
		//rs 
		ResultSet rs = pstmt.executeQuery();
		
		// 0상태로 초기화
		int num = 0;
		
		//만약에 rs.next가 존재한다면 1으로 반환 
		if(rs.next()) {
			num = rs.getInt(1);
		}
		
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
				
		// return 
		return num;
	}

	public int modify(SellerVo vo, Connection conn) throws Exception {
		
		String sql = "UPDATE MEMBER SET PWD = ?, NICK = ?, NAME = ?, PHONE = ?, EMAIL = ?, MODIFY_DATE = SYSDATE WHERE MEMBER_NO = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPassword());
		pstmt.setString(2, vo.getNick());
		pstmt.setString(3, vo.getName());
		pstmt.setString(4, vo.getPhone());
		pstmt.setString(5, vo.getEmail());
		pstmt.setString(6, vo.getMemberNo());
		
		int result = pstmt.executeUpdate();
		
		//close
		JDBCTemplate.close(pstmt);
		
		return result;
	}

	public int businessInfo(SellerVo vo, Connection conn) throws Exception {
		
		String sql = "UPDATE SELLER SET BUSINESS_FORM = ?, BUSINESS_NAME = ?, BUSINESS_PHONE = ?, BUSINEES_ZIPCODE = ?, BUSINESS_ADDRESS = ?, UPTAE = ?, UPJONG = ?, BANK = ?, DEPOSITOR = ?, ACCOUNT = ?, CORPORATION_NAME = ? WHERE SELLER_NO = ?";
		
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
		pstmt.setString(12, vo.getSellerNo());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}
