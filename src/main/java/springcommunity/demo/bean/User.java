package springcommunity.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class User {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
       private long id;
	  
	  @Column(name="username", nullable=false)
       private String username;
	  
	  @Column(name="password", nullable=false)
       private String password;
       
       @ManyToOne
       @JoinColumn(name="roleid")
       private Role role;
       
	public User() {
		super();
	}
	public User(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
       
       
}
