package com.kh.app.board.tip.vo;

public class BoardTipFileVo {
	private String fileNo;
	private String boardTipNo;
	private String fileName;
	private String mainYn;
	public BoardTipFileVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardTipFileVo(String fileNo, String boardTipNo, String fileName, String mainYn) {
		super();
		this.fileNo = fileNo;
		this.boardTipNo = boardTipNo;
		this.fileName = fileName;
		this.mainYn = mainYn;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getBoardTipNo() {
		return boardTipNo;
	}
	public void setBoardTipNo(String boardTipNo) {
		this.boardTipNo = boardTipNo;
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
		return "BoardTipFileVo [fileNo=" + fileNo + ", boardTipNo=" + boardTipNo + ", fileName=" + fileName
				+ ", mainYn=" + mainYn + "]";
	}
	
	
}
