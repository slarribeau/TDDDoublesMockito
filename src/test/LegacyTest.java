package test;
import main.IDGenerator;
import main.UserService;
import org.mockito.Mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;


import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({IDGenerator.class, UserService.class})
public class LegacyTest {
    private UserService userService;

    @Before
    public void createUserService() {
        mockStatic(IDGenerator.class);
        userService = new UserService();
    }



    @Test
    public void testLegacyCodeWithTwoAdds() {
        Long id;

        id = 77l;
        when(IDGenerator.generateUniqueId()).thenReturn(id);
        userService.createUser("bob");
        assertEquals("bob", userService.getUsername(id));

        id = 99l;
        when(IDGenerator.generateUniqueId()).thenReturn(id);
        userService.createUser("bobby");
        assertEquals("bobby", userService.getUsername(id));
        verify(IDGenerator.class);
    }
}