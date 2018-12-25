package com.anythy.demospringcloud;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.*;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@SpringBootApplication(scanBasePackages = {"com.anythy.demospringcloud", "com.anythy.base.spring.context"})
public class DemoSpringCloudApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        Algorithm algorithm = Algorithm.RSA256(publicKey, privateKey);

        String token = JWT.create()
                .withIssuer("ttttest")
                .sign(algorithm);
        System.out.println(token);

        String token1 = JWT.create()
                .withClaim("name", "data")
                .withIssuer("ttttest")
                .sign(algorithm);
        System.out.println(token1);

        String tok = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ0dHR0ZXN0In0.Yq4dcfyAp0J9rftj0eZ2s73jl0g6MEK8avWAYwDOtf6r665pS5IOHFHcjj_OrUK8q8hbxU6VedZq0g2mFvz70hWibrOrNqt2mkmQZsAemhiQ_qH-uawCjgdrfk_bW_-GS6AWyhm_NaEedP0D1f-U8d0eML-50ql29cpPPnbV6xI";
        DecodedJWT decodedJWT = JWT.decode(tok);
        System.out.println(decodedJWT.getHeader());
        System.out.println(decodedJWT.getPayload());
        System.out.println(decodedJWT.getSignature());
        System.out.println(decodedJWT.getToken());

//        SpringApplication.run(DemoSpringCloudApplication.class, args);
    }
}
