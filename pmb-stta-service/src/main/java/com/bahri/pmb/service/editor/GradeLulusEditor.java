package com.bahri.pmb.service.editor;


import com.bahri.pmb.domain.GradeLulus;
import com.bahri.pmb.service.GradeLulusService;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: Latief
 * Date: 6/27/11
 * Time: 9:28 AM
 * To change this template use File | GradeLuluss | File Templates.
 */
public class GradeLulusEditor extends PropertyEditorSupport {

    private GradeLulusService gradeLulusService;

    public GradeLulusEditor(GradeLulusService gradeLulusService) {
        this.gradeLulusService = gradeLulusService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            GradeLulus result = gradeLulusService.getGradeLulus(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("GradeLulus with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            GradeLulus result = (GradeLulus) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}