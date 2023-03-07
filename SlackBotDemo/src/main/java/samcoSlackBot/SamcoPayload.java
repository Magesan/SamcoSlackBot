package samcoSlackBot;

import org.springframework.stereotype.Component;

@Component
public class SamcoPayload {

	private String channel;
	private String username;
	private String text;
	private String config;

	public SamcoPayload() {
		super();
	}

	public SamcoPayload(String channel, String username, String text, String config) {
		super();
		this.channel = channel;
		this.username = username;
		this.text = text;
		this.config = config;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(SlackConfig config) {
		this.config = config.getWebHook();
	}

	@Override
	public String toString() {
		return "SamcoPayload [channel=" + channel + ", username=" + username + ", text=" + text + ", config=" + config
				+ "]";
	}

}
