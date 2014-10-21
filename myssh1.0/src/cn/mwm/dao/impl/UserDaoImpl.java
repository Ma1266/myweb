package cn.mwm.dao.impl;
import org.springframework.stereotype.Repository;
import cn.mwm.dao.IUserDao;
import cn.mwm.vo.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao<User> {

}
