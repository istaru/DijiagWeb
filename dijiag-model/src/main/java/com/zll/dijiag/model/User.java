package com.zll.dijiag.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Moon
 * @since 2018-03-01
 */
@TableName("dg_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户名
     */
	@TableField("user_name")
	private String userName;
    /**
     * 密码
     */
	@TableField("user_pwd")
	private String userPwd;
    /**
     * 手机号码
     */
	private String phone;
    /**
     * 分享token(唯一)
     */
	@TableField("share_token")
	private String shareToken;
    /**
     * 位置信息
     */
	private String address;
    /**
     * 手机的唯一标识
     */
	private String imei;
    /**
     * 用户类型 0表示普通用户
     */
	private Integer role;
    /**
     * 客户端类型 1表示android，2表示iOS
     */
	private String type;
    /**
     * 余额
     */
	private BigDecimal mony;
    /**
     * 可用余额
     */
	@TableField("do_mony")
	private BigDecimal doMony;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getShareToken() {
		return shareToken;
	}

	public void setShareToken(String shareToken) {
		this.shareToken = shareToken;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getMony() {
		return mony;
	}

	public void setMony(BigDecimal mony) {
		this.mony = mony;
	}

	public BigDecimal getDoMony() {
		return doMony;
	}

	public void setDoMony(BigDecimal doMony) {
		this.doMony = doMony;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", userName=" + userName +
			", userPwd=" + userPwd +
			", phone=" + phone +
			", shareToken=" + shareToken +
			", address=" + address +
			", imei=" + imei +
			", role=" + role +
			", type=" + type +
			", mony=" + mony +
			", doMony=" + doMony +
			"}";
	}
}
