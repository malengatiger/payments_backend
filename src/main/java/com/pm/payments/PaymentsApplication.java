package com.pm.payments;

import com.pm.payments.util.Emoji;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class PaymentsApplication  implements ApplicationListener<ApplicationReadyEvent> {
	public static final Logger LOGGER = LoggerFactory.getLogger(PaymentsApplication.class.getSimpleName());
//	private static final Gson G = new GsonBuilder().setPrettyPrinting().create();
	public static void main(String[] args) {

		LOGGER.info("\uD83D\uDE39  \uD83D\uDE39  \uD83D\uDE39 Payments application api starting ....");


		SpringApplication app = new SpringApplication(PaymentsApplication.class);
		app.setLogStartupInfo(true);
		app.setBanner(new Banner() {
			@Override
			public void printBanner (Environment environment,
									 Class<?> sourceClass,
									 PrintStream out) {
				out.println(getBanner());
			}
		});

		app.run(args);
		LOGGER.info(Emoji.PANDA.concat(Emoji.PANDA).concat(Emoji.PANDA) +
				" PaymentsApplication started OK! ".concat(Emoji.HAND2.concat(Emoji.HAND2))
				+ " All services up and running.");
		LOGGER.info("\uD83D\uDE0E \uD83D\uDE0E \uD83D\uDE0E Payments application started OK ....");
	}

	private static String getBanner() {
		StringBuilder sb = new StringBuilder();
		sb.append("#################################################\n");
		sb.append("#### "+ Emoji.HEART_BLUE+"NETWORK PAYMENT SERVICES "+Emoji.HEART_BLUE+"          ####\n");
		sb.append("#### ".concat(Emoji.FLOWER_RED).concat(Emoji.FLOWER_RED.concat(Emoji.FLOWER_RED)
				.concat(Emoji.FLOWER_RED.concat(Emoji.FLOWER_RED))).concat("                          ####\n"));
		sb.append("#################################################\n");
		return sb.toString();
	}
	@Override
	public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
		LOGGER.info("onApplicationEvent fired. \uD83D\uDC39 \uD83D\uDC30 \uD83E\uDD8A We could do some shit here ... ");
	}
}
