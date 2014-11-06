package cn.mwm.service;


import java.util.List;

import cn.mwm.exception.BusinessException;
import cn.mwm.pageModel.Page;
import cn.mwm.vo.User;

public interface IUserService {

	/**
	 * 
	* @Title: save 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param @param tuser    设定文件 
	* @return void    返回类型 
	* @throws 
	* @date 2014-9-18 下午1:54:29 
	* @version V1.0
	 * @throws BusinessException 
	 * @throws Exception 
	 */
	void save(User tuser) throws Exception;
   /**
    * 
   * @Title: getUserById 
   * @Description: TODO(这里用一句话描述这个方法的作用) 
   * @author Ma_2014 ma_swun092@163.com   
   * @param @param userId
   * @param @return    设定文件 
   * @return User    返回类型 
   * @throws 
   * @date 2014-9-18 下午1:54:25 
   * @version V1.0
    */
	User getUserById(Integer userId);
   /**
    * 
   * @Title: getUserByName 
   * @Description: TODO(根据用户名查询用户信息) 
   * @author Ma_2014 ma_swun092@163.com   
   * @param @param userName
   * @param @return    设定文件 
   * @return TUser    返回类型 
   * @throws 
   * @date 2014-8-28 上午11:28:15 
   * @version V1.0
    */
	User getUserByName(String userName) throws BusinessException;
   /**
    * 
   * @Title: findByPage 
   * @Description: TODO(分页查询用户) 
   * @author Ma_2014 ma_swun092@163.com   
   * @param @param pager
   * @param @param user
   * @param @return    设定文件 
   * @return Page    返回类型 
   * @throws 
   * @date 2014-9-3 下午3:24:07 
   * @version V1.0
    */
	Page findByPage(Page pager, User user)throws BusinessException;
	/**
	 * 
	* @Title: deleteByIds 
	* @Description: TODO(根据Id批量删除用户) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param @param ids
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws 
	* @date 2014-9-22 下午3:17:31 
	* @version V1.0
	 */
	int deleteByIds(String ids)throws BusinessException;
	
	
	List<User> findUserList()throws BusinessException;
}
