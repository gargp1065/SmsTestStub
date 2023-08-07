package com.example.smsstub.smsController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MekongSmsController {

    private static final Logger log = LogManager.getLogger(MekongSmsController.class);
    @GetMapping("/api/sendsms.aspx")
    public ResponseEntity<String> sendSms(@RequestParam("username") final String userName, @RequestParam("pass") final String password,
                                  @RequestParam("cd") final String customData, @RequestParam("sender") final String sender,
                                  @RequestParam("smstext") final String smsText, @RequestParam("gsm") final String gsm,
                                  @RequestParam("int") final String flag, final HttpServletRequest request) {

        log.info("Http request received from IP: " + request.getRemoteAddr() + "in mekong sms");
        return ResponseEntity.ok("0");
    }
}
