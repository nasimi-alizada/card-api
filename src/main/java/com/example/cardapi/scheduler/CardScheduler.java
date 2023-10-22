package com.example.cardapi.scheduler;

import com.example.cardapi.service.CardService;
import lombok.RequiredArgsConstructor;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.hibernate.annotations.Comment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardScheduler {
    private final CardService cardService;

    @Scheduled(fixedDelayString = "PT1M")
    @SchedulerLock(name = "send",lockAtLeastFor = "PT1M",lockAtMostFor = "PT5M")
    public void send(){
        cardService.send();
    }
}
