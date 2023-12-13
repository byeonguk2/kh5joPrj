package com.kh.app.member.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.orderdetails.dao.OrderDetailDao;
import com.kh.app.orderdetails.vo.OrderDetailVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.point.vo.PointVo;
import com.kh.app.review.vo.ReviewVo;
import com.kh.app.util.db.JDBCTemplate;

public class MemberService {
	// 로그인
	public MemberVo login(MemberVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn, vo);

		// close
		JDBCTemplate.close(conn);
		return loginMember;
	}

	// 회원가입
	public int join(MemberVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		MemberDao dao = new MemberDao();
		int result = dao.join(conn, vo);

		// tx
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		// close
		JDBCTemplate.close(conn);
		return result;
	}

	// 회원탈퇴
	public int delete(String no) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		MemberDao dao = new MemberDao();
		int result = dao.delete(conn, no);

		// tx
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		// close
		JDBCTemplate.close(conn);
		return result;
	}

	// 회원정보 수정
	public int modify(MemberVo vo) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		MemberDao dao = new MemberDao();
		int result = dao.modify(conn, vo);

		// tx
		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		// close
		JDBCTemplate.close(conn);
		return result;
	}

	// 포인트 조회
	public PointVo checkPoint(MemberVo loginMember) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		MemberDao dao = new MemberDao();
		PointVo pv = dao.checkPoint(conn, loginMember);

		// close
		JDBCTemplate.close(conn);
		return pv;
	}

	// 포인트 충전
	public int charge(MemberVo loginMember, String chargePoint) throws Exception {
		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		MemberDao dao = new MemberDao();
		int result = dao.charge(conn, loginMember, chargePoint);
		result += dao.update(conn, loginMember, chargePoint);

		// tx
		if (result == 2) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		// close
		JDBCTemplate.close(conn);
		return result;
	}

	// 마이페이지 최근 주문내역
	public int selectReviewCount(String memberNo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		OrderDetailDao dao = new OrderDetailDao();
		int cnt = dao.selectOrderDetailCountByMemberNo(conn, memberNo);

		// close
		JDBCTemplate.close(conn);

		return cnt;

	}

	// 주문 상세 정보 멤버 넘버로 가져오기 [멤버]
	public List<OrderDetailVo> memberReviewLookUp(PageVo pvo, String memberNo) throws Exception {

		// conn
		Connection conn = JDBCTemplate.getConnection();

		// dao
		OrderDetailDao dao = new OrderDetailDao();

		List<OrderDetailVo> list = dao.manageOrderDetailLookUp(conn, pvo, memberNo);
		// close

		JDBCTemplate.close(conn);
		return list;
		
		

	}

}
