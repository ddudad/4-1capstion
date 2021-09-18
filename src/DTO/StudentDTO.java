package DTO;

public class StudentDTO {
	String stdName;
	String pwd;
	String stdNum;
	String className;
	String stdCode;
	
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getPwd() {
		return pwd;
	}
	public String getStdCode() {
		return stdCode;
	}
	public void setStdCode(String cookieValue) {
		this.stdCode = cookieValue;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getStdNum() {
		return stdNum;
	}
	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
}