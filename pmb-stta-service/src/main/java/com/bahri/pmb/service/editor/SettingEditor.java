package com.bahri.pmb.service.editor;


import com.bahri.pmb.domain.Setting;
import com.bahri.pmb.service.SettingService;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: Latief
 * Date: 6/27/11
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class SettingEditor extends PropertyEditorSupport {

    private SettingService SettingService;

    public SettingEditor(SettingService SettingService) {
        this.SettingService = SettingService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            Setting result = SettingService.getSetting(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("Setting with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            Setting result = (Setting) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}