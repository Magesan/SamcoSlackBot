package samcoSlackBot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SlackBotApplication implements CommandLineRunner{
	@Autowired
	private SamcoSlack samcoSlack;
	
	public static void main(String[] args) {
		SpringApplication.run(SlackBotApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SlackConfig sConfig = new SlackConfig();
		sConfig.setWebHook("https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXX");
		
		SamcoPayload sPayload = new SamcoPayload();
		sPayload.setChannel("#app-alerts");
		sPayload.setUsername("Msg Bot");
		sPayload.setText("This is a demo slack bot message");
		
		SamcoSlack instance = samcoSlack.getInstance(sConfig, sPayload);
		boolean sendMessageToSlack = instance.sendMessageToSlack(sConfig, sPayload);
		System.out.println(sendMessageToSlack);
	}
}
