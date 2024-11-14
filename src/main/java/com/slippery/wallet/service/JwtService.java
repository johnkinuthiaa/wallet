package com.slippery.wallet.service;

import com.slippery.wallet.dto.UserDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    private final String SECRETKEY ="fc31ef6b221143e8468cf9a4051c52fe032c50dfa1e67f5dd1d7508396c61300e8f24cacf66c8819a0e464e08d2300aba721cc5535dd7affe77ab3a49b18c6b33d5473a4e5b57d2159aee966e4b246ae5c836958bcc220627aa4ed2fe9995e7cd1cf75dd19f65d15a9444a9d37b856c168dd7934c37af64cc1bd66135e9879d55e354e6de47c63f5d4ca2573b4a2c511a031c237658c1dc764316b7e5dd789e51ba7f8fd20a2467bb1ea542a6c73885acdfdb04ef5b2b4a4a1ab653658fdc5c0c68a171e6061851af37b9ce5a7243b6e9985be62fc99628ff8a468a2cf31493d6fcc53d1d16874e630ff0cbe6ac6f35e65765339a7012c77d5507cc109a85a65";
    private final Long EXPIRATIONTIME =86400000L;

    protected SecretKey generateSecretKey(){
        byte[] keyBytes = Base64.getDecoder().decode(SECRETKEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public UserDto generateJwtToken(String username){
        Map<String,Object> claims =new HashMap<>();
        UserDto response =new UserDto();
        var token = Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
                .and()
                .signWith(generateSecretKey())
                .compact();
        response.setJwtToken(token);
        response.setStatusCode(200);
        return response;
    }
}
