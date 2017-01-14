package com.taiton.jsonConverter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.taiton.entity.UserInfoEntity;
import com.taiton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by Taiton on 1/14/2017.
 */
public class UserInfoSerializer extends JsonSerializer<UserInfoEntity> {

    @Autowired
    UserService userService;

    @Override
    public void serialize(UserInfoEntity userInfoEntity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", userInfoEntity.getId());
        jsonGenerator.writeStringField("firstName", userInfoEntity.getFirstName());
        jsonGenerator.writeStringField("secondName", userInfoEntity.getSecondName());
        jsonGenerator.writeStringField("surName", userInfoEntity.getSurName());
        jsonGenerator.writeStringField("pasportNumber", userInfoEntity.getPasportNumber());
        jsonGenerator.writeObjectField("userByUserId", userInfoEntity.getUserByUserId());
        jsonGenerator.writeEndObject();
    }
}
