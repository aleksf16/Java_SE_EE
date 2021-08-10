package com.example.api1.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingControler {

    Logger logger = LoggerFactory.getLogger(LoggingControler.class);

    @RequestMapping("/")
    public void index(){

        logger.trace("A TRACE message");
        logger.debug("A DEBUG message");
        logger.info("An INFO message");
        logger.warn("A WARN message");
        logger.error("An ERROR message");

    }
}
