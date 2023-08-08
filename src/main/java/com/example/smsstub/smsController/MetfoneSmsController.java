package com.example.smsstub.smsController;

import com.example.smsstub.generic.GenericRequest;
import com.example.smsstub.pojo.MetfoneData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@JsonIgnoreProperties
public class MetfoneSmsController {

    private static final Logger log = LogManager.getLogger(MetfoneSmsController.class);
    @PostMapping("/apigw")
    @JsonIgnore
    public ResponseEntity<MetfoneData> sendSms(@RequestBody String xmlRequest, @RequestParam(name="wsdl") final String wsdl,
                                               final HttpServletRequest request) {
        log.info("Http request received from IP: " + request.getRemoteAddr() + "in metfone sms.");
        String responseData = processXmlRequest(xmlRequest);
        log.info(responseData);
        MetfoneData metfoneData = new MetfoneData(0, "Successfully");
        return new ResponseEntity<>(metfoneData, HttpStatus.OK);

    }


    private String processXmlRequest(String xmlRequest) {
        // Use Jackson XML to unmarshal the XML request to a GenericRequest object
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            GenericRequest<?> genericRequest = xmlMapper.readValue(xmlRequest, GenericRequest.class);

            // Perform your business logic here...
            log.info(genericRequest);
            // For this example, we'll just return the request data as a response
            Object requestData = genericRequest.getData();
            return xmlMapper.writeValueAsString(requestData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
