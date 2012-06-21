package com.bahri.pmb.service.editor;


import com.bahri.pmb.domain.Ujian;
import com.bahri.pmb.service.UjianService;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: Latief
 * Date: 6/27/11
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class UjianEditor extends PropertyEditorSupport {

    private UjianService ujianService;

    public UjianEditor(UjianService ujianService) {
        this.ujianService = ujianService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            Ujian result = ujianService.findUjian(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("Ujian with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            Ujian result = (Ujian) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}