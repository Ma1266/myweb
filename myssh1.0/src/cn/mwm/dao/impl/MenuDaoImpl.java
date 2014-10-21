package cn.mwm.dao.impl;


import org.springframework.stereotype.Repository;

import cn.mwm.dao.IMenuDao;
import cn.mwm.model.TFunction;

@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<TFunction> implements IMenuDao {
}
