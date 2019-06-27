package Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class Authenticator {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    public Authenticator() {

    }


    public JwtToken authenticate(String username, String password) {

        // Try to authenticate with username and password
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            System.out.println("USER_DISABLED");
        } catch (BadCredentialsException e) {
            System.out.println("INVALID_CREDENTIALS");
        }

        //Get user details object
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // Generate token
        String token = jwtTokenUtil.generateToken(userDetails);

        // Return generated token from username
        return new JwtToken(token, jwtTokenUtil.getExpirationDate(token));
    }
}
