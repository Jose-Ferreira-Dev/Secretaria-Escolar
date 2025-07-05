package com.sge.security.filters;

import com.sge.security.auth.CustomUserDetails;
import com.sge.security.auth.CustomUserDetailsService;
import com.sge.security.auth.LoginAttemptService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import java.util.Date;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final LoginAttemptService loginAttemptService = null;
    private final String secret;
    private final long expiration;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager,
                                 CustomUserDetailsService userDetailsService,
                                 String secret,
                                 long expiration) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.secret = secret;
        this.expiration = expiration;
        setFilterProcessesUrl("/api/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                              HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
        
        UsernamePasswordAuthenticationToken authenticationToken = 
            new UsernamePasswordAuthenticationToken(username, password);
        
        return authenticationManager.authenticate(authenticationToken);
    
        } catch (AuthenticationException e) {
            loginAttemptService.loginFailed(request.getParameter("username"));
            throw e;
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                           HttpServletResponse response,
                                           FilterChain chain,
                                           Authentication authResult) {
    
        loginAttemptService.loginSucceeded(((CustomUserDetails)authResult.getPrincipal()).getUsername());
        
        CustomUserDetails userDetails = (CustomUserDetails) authResult.getPrincipal();
        
        String token = Jwts.builder()
            .setSubject(userDetails.getUsername())
            .claim("role", userDetails.getRole())
            .claim("userId", userDetails.getUserId())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
        
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
    }
}