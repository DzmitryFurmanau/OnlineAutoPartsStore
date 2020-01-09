package com.onlineAutoPartsStore.app.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlineAutoPartsStore.app.dto.response.ErrorResponseDto;
import com.onlineAutoPartsStore.app.service.security.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * The type Authentication token filter.
 */
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION = "Authorization";

    private static final String BEARER = "Bearer ";

    private TokenService tokenService;

    private UserDetailsService userDetailsService;

    /**
     * Instantiates a new Authentication token filter.
     *
     * @param tokenService       the token service
     * @param userDetailsService the user details service
     */
    public AuthenticationTokenFilter(TokenService tokenService, UserDetailsService userDetailsService) {
        this.tokenService = tokenService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, FilterChain chain) throws IOException {
        try {
            String token = getToken(httpRequest);
            if (token != null && tokenService.validate(token)) {
                String username = tokenService.extractUsername(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            chain.doFilter(httpRequest, httpServletResponse);
        } catch (Exception e) {
            ErrorResponseDto errorResponseDto = new ErrorResponseDto(BAD_REQUEST, e.getMessage());
            httpServletResponse.setStatus(errorResponseDto.getHttpStatus().value());
            httpServletResponse.setContentType("application/json");
            new ObjectMapper().writeValue(httpServletResponse.getWriter(), errorResponseDto);
        }
    }

    private String getToken(HttpServletRequest request) {
        String authHeader = request.getHeader(AUTHORIZATION);
        return authHeader != null && authHeader.startsWith(BEARER)
                ? authHeader.replace(BEARER, "") : authHeader;
    }
}