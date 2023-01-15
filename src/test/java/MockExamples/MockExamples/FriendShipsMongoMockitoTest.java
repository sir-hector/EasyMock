package MockExamples.MockExamples;

import org.jongo.MongoCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FriendShipsMongoMockitoTest {

    @Mock
    private FriendsCollection friendsCollection;

    private FriendshipsMongo friendships;


    @BeforeEach
    public void setUp() {
        // Initialize the mock objects
        MockitoAnnotations.initMocks(this);
        friendships = new FriendshipsMongo();

    }


//    @Test
//    public void testMakeFriends() {
//        // Test the class under test's methods
//        friendships.makeFriends("Alice", "Bob");
//
//        // Verify that the mock object's methods were called as expected
//        verify(friendsCollection).addFriend("Alice", "Bob");
//        verify(friendsCollection).addFriend("Bob", "Alice");
//    }
//
//    @Test
//    public void testAreFriends() {
//        // Define the behavior of the mock object's methods
//        when(friendsCollection.findByName("Alice")).thenReturn(new Person("Alice", Arrays.asList("Bob", "Charlie")));
//
//        // Test the class under test's methods
//        assertTrue(friendships.areFriends("Alice", "Bob"));
//        assertTrue(!friendships.areFriends("Alice", "David"));
//    }

}
