package com.pm.payments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(ServletInitializer.class.getSimpleName());

	public ServletInitializer() {
		LOGGER.info("\uD83E\uDDE9 \uD83E\uDDE9 \uD83E\uDDE9 \uD83E\uDDE9 ServletInitializer constructor");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		LOGGER.info("\uD83E\uDD66 ServletInitializer: \uD83E\uDD66 SpringApplicationBuilder: \uD83E\uDD66 configure web applications");
		return application.sources(PaymentsApplication.class);
	}

}
