package MockExamples.MockExamples;

import static org.mockito.Mockito.*;

import Race.Client;
import Race.Message;
import Race.RaceResultService;
import org.junit.Test;
import org.mockito.Mockito;

public class RaceResultServiceMocitoTest {
    @Test
    public void testAddSubscriber() {
        Client client = mock(Client.class);
        RaceResultService service = new RaceResultService();

        service.addSubscriber(client);
        service.send(new Message("test"));
        verify(client, times(1)).receive(Mockito.any(Message.class));
    }

    @Test
    public void testSend() {
        Client client1 = mock(Client.class);
        Client client2 = mock(Client.class);
        Message message = mock(Message.class);
        RaceResultService service = new RaceResultService();

        service.addSubscriber(client1);
        service.addSubscriber(client2);
        service.send(message);

        verify(client1, times(1)).receive(message);
        verify(client2, times(1)).receive(message);
    }

    @Test
    public void testRemoveSubscriber() {
        Client client1 = mock(Client.class);
        Client client2 = mock(Client.class);
        Message message = mock(Message.class);
        RaceResultService service = new RaceResultService();

        service.addSubscriber(client1);
        service.addSubscriber(client2);
        service.removeSubscriber(client1);
        service.send(message);

        verify(client1, never()).receive(message);
        verify(client2, times(1)).receive(message);
    }
}
