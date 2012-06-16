package com.bahri.pmb.service.editor;


import com.bahri.pmb.domain.Kategori;
import com.bahri.pmb.service.KategoriService;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: Latief
 * Date: 6/27/11
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class KategoriEditor extends PropertyEditorSupport {

    private KategoriService kategoriService;

    public KategoriEditor(KategoriService kategoriService) {
        this.kategoriService = kategoriService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            Kategori result = kategoriService.findKategori(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("Kategori with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            Kategori result = (Kategori) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}