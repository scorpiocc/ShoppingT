package com.xc.chat;


public class ChatEntity {
	private String code ;
	private String charge;
	private String msg;
	private String result;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public ChatEntity() {
		super();
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ChatEntity [code=" + code + ", charge=" + charge + ", msg="
				+ msg + ", result=" + result + "]";
	}
	
	
	
	
}
