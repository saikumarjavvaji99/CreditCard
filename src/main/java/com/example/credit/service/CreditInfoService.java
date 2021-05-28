package com.example.credit.service;

import com.example.credit.model.CreditHits;
import com.example.credit.model.CreditInfo;
import com.example.credit.model.CreditStat;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
public class CreditInfoService {

    @Autowired
    WebClient webClient;

    ArrayList<Long> list=new ArrayList<>();



    public CreditInfo creditInfo(Long cardID)
    {
        CreditHits creditHits=CreditHits.getInstance();
        creditHits.counter();
        saveHits(cardID);
        return  webClient.get()
                .uri(cardID.toString())
                .retrieve()
                .bodyToMono(CreditInfo.class)
                .block();
    }


    public void saveHits(Long cardId) {

        list.add(cardId);
    }


    public CreditStat creditStat(int start, int limit) {
        CreditStat creditStat = new CreditStat();
        creditStat.setLimit(limit);
        creditStat.setSuccess(true);
        creditStat.setSize(list.size());
        creditStat.setStart(start);

        int end = limit + start;
        if (end > list.size())
            end = list.size();

        if (start > list.size())
            start = 1;

        if (list.size() > 0) {
            List<Long> subList = list.subList(start, end);
            creditStat.setPayload(subList);
        }

        return creditStat;
    }
}
