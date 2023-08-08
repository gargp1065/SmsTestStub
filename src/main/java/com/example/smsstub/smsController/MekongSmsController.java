package com.example.smsstub.smsController;

import com.example.smsstub.pojo.TokenData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MekongSmsController {

    private static final Logger log = LogManager.getLogger(MekongSmsController.class);

    @PostMapping("/token")
    public ResponseEntity<TokenData> getToken(@RequestBody String requestBody) {
        TokenData tokenData = new TokenData();
        tokenData.setAccess_token("d90233d2-09f3-36ad-986d-f5ae0e015d01");
        tokenData.setToken_type("Bearer");
        tokenData.setScope("am_application_scope default");
        tokenData.setExpiry_in("3600");

        return new ResponseEntity<>(tokenData, HttpStatus.OK);
    }

    @GetMapping("/api/sendsms.aspx")
    public ResponseEntity<String> sendSms(@RequestParam("username") final String userName, @RequestParam("pass") final String password,
                                  @RequestParam(name="cd", required = false) final String customData, @RequestParam("sender") final String sender,
                                  @RequestParam("smstext") final String smsText, @RequestParam("gsm") final String gsm,
                                  @RequestParam(name = "int" , required = false) final String flag, final HttpServletRequest request) {

        log.info("Http request received from IP: " + request.getRemoteAddr() + "in mekong sms");
        return ResponseEntity.ok("0");
    }
}
