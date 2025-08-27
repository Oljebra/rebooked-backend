package com.personal.rebooked.marketing;

import com.personal.rebooked.marketing.dto.AddToMailingListDTO;
import com.personal.rebooked.utils.ResponseHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/marketing")
@RestController
public class MarketingController {

    private final MarketingService marketingService;

    @PostMapping("/newsletter")
    public ResponseEntity<Object> addToMailingList(@RequestBody @Valid AddToMailingListDTO dto) {
        Object response = marketingService.addToMailingList(dto);
        return ResponseHandler.generateResponse(response, "Email added to mailing list successfully");
    }

    @PostMapping("/test-ai")
    public ResponseEntity<Object> testAIService(@RequestBody String prompt) {
        String response = marketingService.testAIService(prompt);
        return ResponseHandler.generateResponse(response, "AI service response");
    }
}