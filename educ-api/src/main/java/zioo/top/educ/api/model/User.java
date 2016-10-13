package zioo.top.educ.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name="wm_user")
@JsonInclude(Include.NON_EMPTY)
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6456755665113863578L;
	@Id
	@GenericGenerator(strategy="uuid", name="system-uuid")
	@GeneratedValue(generator="system-uuid")
	private String id;
	@NotBlank(message="username is required")
	@Column(nullable = false, unique = true)
	private String username;
	@NotBlank(message="password is required")
	@Column(nullable = false)
	private String password;
	@Email(message="must be email")
	@Column(nullable = false, unique = true)
	private String email;
	private String nickname;
	@Column(nullable = false)
	private boolean emailIsVaild;
	private Date createTime;
	private Date lastLoginTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public boolean isEmailIsVaild() {
		return emailIsVaild;
	}
	public void setEmailIsVaild(boolean emailIsVaild) {
		this.emailIsVaild = emailIsVaild;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
