package com.personal.rebooked.marketing;

import java.util.ArrayList;
import java.util.List;

import com.personal.rebooked.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.personal.rebooked.marketing.dto.AddToMailingListDTO;
import com.personal.rebooked.service.BrevoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MarketingService {

    private final BrevoService brevoService;

    private final AiService aiService;

    @Value("${brevo.mailing-list.rebooked-monthly-id}")
    private Integer brevoListId;

//    public void createMailingList() {
//        // Logic for creating a mailing list using Brevo
//    }

    public Object addToMailingList(AddToMailingListDTO dto) {
        String email = dto.email();
        List<Integer> listIds = new ArrayList<>();
        listIds.add(brevoListId);
        return brevoService.addToMailingList(email, listIds);
    }

    //test ai service
    public String testAIService(String prompt) {
        return aiService.chat(prompt);
    }
}
