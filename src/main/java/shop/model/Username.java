package shop.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Pattern;

public class Username {
	private long id;
	@Pattern(regexp = "^[a-zA-Z0-9-_]{2,64}$", message = "用户名2~64位,仅限数字字母、连字符-、下划线_")
	private String username;
	@Pattern(regexp = "^[a-zA-Z0-9.]{6,64}$", message = "密码6-64位,仅限数字字母、英文标点")
	private String password;
	private Date date;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDateFormat() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		return sf.format(date);
	}
}
