import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserManagerTest {
    @Mock
    private Q2UserService userService;

    @InjectMocks
    private UserManager userManager;

    @Test
    void testRegisterUserReturnsFalseWhenUsernameExists() {
        String username = "rana";
        String password = "password";
        when(userService.usernameExists(username)).thenReturn(true);
        assertFalse(userManager.registerUser(username, password));
        verify(userService).usernameExists(username);
    }

    @Test
    void testRegisterUserReturnsTrueWhenUsernameDoesNotExist() {
        String username = "rana";
        String password = "password";
        when(userService.usernameExists(username)).thenReturn(false);
        when(userService.saveUser(username, password)).thenReturn(true);
        assertTrue(userManager.registerUser(username, password));
        verify(userService).usernameExists(username);
        verify(userService).saveUser(username, password);
    }
}