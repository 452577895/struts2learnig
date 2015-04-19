package struts2CURD;

import java.io.Serializable;

public class User implements Serializable {
	
	
	private String userId;
	private String username;
	private String password;
	private int age;
	private String sex;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public int getAge() {
		return age;
	}
	public void setAge( int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public User(String userId,String username, String password, int age, String sex) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.age = age;
		this.sex = sex;
	}
	public User() {
		super();
	}
	
}
