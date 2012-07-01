package com.bahri.pmb.service.editor;


import com.bahri.pmb.domain.User;
import com.bahri.pmb.service.UserService;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: Latief
 * Date: 6/27/11
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserEditor extends PropertyEditorSupport {

    private UserService userService;

    public UserEditor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {

            User result = userService.findUser(text);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("User with username " + text + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            User result = (User) getValue();
            return result.getUsername() + "";
        } else {
            return "";
        }
    }
}