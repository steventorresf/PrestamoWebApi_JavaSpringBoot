package com.prestamofacilweb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @PostMapping(value = "/login/userLogin", produces = "application/json")
    public ResponseEntity<String> UserLogin() {
        return new ResponseEntity<String>("Todo ok", HttpStatus.OK);
        // String secretKey = "mySecretKey";
        // List<GrantedAuthority> grantedAuthorities = AuthorityUtils
        //         .commaSeparatedStringToAuthorityList("ROLE_USER");

        // String token = Jwts
        //         .builder()
        //         .setId("softtekJWT")
        //         .setSubject("claudia9")
        //         .claim("authorities",
        //                 grantedAuthorities.stream()
        //                         .map(GrantedAuthority::getAuthority)
        //                         .collect(Collectors.toList()))
        //         .setIssuedAt(new Date(System.currentTimeMillis()))
        //         .setExpiration(new Date(System.currentTimeMillis() + 600000))
        //         .signWith(SignatureAlgorithm.HS512,
        //                 secretKey.getBytes())
        //         .compact();

        // return "Bearer " + token;
    }

}
