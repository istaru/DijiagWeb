package com.zll.dijiag.model;

import java.util.Date;
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
@TableName("dg_sms")
public class Sms extends Model<Sms> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	private String id;
    /**
     * 短信发送类型(1:注册短信验证码)
     */
	private String type;
    /**
     * 发送时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 手机号码
     */
	private String phone;
    /**
     * 短信验证码
     */
	private String code;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Sms{" +
			"id=" + id +
			", type=" + type +
			", createTime=" + createTime +
			", phone=" + phone +
			", code=" + code +
			"}";
	}
}
