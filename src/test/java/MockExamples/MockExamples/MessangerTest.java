package MockExamples.MockExamples;

import Messenger.Client;
import Messenger.Messenger;
import Messenger.Template;
import Messenger.MailServer;
import Messenger.TemplateEngine;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MessangerTest {
    @Mock
    private MailServer mailServer;

    @Mock
    private TemplateEngine templateEngine;

    @InjectMocks
    private Messenger messenger;

    @Test
    public void testSendMessage() {
        MockitoAnnotations.initMocks(this);
        Client client = new Client("John", "john@example.com");
        Template template = new Template("Hello, ${name}");

        String msgContent = "Hello, John";
        when(templateEngine.prepareMessage(template, client)).thenReturn(msgContent);

        messenger.sendMessage(client, template);

        verify(mailServer).send(client.getEmail(), msgContent);
    }
}
