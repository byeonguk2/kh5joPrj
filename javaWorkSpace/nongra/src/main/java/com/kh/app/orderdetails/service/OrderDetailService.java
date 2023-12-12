package com.kh.app.orderdetails.service;

import java.sql.Connection;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.kh.app.orderdetails.dao.OrderDetailDao;
import com.kh.app.orderdetails.vo.OrderDetailVo;
import com.kh.app.page.vo.PageVo;
import com.kh.app.review.dao.ReviewDao;
import com.kh.app.review.vo.ReviewVo;
import com.kh.app.util.db.JDBCTemplate;

public class OrderDetailService {
//주문 상세 정보 갯수 멤버 넘버로 가져오기  [멤버] 
    public int selectOrderDetailCountByMemberNo(String memberNo) throws Exception {
        
        // conn
        Connection conn = JDBCTemplate.getConnection();
        
        // dao
        OrderDetailDao dao = new OrderDetailDao();
        int cnt = dao.selectOrderDetailCountByMemberNo(conn,memberNo);
        
        // close
        JDBCTemplate.close(conn);
        
        return cnt;
        
    }
    //주문 상세 정보 멤버 넘버로 가져오기 [멤버] 
    public List<OrderDetailVo> memberOrderDetailLookUp(PageVo pvo, String memberNo) throws Exception {
        
        


        // conn
        Connection conn = JDBCTemplate.getConnection();
        
        // dao
        OrderDetailDao dao = new OrderDetailDao();
        
        List<OrderDetailVo> list = dao.manageOrderDetailLookUp(conn,pvo,memberNo);
        // close 
        
        JDBCTemplate.close(conn);        
        return list; 
        
  
    }
    // 오덜 히스토리 구매확정 [멤버]
	public int memberorderSure(String ohNo) throws Exception {
		
		// conn
		Connection conn = JDBCTemplate.getConnection();
		
		// dao
		OrderDetailDao dao = new OrderDetailDao();
		
		//result
		int reuslt = dao.memberorderSure(conn,ohNo);
		
		if(reuslt ==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close 
		JDBCTemplate.close(conn);
		
		return reuslt;
	}
	
    
}//class