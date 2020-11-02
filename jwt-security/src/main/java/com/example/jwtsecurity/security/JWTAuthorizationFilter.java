package com.example.jwtsecurity.security;

import com.example.jwtsecurity.utils.JWTSecurityUtil;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String requestHeader = request.getHeader(JWTSecurityUtil.HEADER);

        if (requestHeader == null || requestHeader.startsWith(JWTSecurityUtil.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken passwordAuthenticationToken = getAuthToken(request);
        SecurityContextHolder.getContext().setAuthentication(passwordAuthenticationToken);
        chain.doFilter(request, response);


    }

    private UsernamePasswordAuthenticationToken getAuthToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(JWTSecurityUtil.HEADER);

        if (jwtToken != null) {
            String userAuth = Jwts.parser()
                    .setSigningKey(JWTSecurityUtil.SECRET.getBytes())
                    .parseClaimsJws(jwtToken.replace(JWTSecurityUtil.TOKEN_PREFIX, ""))
                    .getBody().getSubject();

            if (userAuth != null)
                return new UsernamePasswordAuthenticationToken(userAuth, null, new ArrayList<>());
        } else {
            return null;
        }
        return null;
    }
}
