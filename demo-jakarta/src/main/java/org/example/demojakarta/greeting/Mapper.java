package org.example.demojakarta.greeting;

public class Mapper {
    public static HelloDto helloToDto(HelloEntity entity) {
        return new HelloDto(entity.getName(), entity.getFillings().getValue());
    }
}
