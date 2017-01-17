package com.taiton.jsonConverter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.taiton.entity.AccountEntity;
import com.taiton.entity.CardEntity;
import com.taiton.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Taiton on 1/4/2017.
 */
@Service
public class CardDeserializer extends JsonDeserializer<CardEntity>{

    @Autowired
    private AccountService accountService;

    @Override
    public CardEntity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        CardEntity card = new CardEntity();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        int i = node.get("accountByAccountId").asInt();
        AccountEntity accountEntity = accountService.find(i);
        card.setAccountByAccountId(accountEntity);
        String dateOfExpiryStr = node.get("dateOfExpiry").asText();
        SimpleDateFormat dateFomatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfExpiry = null;
        try {
            dateOfExpiry = (Date) dateFomatter.parse(dateOfExpiryStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        card.setCardNumber(node.get("cardNumber").asInt());
        card.setDateOfExpiry(dateOfExpiry);
        return card;
    }
}
