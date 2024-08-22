package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {
    UserList user;
    @BeforeEach
    void init(){
        user = new UserList();
    }
    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        user.addUser("kong","1234");
        user.addUser("Song","1234");
        user.addUser("Gonn","1234");
        // TODO: find one of them
        User u = user.findUserByUsername("Song");
        // TODO: assert that UserList found User
        // String expected = "<one of username>";
        // String actual = user.getUsername();
        // assertEquals(expected, actual);
        assertEquals("Song",u.getUsername());
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        user.addUser("kong","1234");
        user.addUser("Song","1234");
        user.addUser("Gonn","1234");
        // TODO: change password of one user
        user.changePassword("Song","1234","abcd");
        // TODO: assert that user can change password
        // assertTrue(actual);
        assertEquals(true,user.findUserByUsername("Song").validatePassword("abcd"));
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        user.addUser("kong","1234");
        user.addUser("Song","1234");
        user.addUser("Gonn","1234");
        // TODO: call login() with correct username and password
        User u = user.login("kong","1234");
        // TODO: assert that User object is found

        // assertEquals(expected, actual);
        assertEquals(user.findUserByUsername("kong"),u);
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        user.addUser("kong","1234");
        user.addUser("Song","1234");
        user.addUser("Gonn","1234");
        // TODO: call login() with incorrect username or incorrect password
        User u = user.login("kong","334");
        // TODO: assert that the method return null
        // assertNull(actual);
        assertNull(u);
    }

}