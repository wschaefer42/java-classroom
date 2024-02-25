package org.example.jakartahello.controller;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.example.jakartahello.domain.Fillings;
import org.example.jakartahello.domain.Message;
import org.example.jakartahello.domain.MessageRepository;

import java.util.List;
import java.util.logging.Logger;

@Model
@Getter @Log
public class HelloBean {
    @Inject
    private MessageRepository repository;

    @Setter
    private String input;
    @Setter
    private Fillings filling = Fillings.UNKNOWN;
    private String output;
    private Long id = null;

    public Fillings[] getFillingValues() {
        return Fillings.values();
    }

    public List<Message> getHistory() {
        return repository.findAll();
    }

    public void submit() {
        if (StringUtils.isNotBlank(input)) {
            log.info(String.format("Add %s filling %s", input, filling.getValue()));
            repository.add(input, filling);
            output = generateAnswer();
        }
    }

    public String edit(long id) {
        log.info(String.format("Select message with ID %d", id));
        Message message = repository.findById(id);
        if (message == null) {
            throw new RuntimeException(String.format("Message with ID %d not found", id));
        }
        input = message.getName();
        filling = message.getFillings();
        output = generateAnswer();
        id = message.getId();
        return "hello.xhtml";
    }

    public void delete(long id) {
        log.info(String.format("Delete message with ID %d", id));
        repository.delete(id);
    }

    public void cancel() {
        input = "";
        filling = Fillings.UNKNOWN;
        output = "";
        id = null;
    }

    public String history() {
        return "history.xhtml";
    }

    private String generateAnswer() {
        var answer = "Hello " + input;
        if (filling == Fillings.SAD) {
            answer += ", why are you filling sad?";
        }
        return answer;
    }
}
