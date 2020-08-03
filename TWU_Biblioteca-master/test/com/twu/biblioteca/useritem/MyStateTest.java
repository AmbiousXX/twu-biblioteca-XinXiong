package com.twu.biblioteca.useritem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStateTest {
    private MyState myState;

    @Before
    public void setUp() {
        myState = new MyState();
    }

    @Test
    public void testSetIsUser() {
        assertEquals(false, myState.getIsUser());
        myState.setIsUser(true, new User("0wm-9232", "kdf1h04h@@ksw", "wm", "wm9232@xyy.com", "14489649277"));
        assertEquals(true, myState.getIsUser());
        assertEquals("0wm-9232", myState.getUserAccount().getAccountNumber());
        myState.setIsUser(false);
        assertEquals(false, myState.getIsUser());
    }

    @Test
    public void testGetUserAccount() {
        myState.setIsUser(true, new User("0wm-9232", "kdf1h04h@@ksw", "wm", "wm9232@xyy.com", "14489649277"));
        assertEquals("0wm-9232", myState.getUserAccount().getAccountNumber());
        assertEquals("wm", myState.getUserAccount().getName());
        assertEquals("wm9232@xyy.com", myState.getUserAccount().getEmail());
        assertEquals("14489649277", myState.getUserAccount().getPhoneNumber());
    }

    @Test
    public void testGetIsUser() {
        assertEquals(false, myState.getIsUser());
        myState.setIsUser(true, new User("0wm-9232", "kdf1h04h@@ksw", "wm", "wm9232@xyy.com", "14489649277"));
        assertEquals(true, myState.getIsUser());
    }
}