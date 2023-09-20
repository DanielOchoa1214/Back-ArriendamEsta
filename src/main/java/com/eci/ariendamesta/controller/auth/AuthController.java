package com.eci.ariendamesta.controller.auth;

import com.eci.ariendamesta.exceptions.AppExceptions;
import com.eci.ariendamesta.model.User;
import com.eci.ariendamesta.service.LandlordServiceInterface;
import com.eci.ariendamesta.service.TenantServiceInterface;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;


@RestController
@RequestMapping( "v1/auth" )
public class AuthController
{

    public static final String CLAIMS_ROLES_KEY = "ROL";
    private static final int TOKEN_DURATION_MINUTES = 10;
    @Value( "${app.secret}" )
    String secret;

    private final LandlordServiceInterface landlordServices;

    private final TenantServiceInterface tenantServices;

    public AuthController(@Autowired LandlordServiceInterface landlordServices,
                          @Autowired TenantServiceInterface tenantServices) {
        this.landlordServices = landlordServices;
        this.tenantServices = tenantServices;
    }

    @PostMapping("/landlord")
    public TokenDto loginLandlord( @RequestBody LoginDto loginDto) throws AppExceptions {
        User user = landlordServices.findByEmail(loginDto.email);
        if ( BCrypt.checkpw( loginDto.password, user.getPassword() ) )
        {
            return generateTokenDto( user );
        }
        throw new AppExceptions("Por el momento");
    }

    @PostMapping("/tenant")
    public TokenDto loginTenant( @RequestBody LoginDto loginDto ) throws AppExceptions {
        User user = tenantServices.findByEmail( loginDto.email );
        if ( BCrypt.checkpw( loginDto.password, user.getPassword() ) )
        {
            return generateTokenDto( user );
        }
        throw new AppExceptions("Por el momento");
    }

    private String generateToken( User user, Date expirationDate )
    {
        return Jwts.builder()
                .setSubject( user.getId() )
                .claim( CLAIMS_ROLES_KEY, user.getRoles() )
                .setIssuedAt(new Date() )
                .setExpiration( expirationDate )
                .signWith( SignatureAlgorithm.HS256, secret )
                .compact();
    }

    private TokenDto generateTokenDto( User user )
    {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add( Calendar.MINUTE, TOKEN_DURATION_MINUTES );
        String token = generateToken( user, expirationDate.getTime() );
        return new TokenDto( token, expirationDate.getTime() );
    }
}