package com.library.pojo;

import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

import com.library.controller.validation.LoginValidator;
import com.library.controller.validation.RegisterValidator;

@Alias("UserBean")
public class User implements PTResult {

	private String id;
	@Size(min = 8, max = 20, message = "{user.name.length}", groups = { LoginValidator.class })
	private String username;
	@Size(min = 9, max = 20, message = "密码长度9-20", groups = { LoginValidator.class, RegisterValidator.class })
	private String password;
	private Integer age;
	private String email;// 邮箱
	private Date birth;// 生日
	private String phone;// 手机号
	private String stuId;// 学号

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
		setAge(getAgeByBirthday(birth));
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	/**
	 * 根据用户生日计算年龄
	 */
	public static int getAgeByBirthday(Date birthday) {
		Calendar cal = Calendar.getInstance();

		if (cal.before(birthday)) {
			throw new IllegalArgumentException(
					"The birthDay is before Now.It's unbelievable!");
		}

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				age--;
			}
		}
		return age;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", email="
				+ email + ", birth=" + birth + ", phone=" + phone + ", stuId=" + stuId + "]";
	}

}
