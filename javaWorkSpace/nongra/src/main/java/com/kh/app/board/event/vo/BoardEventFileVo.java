package com.kh.app.board.event.vo;

public class BoardEventFileVo {
	private String fileNo;
	private String boardEventNo;
	private String fileName;
	private String mainYn;
	public BoardEventFileVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardEventFileVo(String fileNo, String boardEventNo, String fileName, String mainYn) {
		super();
		this.fileNo = fileNo;
		this.boardEventNo = boardEventNo;
		this.fileName = fileName;
		this.mainYn = mainYn;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getBoardEventNo() {
		return boardEventNo;
	}
	public void setBoardEventNo(String boardEventNo) {
		this.boardEventNo = boardEventNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMainYn() {
		return mainYn;
	}
	public void setMainYn(String mainYn) {
		this.mainYn = mainYn;
	}
	@Override
	public String toString() {
		return "BoardEventFileVo [fileNo=" + fileNo + ", boardEventNo=" + boardEventNo + ", fileName=" + fileName
				+ ", mainYn=" + mainYn + "]";
	}
	
	
}
