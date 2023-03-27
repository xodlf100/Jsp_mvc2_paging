package showM.Dto;

import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class BoardDto {
	
	private int idx;
	private String title;
	private String joinName;
	private String regdate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getJoinName() {
		return joinName;
	}
	public void setJoinName(String joinName) {
		this.joinName = joinName;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "BoardDto [idx=" + idx + ", title=" + title + ", joinName=" + joinName + ", regdate=" + regdate + "]";
	}
	
	
	
	
	
}
