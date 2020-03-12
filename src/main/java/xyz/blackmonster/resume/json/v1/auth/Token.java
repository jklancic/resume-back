package xyz.blackmonster.resume.json.v1.auth;

public class Token {
	
	private String jwt;

	public Token() {

	}

	public Token(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
}