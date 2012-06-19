package com.bahri.pmb.service.editor;


import com.bahri.pmb.domain.PengerjaanSoal;
import com.bahri.pmb.service.PengerjaanSoalService;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: Latief
 * Date: 6/27/11
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class PengerjaanSoalEditor extends PropertyEditorSupport {

    private PengerjaanSoalService pengerjaanSoalService;

    public PengerjaanSoalEditor(PengerjaanSoalService pengerjaanSoalService) {
        this.pengerjaanSoalService = pengerjaanSoalService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            PengerjaanSoal result = pengerjaanSoalService.findPengerjaanSoal(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("PengerjaanSoal with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            PengerjaanSoal result = (PengerjaanSoal) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}