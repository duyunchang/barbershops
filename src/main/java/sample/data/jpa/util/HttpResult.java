package sample.data.jpa.util;


public class HttpResult {
	
	private Integer statusCode;
	private String  entity;
	
	
	public HttpResult() {
		super();
	}
	public HttpResult(Integer statusCode, String entity) {
		super();
		this.statusCode = statusCode;
		this.entity = entity;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	@Override
	public String toString() {
		return "HttpResult [statusCode=" + statusCode + ", entitylength=" + entity.length() + "]";
	}
	
}
