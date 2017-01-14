package com.taiton.jsonConverter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.taiton.entity.UserEntity;

import java.io.IOException;

/**
 * Created by Taiton on 1/4/2017.
 */
public class UserDeserializer extends JsonDeserializer<UserEntity>{

    @Override
    public UserEntity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        UserEntity user = new UserEntity();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        user.setId(node.get("id").asInt());
        user.setUsername(node.get("username").asText());
        user.setPassword(node.get("password").asText());
        //user.setRoleByRoleIdRole(node.get("roleByRoleIdRole").);
        return user;
    }
}
