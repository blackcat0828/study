package app.messages;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MessageService {

  private static final Logger log = LoggerFactory.getLogger(MessageService.class);

  private MessageRepository repository;

  public MessageService(MessageRepository repository) {
    this.repository = repository;
  }

  @SecurityCheck
  @Transactional
  public Message save(String text) {
    
    return repository.saveMessage(new Message(text));
  }

  @Transactional(readOnly = true)
  public List<Message> getMessages(){
    return repository.getMessages();
  }

}
