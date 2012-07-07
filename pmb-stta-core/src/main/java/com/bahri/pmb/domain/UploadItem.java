package com.bahri.pmb.domain;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 7/6/12
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class UploadItem {

    private CommonsMultipartFile fileData;

    public CommonsMultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }
}
