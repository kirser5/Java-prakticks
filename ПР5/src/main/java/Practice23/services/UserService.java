package Practice23.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import Practice23.output.SignUpRequest;
import Practice23.exceptions.UserAlreadyExistsException;
import Practice23.models.User;
import Practice23.models.UserPrincipal;
import Practice23.repositories.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void addNewUser(SignUpRequest request) throws UserAlreadyExistsException {
        String username = request.getUsername();
        if (userExists(username)) {
            throw new UserAlreadyExistsException(username);
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
    }

    @Transactional(Transactional.TxType.MANDATORY)
    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found: " + username)
                );
        return new UserPrincipal(user);
    }
}