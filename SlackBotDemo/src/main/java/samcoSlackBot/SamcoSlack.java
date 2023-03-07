package samcoSlackBot;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

@Component
public class SamcoSlack {

	private static SamcoSlack instance;
	private WebhookResponse webhookResp;
	private SamcoPayload samcoPayload;
	private SlackConfig slackConfig;

	public SamcoSlack() {
		super();
	}

	public SamcoSlack(SlackConfig slackConfig, SamcoPayload samcoPayload) {
		super();
		this.samcoPayload = samcoPayload;
		this.slackConfig = slackConfig;
	}

	public WebhookResponse getwebhookResp() {
		return webhookResp;
	}

	public SamcoSlack getInstance(SlackConfig slackConfig, SamcoPayload samcoPayload) throws SQLException {
		if (instance == null) {
			instance = new SamcoSlack(slackConfig, samcoPayload);
		}
		return instance;
	}

	private WebhookResponse samcoSlack(SamcoPayload samcoPayload, SlackConfig slackConfig)
			throws SQLException, IOException {
		Payload payLoad = Payload.builder().channel(samcoPayload.getChannel()).username(samcoPayload.getUsername())
				.iconEmoji(":smile:").text(samcoPayload.getText()).build();
		webhookResp = Slack.getInstance().send(slackConfig.getWebHook(), payLoad);
		return webhookResp;
	}

	public boolean sendMessageToSlack(SlackConfig slackConfig, SamcoPayload samcoPayload)
			throws SQLException, IOException {
		WebhookResponse samcoSlack = samcoSlack(samcoPayload, slackConfig);
		if (samcoSlack.getCode() == 200) {
			return true;
		} else {
			return false;
		}
	}
}
