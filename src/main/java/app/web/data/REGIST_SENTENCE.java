package app.web.data;

public enum REGIST_SENTENCE {

	ASK_FOR_ADDRESS("address"), ASK_FOR_NAME("userName"), ASK_FOR_PASSWORD("password");

	private String type;

	REGIST_SENTENCE(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
