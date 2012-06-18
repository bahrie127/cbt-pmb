package com.bahri.pmb.service.editor;


import com.bahri.pmb.domain.Soal;
import com.bahri.pmb.service.SoalService;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: Latief
 * Date: 6/27/11
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class SoalEditor extends PropertyEditorSupport {

    private SoalService soalService;

    public SoalEditor(SoalService soalService) {
        this.soalService = soalService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            Soal result = soalService.findSoal(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("Soal with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            Soal result = (Soal) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}