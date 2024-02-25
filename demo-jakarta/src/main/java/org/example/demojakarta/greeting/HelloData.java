package org.example.demojakarta.greeting;

import jakarta.enterprise.context.ApplicationScoped;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.*;

@ApplicationScoped
public class HelloData implements Publisher<HelloEntity> {
    private final List<Subscriber<?>> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriber.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {

            }

            @Override
            public void cancel() {

            }
        });
        subscribers.add(subscriber);
    }

    public void add() {
        subscribers.forEach(s -> s.notify());
    }
}
