package com.kh.app.board.event.vo;

import java.util.ArrayList;
import java.util.List;

public class EventVo {
	private String eventNo;
	private String writerNo;
	private String title;
	private String content;
	private String enrollDate;
	private String modifyDate;
	private String hit;
	private String delYn;
	private String startDate;
	private String endDate;
	
	private String fileNo;
	private String fileName;
	private String mainYn;
	
	private String writerId;
	private String writerNick;
	
	private List<EventFileVo> fileVoList = new ArrayList<EventFileVo>();
	private EventFileVo mainVo;
	public EventVo() {

	}
	public EventVo(String eventNo, String writerNo, String title, String content, String enrollDate, String modifyDate,
			String hit, String delYn, String startDate, String endDate, String fileNo, String fileName, String mainYn,
			String writerId, String writerNick, List<EventFileVo> fileVoList, EventFileVo mainVo) {
		super();
		this.eventNo = eventNo;
		this.writerNo = writerNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.hit = hit;
		this.delYn = delYn;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fileNo = fileNo;
		this.fileName = fileName;
		this.mainYn = mainYn;
		this.writerId = writerId;
		this.writerNick = writerNick;
		this.fileVoList = fileVoList;
		this.mainVo = mainVo;
	}
	public EventVo(String eventNo, String writerNo, String title, String content, String enrollDate, String modifyDate,
			String hit, String delYn, String startDate, String endDate, String fileNo, String fileName, String mainYn,
			String writerId, String writerNick) {
		super();
		this.eventNo = eventNo;
		this.writerNo = writerNo;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.hit = hit;
		this.delYn = delYn;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fileNo = fileNo;
		this.fileName = fileName;
		this.mainYn = mainYn;
		this.writerId = writerId;
		this.writerNick = writerNick;
	}
	public String getEventNo() {
		return eventNo;
	}
	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
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
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getWriterNick() {
		return writerNick;
	}
	public void setWriterNick(String writerNick) {
		this.writerNick = writerNick;
	}
	public List<EventFileVo> getFileVoList() {
		return fileVoList;
	}
	public void setFileVoList(List<EventFileVo> fileVoList) {
		this.fileVoList = fileVoList;
	}
	public EventFileVo getMainVo() {
		return mainVo;
	}
	public void setMainVo(EventFileVo mainVo) {
		this.mainVo = mainVo;
	}
	@Override
	public String toString() {
		return "EventVo [eventNo=" + eventNo + ", writerNo=" + writerNo + ", title=" + title + ", content=" + content
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", hit=" + hit + ", delYn=" + delYn
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", fileNo=" + fileNo + ", fileName=" + fileName
				+ ", mainYn=" + mainYn + ", writerId=" + writerId + ", writerNick=" + writerNick + ", fileVoList="
				+ fileVoList + ", mainVo=" + mainVo + "]";
	}
	
	
	
		
	
	
}
