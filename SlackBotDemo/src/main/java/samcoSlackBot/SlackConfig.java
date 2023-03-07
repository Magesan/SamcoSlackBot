package samcoSlackBot;

import org.springframework.stereotype.Component;

@Component
public class SlackConfig {

	private String webHook;

	public SlackConfig() {
		super();
	}

	public SlackConfig(String webHook) {
		super();
		this.webHook = webHook;
	}

	public String getWebHook() {
		return webHook;
	}

	public String setWebHook(String webHook) {
		return this.webHook = webHook;
	}

	@Override
	public String toString() {
		return "SlackConfig [webHook=" + webHook + "]";
	}

}
