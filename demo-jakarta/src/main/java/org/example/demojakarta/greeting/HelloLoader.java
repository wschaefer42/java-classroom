package org.example.demojakarta.greeting;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import org.example.demojakarta.hello.Fillings;

import java.util.List;

@Startup
@Singleton
@Log
public class HelloLoader {
    @Inject
    private HelloDao helloDao;

    @Transactional
    @PostConstruct
    void loadData() {
        helloDao.truncate();
        List.of(
                HelloEntity.of("Werner", Fillings.SAD),
                HelloEntity.of("Manuela", Fillings.GREAT),
                HelloEntity.of("Peter", Fillings.OKAY)
        ).forEach(hello -> helloDao.save(hello));
        long count = helloDao.count();
        log.info(String.format("Loaded %d hello records", count));
    }
}
