package com.xc.ssm.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 帐号实体类

 */
@Component
public class Vip implements Serializable{
   

	/**
	 * 
	 */
	private static final long serialVersionUID = 5689388872755151250L;

	private String username;

    private String userpass;

    private String phone;

    private String address;

    private String realname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass == null ? null : userpass.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

	@Override
	public String toString() {
		return "Vip [username=" + username + ", userpass=" + userpass
				+ ", phone=" + phone + ", address=" + address + ", realname="
				+ realname + "]";
	}
}