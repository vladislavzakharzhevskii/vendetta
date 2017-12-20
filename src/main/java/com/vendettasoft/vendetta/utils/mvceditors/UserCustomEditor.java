package com.vendettasoft.vendetta.utils.mvceditors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vendettasoft.vendetta.models.hibernate.User;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class UserCustomEditor extends PropertyEditorSupport {

    @Override
    public void setValue(Object value) {
        super.setValue(value);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        try {
            HashMap<String, Object> result = new ObjectMapper().readValue(text, HashMap.class);

            User user = (User) getValue();
            user.setFirstName((String) result.get("firstName"));
            user.setLastName((String) result.get("lastName"));
            user.setLastName((String) result.get("lastName"));
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dateBirthday = format.parse((String) result.get("dateBirthday"));
            user.setDateBirthday(dateBirthday);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
