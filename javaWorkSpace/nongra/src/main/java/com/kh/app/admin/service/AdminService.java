package com.kh.app.admin.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.app.admin.dao.AdminDao;
import com.kh.app.admin.vo.AdminVo;
import com.kh.app.admin.vo.MemberDTO;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.seller.dao.SellerDao;
import com.kh.app.seller.vo.SellerVo;
import com.kh.app.util.db.JDBCTemplate;

public class AdminService {

	public List<SellerVo> request(PageVo pvo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		AdminDao as = new AdminDao();
		List<SellerVo> voList = as.request(conn,pvo);
		
		JDBCTemplate.close(conn);
		
		
		return voList;

	}

	public int selectrequestSellerCount() throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		AdminDao dao = new AdminDao();
		int listCount = dao.selectrequestSellerCount(conn);
		
		JDBCTemplate.close(conn);
		
		return listCount;
		
	}

	public Map<String, Object> selectBusinessInfo(String no) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		AdminDao dao = new AdminDao();
		
		SellerVo vo = dao.selectBusinessInfo(conn,no);
		List<SellerVo> fileList = dao.selectBusinessFile(conn,no);
		
		Map<String, Object> map = new HashMap<>();
		
		System.out.println(fileList);
		
		map.put("vo", vo);
		map.put("fileList", fileList.get(0).getFileSrc());
		map.put("fileList2", fileList.get(1).getFileSrc());
		
		JDBCTemplate.close(conn);
		
		return map;
	}

	public int requestOk(String no) throws Exception {
		
		// connection
		Connection conn = JDBCTemplate.getConnection();
		
		// dao 호출 
		AdminDao dao = new AdminDao();
		int result = dao.requestOk(no,conn);
		
		// result가 4면 커밋 아니면 롤백 
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
			
		// connection close 
		JDBCTemplate.close(conn);
		
		// result return
		return result;
	}

	public int selectSearchSellerCount(Map<String, String> map) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		AdminDao dao = new AdminDao();
		int listCount = dao.selectSearchSellerCount(conn,map);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	
	}

	public List<SellerVo> search(Map<String, String> map, PageVo pvo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
				
		// DAO
		AdminDao dao = new AdminDao();
		List<SellerVo> sellerVoList = dao.search(conn , map, pvo);
				
		//close
		JDBCTemplate.close(conn);
				
		return sellerVoList;
		
	}

	// 모든 회원 조회하기
	public List<MemberDTO> findAllMembers(PageVo pvo) throws Exception{
		
		// conn 
		Connection conn = JDBCTemplate.getConnection();
		
		// dao 생성 / 호출
		AdminDao dao = new AdminDao();
		List<MemberDTO> voList = dao.findAllMembers(conn,pvo);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

	// 모든 회원 수 총합
	public int totalOfAllMembers() throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao 생성/호출
		AdminDao dao = new AdminDao();
		int memberCount = dao.totalOfAllMembers(conn);
		
		// close
		JDBCTemplate.close(conn);
		
		// return
		return memberCount;
		
	}

	public int selectMemberSearchCount(Map<String, String> map)throws Exception  {
		Connection conn = JDBCTemplate.getConnection();
		
		AdminDao dao = new AdminDao();
		int listCount = dao.selectMemberSearchCount(conn,map);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}

	// 회원 검색 / 사업자 소비자 구분해서 검색 가능 /
	public List<MemberDTO> searchMember(Map<String, String> map, PageVo pvo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
						
		// DAO
		AdminDao dao = new AdminDao();
		List<MemberDTO> sellerVoList = dao.searchMember(conn , map, pvo);
						
		//close
		JDBCTemplate.close(conn);
						
		return sellerVoList;

	}

	public int freezeMember(String no, String yn) throws Exception {
		
		// connection
		Connection conn = JDBCTemplate.getConnection();
		
		// dao 호출 
		AdminDao dao = new AdminDao();
		int result = dao.freezeMember(no,conn,yn);
		
		// result가 4면 커밋 아니면 롤백 
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
			
		// connection close 
		JDBCTemplate.close(conn);
		
		// result return
		return result;

	}
	
	// 회원 검색 / 사업자 소비자 구분해서 검색 가능 /
		public SellerVo checkAllMembers(String no) throws Exception {
			
			// conn
			Connection conn = JDBCTemplate.getConnection();
							
			// DAO
			AdminDao dao = new AdminDao();
			SellerVo sellerVo = dao.checkAllMembers(conn , no);
							
			//close
			JDBCTemplate.close(conn);
							
			return sellerVo;
			
		}

		public int ModifySellerByAdmin(MemberDTO memberDTO) throws Exception {
			
			// 비즈니스 로직
			if(memberDTO.getBusinessNo().length() != 10) {
				throw new Exception("사업자 번호는 10자리가 아님.");
			}
			
			if(memberDTO.getBusinessPhone().length() >= 11) {;
				throw new Exception("전화번호는 11자리 미만으로 입력.");
			}
			
			// connection
			Connection conn = JDBCTemplate.getConnection();
			
			// dao 호출 
			AdminDao dao = new AdminDao();
			
			// 오라클은 다중 업데이트 불가능...
			int result = dao.ModifySeller_businessInfoByAdmin(memberDTO,conn);
			result += dao.ModifySeller_InfoByAdmin(memberDTO,conn);
			
			// result가 2이면 커밋 아니면 롤백 
			if(result == 2) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			
			// connection close 
			JDBCTemplate.close(conn);
			
			// return
			return result;
			
		}

		// 소비자 정보 수정하기
		public int ModifyMemberByAdmin(MemberDTO memberDTO) throws Exception {
			
			// connection
			Connection conn = JDBCTemplate.getConnection();
			
			// dao 호출 
			AdminDao dao = new AdminDao();
			int result = dao.ModifyMemberByAdmin(memberDTO,conn);
			
			// result가 1이면 커밋 아니면 롤백 
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
				
			// connection close 
			JDBCTemplate.close(conn);
			
			// return
			return result;
			
		}
		
		public int acceptQuitRequestCount() throws Exception {
			
			Connection conn = JDBCTemplate.getConnection();
			
			AdminDao dao = new AdminDao();
			int listCount = dao.acceptQuitRequestCount(conn);
			
			JDBCTemplate.close(conn);
			
			return listCount;
			
		}

		public List<SellerVo> acceptQuitRequest(PageVo pvo) throws Exception {
			
			Connection conn = JDBCTemplate.getConnection();
			
			AdminDao as = new AdminDao();
			List<SellerVo> voList = as.acceptQuitRequest(conn,pvo);
			
			JDBCTemplate.close(conn);
			
			
			return voList;
			
		}
	
		public int QuitRequestOk(String no) throws Exception {
			
			// connection
			Connection conn = JDBCTemplate.getConnection();
			
			// dao 호출 
			AdminDao dao = new AdminDao();
			int result = dao.QuitRequestOk(no,conn);
			
			// result가 1이면 커밋 아니면 롤백 
			if(result == 1) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
				
			// connection close 
			JDBCTemplate.close(conn);
			
			return result;
			
		}

		public AdminVo login(AdminVo vo) throws Exception {
			
			Connection conn = JDBCTemplate.getConnection();
			
			AdminDao adminDao = new AdminDao();
			AdminVo loginAdmin = adminDao.login(conn,vo);
			
			JDBCTemplate.close(conn);
			
			
			return loginAdmin;
			
		}
		
}
