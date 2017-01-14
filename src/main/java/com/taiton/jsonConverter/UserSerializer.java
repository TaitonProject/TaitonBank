package com.taiton.jsonConverter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.taiton.entity.UserEntity;

import java.io.IOException;

/**
 * Created by Taiton on 1/14/2017.
 */
public class UserSerializer extends JsonSerializer<UserEntity> {

    @Override
    public void serialize(UserEntity userEntity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", userEntity.getId());
        jsonGenerator.writeStringField("username", userEntity.getUsername());
        jsonGenerator.writeStringField("password", userEntity.getPassword());
        jsonGenerator.writeObjectField("roleByRoleIdRole", userEntity.getRoleByRoleIdRole());
        jsonGenerator.writeEndObject();

    }
}
