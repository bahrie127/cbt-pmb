package com.bahri.pmb.service;

import com.bahri.pmb.domain.Setting;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/22/12
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
public interface SettingService {

    public void save(Setting setting);

    public Setting getSetting();
}
