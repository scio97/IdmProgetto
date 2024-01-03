package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DatiLogin {

	@Id
	private String userName;

	private String password;
	private String ruolo;

	public DatiLogin() {}

	public DatiLogin(String userName, String password, String ruolo) {
		this.userName = userName.toLowerCase();
		this.password = password;
		this.ruolo = ruolo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

}
