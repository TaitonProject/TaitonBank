package com.taiton.jsonConverter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.taiton.entity.UserEntity;
import com.taiton.entity.UserInfoEntity;

import java.io.IOException;
import java.sql.Date;

/**
 * Created by Taiton on 1/4/2017.
 */
public class UserInfoDeserializer extends JsonDeserializer<UserInfoEntity>{

    @Override
    public UserInfoEntity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        UserInfoEntity userInfo = new UserInfoEntity();
        UserEntity user = new UserEntity();

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        user.setUsername(node.get("username").asText());
        user.setPassword(node.get("password").asText());
        user.setConfirmPassword(node.get("confirmPassword").asText());

        JsonNode nodeInfo = (node.get("info"));

        userInfo.setFirstName(nodeInfo.get("firstName").asText());
        userInfo.setSecondName(nodeInfo.get("secondName").asText());
        userInfo.setSurName(nodeInfo.get("sureName").asText());
        userInfo.setPasportNumber(nodeInfo.get("passportNumber").asText());
        userInfo.setUserByUserId(user);
        return userInfo;
    }
}
