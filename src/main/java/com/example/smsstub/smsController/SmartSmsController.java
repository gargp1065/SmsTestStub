package com.example.smsstub.smsController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/smsmessaging/v1/")
public class SmartSmsController {

    private static final Logger log = LogManager.getLogger(SmartSmsController.class);
    @PostMapping("outbound/{senderAddress}/requests")
    public ResponseEntity sendSms(@PathVariable("senderAddress") final String senderAddress, final HttpServletRequest request){
        log.info("Http request received from IP: " + request.getRemoteAddr() + "in smart sms");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
