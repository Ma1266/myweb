package cn.mwm.service;


import java.util.List;

import cn.mwm.exception.BusinessException;
import cn.mwm.pageModel.Page;
import cn.mwm.vo.User;

public interface IUserService {

	/**
	 * 
	* @Title: save 
	* @Description: TODO(������һ�仰�����������������) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param @param tuser    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	* @date 2014-9-18 ����1:54:29 
	* @version V1.0
	 * @throws BusinessException 
	 */
	void save(User tuser) throws BusinessException;
   /**
    * 
   * @Title: getUserById 
   * @Description: TODO(������һ�仰�����������������) 
   * @author Ma_2014 ma_swun092@163.com   
   * @param @param userId
   * @param @return    �趨�ļ� 
   * @return User    �������� 
   * @throws 
   * @date 2014-9-18 ����1:54:25 
   * @version V1.0
    */
	User getUserById(Integer userId);
   /**
    * 
   * @Title: getUserByName 
   * @Description: TODO(�����û�����ѯ�û���Ϣ) 
   * @author Ma_2014 ma_swun092@163.com   
   * @param @param userName
   * @param @return    �趨�ļ� 
   * @return TUser    �������� 
   * @throws 
   * @date 2014-8-28 ����11:28:15 
   * @version V1.0
    */
	User getUserByName(String userName) throws BusinessException;
   /**
    * 
   * @Title: findByPage 
   * @Description: TODO(��ҳ��ѯ�û�) 
   * @author Ma_2014 ma_swun092@163.com   
   * @param @param pager
   * @param @param user
   * @param @return    �趨�ļ� 
   * @return Page    �������� 
   * @throws 
   * @date 2014-9-3 ����3:24:07 
   * @version V1.0
    */
	Page findByPage(Page pager, User user)throws BusinessException;
	/**
	 * 
	* @Title: deleteByIds 
	* @Description: TODO(����Id����ɾ���û�) 
	* @author Ma_2014 ma_swun092@163.com   
	* @param @param ids
	* @param @return    �趨�ļ� 
	* @return int    �������� 
	* @throws 
	* @date 2014-9-22 ����3:17:31 
	* @version V1.0
	 */
	int deleteByIds(String ids)throws BusinessException;
	
	
	List<User> findUserList()throws BusinessException;
}
