package com.bahri.pmb.service.editor;


import com.bahri.pmb.domain.JenisSoal;
import com.bahri.pmb.service.JenisSoalService;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: Latief
 * Date: 6/27/11
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class JenisSoalEditor extends PropertyEditorSupport {

    private JenisSoalService jenisSoalService;

    public JenisSoalEditor(JenisSoalService jenisSoalService) {
        this.jenisSoalService = jenisSoalService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            JenisSoal result = jenisSoalService.findJenisSoal(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("JenisSoal with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            JenisSoal result = (JenisSoal) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}