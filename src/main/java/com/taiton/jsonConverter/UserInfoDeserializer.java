package com.taiton.jsonConverter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.taiton.entity.UserEntity;
import com.taiton.entity.UserInfoEntity;

import java.io.IOException;


/**
 * Created by Taiton on 1/4/2017.
 */
public class UserInfoDeserializer extends JsonDeserializer<UserInfoEntity>{

    @Override
    public UserInfoEntity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        UserInfoEntity userInfo = new UserInfoEntity();
        UserEntity user = new UserEntity();

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        userInfo.setId(node.get("id").asInt());
        userInfo.setFirstName(node.get("firstName").asText());
        userInfo.setSecondName(node.get("secondName").asText());
        userInfo.setSurName(node.get("surName").asText());
        userInfo.setPasportNumber(node.get("pasportNumber").asText());

        JsonNode nodeUser = (node.get("userByUserId"));

        user.setId(nodeUser.get("id").asInt());
        user.setUsername(nodeUser.get("username").asText());
        user.setPassword(nodeUser.get("password").asText());
        user.setIsBlocked(nodeUser.get("isBlocked").isBoolean());
        userInfo.setUserByUserId(user);
        return userInfo;
    }
}
