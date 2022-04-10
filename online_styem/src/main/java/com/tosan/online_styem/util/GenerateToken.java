package com.tosan.online_styem.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Random;

@Component
public class GenerateToken {

    public String[] createJWT(String id, String issuer, String subject, String role, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        Random random = new Random();
        String secretKey = id + random.nextInt(1000);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);

        Key signingKey = null;
        try {

            signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        } catch (Exception e) {
            System.out.println("Exception while generating key " + e.getMessage());
        }

        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                /*.setPayload(role)*/
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        return new String[]{builder.compact(), secretKey};

    }

}
