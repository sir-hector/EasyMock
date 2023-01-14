package MockExamples.MockExamples;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FriendShipsMongoMockitoTest {

    @Test
    public void testGetFriendsList() {
        FriendshipsMongo mockFriends = mock(FriendshipsMongo.class);
        when(mockFriends.getFriendsList("karol")).thenReturn(Arrays.asList("Mary", "Mike"));
        assertEquals(Arrays.asList("Mary", "Mike"), mockFriends.getFriendsList("karol"));
    }
}
