package com.kh.app.page.vo;

public class PageVoTest2 {
	// 민경 테스트 시도 중,,  
		private int totalPostCnt; 			// 총 게시글 갯수
		private int initialPostCnt;			// 최초 페이지에 보여줄 글 갯수  
		private int additionalPostCnt;		// 클릭하면 더 보여줄 글 갯수
		private int requestedPageCnt;          // 요청된 페이지 수 ( 초기 0으로 설정 & 클릭한번하면 1씩 추가로 ,, 바꾸면 row수도 수정해야함 // 고민중 -> 초기 페이지 1, 클릭하면 2페이지)

		private int maxPage;		// 가장 마지막 페이지 

		private int startRow; 		// 조회할 첫번재 행 번호 (ROWNUM)
		private int lastRow; 		// 조회할 마지막 행 번호 (ROWNUM)

}
