import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;


    @Test
    void testFindUserByIdReturnUserObject(){
        User user = new User();
        when(userRepository.findById(1)).thenReturn(user);
        assertEquals(user, userService.findUserById(1));
    }

    @Test
    void testFindUserByIdReturnNull(){
        when(userRepository.findById(2)).thenReturn(null);
        assertNull(userService.findUserById(2));
    }

    @Test
    void verifyInteractionsBetweenUserServiceAndUserRepository(){
        when(userRepository.findById(1)).thenReturn(new User());
        userService.findUserById(1);
        verify(userRepository).findById(1);
    }

}