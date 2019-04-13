package om.tmobile.finance.bankperkeligibility.util;

public enum MessageCode
{
	PROCESSING_FAILED ("MESSAGE_400","Authorization Token Failed","Authorization Token Failed")

		;

	private String statusCode;
	private String userMessage;
	private String systemMessage;


	MessageCode(final String sc, final String um, final String sm) {
		this.statusCode =sc;
		this.userMessage = um;
		this.systemMessage = sm;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getSystemMessage() {
		return systemMessage;
	}

	public void setSystemMessage(String systemMessage) {
		this.systemMessage = systemMessage;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[").append("statusCode: ").append(statusCode)
				.append("userMessage: ").append(userMessage)
				.append("systemMessage: ").append(systemMessage)
				.append("]");
		return sb.toString();
	}
}
