package com.taiton.validator;

import com.taiton.entity.RolesEntity;
import com.taiton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Taiton on 11/27/2016.
 */
@Component
public class RoleValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return RolesEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
//        RolesEntity rolesEntity = (RolesEntity) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "Required");

    }
}
