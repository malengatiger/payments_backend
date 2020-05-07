package com.pm.payments.testing;

import com.pm.payments.ServletInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TestController {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestController.class.getSimpleName());

    @GetMapping(value = "/ping", produces = MediaType.TEXT_PLAIN_VALUE)
    public String ping() {
        String msg =
       "\uD83C\uDF38\uD83C\uDF38\uD83C\uDF38\uD83C\uDF38 TestController: test ping Pinged :  \uD83C\uDF50  \uD83C\uDF50  ";

        LOGGER.info(msg);
        return msg;
    }
}
