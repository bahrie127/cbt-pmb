package com.bahri.pmb.service.impl;

import com.bahri.pmb.domain.Setting;
import com.bahri.pmb.service.SettingService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/22/12
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("settingService")
@Transactional
public class SettingServiceImpl implements SettingService{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Setting setting) {
        sessionFactory.getCurrentSession().saveOrUpdate(setting);
    }

    @Override
    public Setting getSetting(Long id) {
        return (Setting) sessionFactory.getCurrentSession().get(Setting.class,id);
    }
}
