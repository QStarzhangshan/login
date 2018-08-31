package cn.zh.jdbc.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * @author ZH
 */
public class User implements Serializable{

	  private static final long serialVersionUID = 1L;
	  private int user_id;
	  private String user_work_number;
	  private String user_name;
	  private String user_password;
	  private String user_gender;
	  private Date user_birthday;
	  private String user_cellphone;
	  private String user_email;
	  private String user_officephone;
	  private String user_qq;
	  private String user_entrydate;
	  private String user_company;
	  private String user_department;
	  private String user_entry_time;
	  private String user_position;
	  private String user_authority;
	  private String validataCode;
	  private Date outDate;
	  private String openid;
	  
		public User() {
			
		}
		
		
		public User(int user_id, String user_work_number, String user_name) {
			super();
			this.user_id = user_id;
			this.user_work_number = user_work_number;
			this.user_name = user_name;
		}


		public User(int user_id, String user_work_number, String user_name, String user_password, String user_gender,
				Date user_birthday, String user_cellphone, String user_email, String user_officephone, String user_qq,
				String user_entrydate, String user_company, String user_department, String user_entry_time,
				String user_position, String user_authority, String validataCode, Date outDate, String openid) {
			super();
			this.user_id = user_id;
			this.user_work_number = user_work_number;
			this.user_name = user_name;
			this.user_password = user_password;
			this.user_gender = user_gender;
			this.user_birthday = user_birthday;
			this.user_cellphone = user_cellphone;
			this.user_email = user_email;
			this.user_officephone = user_officephone;
			this.user_qq = user_qq;
			this.user_entrydate = user_entrydate;
			this.user_company = user_company;
			this.user_department = user_department;
			this.user_entry_time = user_entry_time;
			this.user_position = user_position;
			this.user_authority = user_authority;
			this.validataCode = validataCode;
			this.outDate = outDate;
			this.openid = openid;
		}


		public User(String user_work_number, String user_name, String openid) {
			super();
			this.user_work_number = user_work_number;
			this.user_name = user_name;
			this.openid = openid;
		}


		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public String getUser_work_number() {
			return user_work_number;
		}
		public void setUser_work_number(String user_work_number) {
			this.user_work_number = user_work_number;
		}
		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public String getUser_password() {
			return user_password;
		}
		public void setUser_password(String user_password) {
			this.user_password = user_password;
		}
		public String getUser_gender() {
			return user_gender;
		}
		public void setUser_gender(String user_gender) {
			this.user_gender = user_gender;
		}
		public Date getUser_birthday() {
			return user_birthday;
		}
		public void setUser_birthday(Date user_birthday) {
			this.user_birthday = user_birthday;
		}
		public String getUser_cellphone() {
			return user_cellphone;
		}
		public void setUser_cellphone(String user_cellphone) {
			this.user_cellphone = user_cellphone;
		}
		public String getUser_email() {
			return user_email;
		}
		public void setUser_email(String user_email) {
			this.user_email = user_email;
		}
		public String getUser_officephone() {
			return user_officephone;
		}
		public void setUser_officephone(String user_officephone) {
			this.user_officephone = user_officephone;
		}
		public String getUser_qq() {
			return user_qq;
		}
		public void setUser_qq(String user_qq) {
			this.user_qq = user_qq;
		}
		public String getUser_entrydate() {
			return user_entrydate;
		}
		public void setUser_entrydate(String user_entrydate) {
			this.user_entrydate = user_entrydate;
		}
		public String getUser_authority() {
			return user_authority;
		}
		public void setUser_authority(String user_authority) {
			this.user_authority = user_authority;
		}
		public String getValidataCode() {
			return validataCode;
		}
		public void setValidataCode(String validataCode) {
			this.validataCode = validataCode;
		}
		public Date getOutDate() {
			return outDate;
		}
		public void setOutDate(Date outDate) {
			this.outDate = outDate;
		}
		public String getOpenid() {
			return openid;
		}
		public void setOpenid(String openid) {
			this.openid = openid;
		}

		public String getUser_company() {
			return user_company;
		}


		public void setUser_company(String user_company) {
			this.user_company = user_company;
		}


		public String getUser_department() {
			return user_department;
		}


		public void setUser_department(String user_department) {
			this.user_department = user_department;
		}


		public String getUser_entry_time() {
			return user_entry_time;
		}


		public void setUser_entry_time(String user_entry_time) {
			this.user_entry_time = user_entry_time;
		}


		public String getUser_position() {
			return user_position;
		}


		public void setUser_position(String user_position) {
			this.user_position = user_position;
		}


		@Override
		public String toString() {
			return "User [user_id=" + user_id + ", user_work_number=" + user_work_number + ", user_name=" + user_name
					+ ", user_password=" + user_password + ", user_gender=" + user_gender + ", user_birthday="
					+ user_birthday + ", user_cellphone=" + user_cellphone + ", user_email=" + user_email
					+ ", user_officephone=" + user_officephone + ", user_qq=" + user_qq + ", user_entrydate="
					+ user_entrydate + ", user_company=" + user_company + ", user_department=" + user_department
					+ ", user_entry_time=" + user_entry_time + ", user_position=" + user_position + ", user_authority="
					+ user_authority + ", validataCode=" + validataCode + ", outDate=" + outDate + ", openid=" + openid
					+ "]";
		}
		
}
