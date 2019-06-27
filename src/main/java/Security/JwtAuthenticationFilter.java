package Security;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Get authorization header
        final String tokenHeader = request.getHeader("Authorization");

        // temp objects for user & jwtToken
        String username = null;
        String jwtToken = null;

        // Check the token
        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            jwtToken = tokenHeader.substring(7);

            try {
                // Try to get username from token
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);

                // if we cant get the token throw illegalArgumentException
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token");

                // If token is expired throw ExpiredJwtException
            } catch (ExpiredJwtException e) {
                System.out.println("JWT Token is expired");
            }
        } // NO JWT TOKEN

        // Validate the token when retrieved
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // Create user details object from username
            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

            // If token is valid then authenticate it
            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

                // Create a token from username
                UsernamePasswordAuthenticationToken userPassToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // Build authentication
                userPassToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Allow user to pass
                SecurityContextHolder.getContext().setAuthentication(userPassToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
