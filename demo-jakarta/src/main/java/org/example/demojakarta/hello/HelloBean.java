package org.example.demojakarta.hello;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.logging.Logger;

@Model
@Getter
public class HelloBean {
    @Inject
    private HelloRepository repository;

    @Inject
    private Logger log;

    @Setter
    private String input;
    @Setter
    private Fillings filling = Fillings.UNKNOWN;
    private String output;

    public Fillings[] getFillingValues() {
        return Fillings.values();
    }

    public List<HelloData.Hello> getHistory() {
        return repository.getAll();
    }

    public void submit() {
        if (StringUtils.isNotBlank(input)) {
            log.info(String.format("Add %s filling %s", input, filling.getValue()));
            repository.add(input, filling);
            output = generateAnswer();
        }
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
