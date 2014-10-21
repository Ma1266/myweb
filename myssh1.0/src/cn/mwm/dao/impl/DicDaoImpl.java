package cn.mwm.dao.impl;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.mwm.dao.IndicDao;
import cn.mwm.model.TDictionary;

@Repository("dicDao")
public class DicDaoImpl extends BaseDaoImpl<TDictionary> implements IndicDao<TDictionary> {	
}
