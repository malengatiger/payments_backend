package com.pm.payments.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pm.payments.PaymentsApplication;
import com.pm.payments.data.OzowPaymentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;

@Service
public class HashCheckGenerator {
    public HashCheckGenerator() {
        LOGGER.info(Emoji.BASKET_BALL.concat(Emoji.BASKET_BALL.concat("HashCheckGenerator up and ready")));
    }

    /*
            Generate Post Hash Check
        Follow these steps to generate the hash check:
            1. Concatenate the post variables (excluding HashCheck and Token) in the order they appear in the post
            variables table.
            2. Append your private key to the concatenated string. Your private key can be found in merchant details
            section of the merchant admin site.
            3. Convert the concatenated string to lowercase.
            4. Generate a SHA512 hash of the lowercase concatenated string.
            Hash Check Example
            SiteCode: TSTSTE0001
            CountryCode: ZA
            CurrencyCode: ZAR
            Amount: 25.00
            TransactionReference: 123
            BankReference: ABC123
            CancelUrl: http://demo.ozow.com/cancel.aspx
            ErrorUrl: http://demo.ozow.com/error.aspx
            SuccessUrl: http://demo.ozow.com/success.aspx
            NotifyUrl: http://demo.ozow.com/notify.aspx
            IsTest: false
            1. TSTSTE0001ZAZAR25.00123ABC123http://demo.ozow.com/cancel.aspxhttp://demo.ozow.com/cancel.as
            pxhttp://demo.ozow.com/success.aspxhttp://demo.ozow.com/notify.aspxfalse
            2. TSTSTE0001ZAZAR25.00123ABC123http://demo.ozow.com/cancel.aspxhttp://demo.ozow.com/cancel.as
            pxhttp://demo.ozow.com/success.aspxhttp://demo.ozow.com/notify.aspxfalse215114531AFF7134A94C8
            8CEEA48E
            3. tstste0001zazar25.00123abc123http://demo.ozow.com/cancel.aspxhttp://demo.ozow.com/cancel.aspxht
            tp://demo.ozow.com/success.aspxhttp://demo.ozow.com/notify.aspxfalse215114531aff7134a94c88ceea
            48e
            4. eedcba106cd8fef3ba6cec5ec80de7d7d7fc90343028bf95b908718c671d0fe885ca08b206d788de009d237a
            93c18e66edf6ede3f5ca7057e23474106465dcc6
         */
    public static final Logger LOGGER = LoggerFactory.getLogger(PaymentsApplication.class.getSimpleName());
    private static final Gson G = new GsonBuilder().setPrettyPrinting().create();

    @Value("${privateKey")
    private String privateKey;

    public  String generateHash(OzowPaymentRequest request) throws Exception {

        StringBuilder sb = new StringBuilder();
        sb.append(request.getSiteCode());
        sb.append(request.getCountryCode());
        sb.append(request.getCurrencyCode());
        sb.append(request.getAmount());
        sb.append(request.getTransactionReference());
        sb.append(request.getBankReference());
        sb.append(request.getCancelUrl());
        sb.append(request.getErrorUrl());
        sb.append(request.getSuccessUrl());
        if (request.getOptional1() != null) {
            sb.append(request.getOptional1());
        }
        if (request.getOptional2() != null) {
            sb.append(request.getOptional2());
        }
        if (request.getOptional3() != null) {
            sb.append(request.getOptional3());
        }
        if (request.getOptional4() != null) {
            sb.append(request.getOptional4());
        }
        if (request.getOptional5() != null) {
            sb.append(request.getOptional5());
        }
        sb.append(request.isTest());
        sb.append(privateKey);

        //todo - add optional fields that are used .....

        LOGGER.info("HashString: ".concat(sb.toString()));
        //todo - make the hash here ...

        return sb.toString();
    }
}
