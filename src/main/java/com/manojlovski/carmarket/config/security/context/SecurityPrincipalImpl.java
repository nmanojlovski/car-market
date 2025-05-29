package com.manojlovski.carmarket.config.security.context;

import com.manojlovski.carmarket.config.security.user.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityPrincipalImpl implements SecurityContext{

    @Override
    public Principal getPrincipal() {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new Principal(
                userDetails.getAccountId(),
                userDetails.getEmail(),
                userDetails.getUsername(),
                userDetails.getCustomerId()
        );
    }

}
