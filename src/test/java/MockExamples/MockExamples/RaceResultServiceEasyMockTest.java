package MockExamples.MockExamples;

import static org.easymock.EasyMock.*;
import static org.mockito.Mockito.never;

import Race.Client;
import Race.Message;
import Race.RaceResultService;
import org.junit.Test;

public class RaceResultServiceEasyMockTest {

    @Test
    public void testSend() {
        Client client1 = createMock(Client.class);
        Client client2 = createMock(Client.class);
        Message message = createMock(Message.class);
        RaceResultService service = new RaceResultService();

        client1.receive(message);
        expectLastCall().once();
        client2.receive(message);
        expectLastCall().once();

        replay(client1, client2);

        service.addSubscriber(client1);
        service.addSubscriber(client2);
        service.send(message);

        verify(client1);
        verify(client2);
    }

}
