package com.bahri.pmb.service.editor;


import com.bahri.pmb.domain.Jawaban;
import com.bahri.pmb.service.JawabanService;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: Latief
 * Date: 6/27/11
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class JawabanEditor extends PropertyEditorSupport {

    private JawabanService jawabanService;

    public JawabanEditor(JawabanService jawabanService) {
        this.jawabanService = jawabanService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            Jawaban result = jawabanService.findJawaban(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("Jawaban with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            Jawaban result = (Jawaban) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}