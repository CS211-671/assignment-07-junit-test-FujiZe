package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user2;
    @BeforeEach
    void init(){
        user2 = new User("user02", "P@ssword");
    }
    @Test
    @DisplayName("Password should not store in plain text")
    public void testPasswordIsNotStoreInPlainText() {
        User user = new User("user01", "plain-p@ssw0rd");
        String actual = user.getPassword();
        String unexpected = "plain-p@ssw0rd";
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Password should be verified by plain text")
    public void testPasswordShouldBeVerified() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.validatePassword("plain-p@ssw0rd");
        assertTrue(actual);
    }

    @Test
    public void TestSetPassword(){
        user2.setPassword("30000");
        assertEquals(true,user2.validatePassword("30000"));
    }
    @Test
    public void TestValidatePassword(){
       assertEquals(true,user2.validatePassword("P@ssword"));
    }
    @Test
    public void TestIsUsername(){
        assertEquals(true,user2.isUsername("user02"));
    }
}