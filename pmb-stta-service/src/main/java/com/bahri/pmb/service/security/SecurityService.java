package com.bahri.pmb.service.security;


import com.bahri.pmb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "securityService")
public class SecurityService implements UserDetailsService {
/*------------------------------ Fields ------------------------------*/

    @Autowired
    private UserService userService;

/* --------------------- Interface UserDetailsService --------------------- */


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException, DataAccessException {
        try {
            UserDetails o = userService.findUser(s);
            if (o != null) {
                return o;
            } else {
                throw new UsernameNotFoundException("User Not Found");
            }
        } catch (Exception x) {
            throw new UsernameNotFoundException(x.getMessage());
        }
    }
}
