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
public class CardDeserializer extends JsonDeserializer<CardEntity>{

    @Override
    public CardEntity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        CardEntity card = new CardEntity();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        card.setAccountId(node.get("accountId").asInt());
        String dateOfExpiryStr = node.get("dateOfExpiry").asText();
        SimpleDateFormat dateFomatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfExpiry = null;
        try {
            dateOfExpiry = new Date(dateFomatter.parse(dateOfExpiryStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        card.setCardNumber(node.get("cardNumber").asInt());
        card.setDateOfExpiry(dateOfExpiry);

        return card;
    }
}
