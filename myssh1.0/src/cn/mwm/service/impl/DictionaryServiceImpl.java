package cn.mwm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.mwm.dao.IndicDao;
import cn.mwm.model.TDictionary;
import cn.mwm.service.IDictionaryService;

@Service("dicService")
public class DictionaryServiceImpl implements IDictionaryService {

	@Autowired
	private IndicDao dicDao;
	@Override
	public List<TDictionary> findAllDic() {
		String hql="from TDictionary";
		return dicDao.find(hql);
	}

}
