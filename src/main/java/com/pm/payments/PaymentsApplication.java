package com.pm.payments;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pm.payments.util.Emoji;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import java.io.PrintStream;
import java.util.Calendar;

@SpringBootApplication
public class PaymentsApplication implements ApplicationListener<ApplicationReadyEvent> {



	public static final Logger LOGGER = LoggerFactory.getLogger(PaymentsApplication.class.getSimpleName());
	private static final Gson G = new GsonBuilder().setPrettyPrinting().create();
	public static void main(String[] args) {
		LOGGER.info(Emoji.PANDA.concat(Emoji.PANDA).concat(Emoji.PANDA) +
				" PaymentsApplication starting ...");
		SpringApplication app = new SpringApplication(PaymentsApplication.class);
		app.setLogStartupInfo(true);
		app.setBanner(new Banner() {
			@Override
			public void printBanner (Environment environment,
									 Class<?> sourceClass,
									 PrintStream out) {
				//LOGGER.info(G.toJson(environment.getActiveProfiles()));
				out.println(getBanner());
			}
		});

		app.run(args);
		LOGGER.info(Emoji.PANDA.concat(Emoji.PANDA).concat(Emoji.PANDA) +
				" PaymentsApplication started OK! ".concat(Emoji.HAND2.concat(Emoji.HAND2))
				+ " All services up and running.");
	}
	private static String getBanner() {
		StringBuilder sb = new StringBuilder();
		sb.append("################################################\n");
		sb.append("#### "+Emoji.HEART_BLUE+"PAYMENT SERVICES BACKEND "+Emoji.HEART_BLUE+"   ####\n");
		sb.append("#### ".concat(Emoji.FLOWER_RED).concat(" ").concat(new DateTime().toDateTimeISO().toString().concat("     ####\n")));
		sb.append("###############################################\n");
		return sb.toString();
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		LOGGER.info("\uD83C\uDF3C \uD83C\uDF3C onApplicationEvent: " +
				"ApplicationReadyEvent has been fired: \uD83C\uDF3C \uD83C\uDF3C app is ready to initialize whatever it needs .... ");

		Calendar cal = Calendar.getInstance();
		int res = cal.getActualMaximum(Calendar.DATE);
		LOGGER.info(Emoji.SKULL.concat(Emoji.SKULL) + "Today's Date = " + cal.getTime());
		LOGGER.info(Emoji.SKULL.concat(Emoji.SKULL) + "Last Date of the current month = " + res);

	}
}
