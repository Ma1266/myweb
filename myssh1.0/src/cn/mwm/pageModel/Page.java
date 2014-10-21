package cn.mwm.pageModel;

import java.io.Serializable;
import java.util.List;

/**
 * 
* 描      述： 分页信息封装 
* 创 建 人：mawenming email:swun_092@163.com    
* 创建时间：2014-4-17 上午10:54:58  
* 修改备注：  
* @version
 */
public class Page<E> implements Serializable {

	
	
	private Integer page;//查询第几页
	private Integer total;////查询记录数
	private List<E>  resultList;//查询结果集
	private Integer rows;
	private String sort;//排序字段
	private String  order;//asc or desc
	
	
	public Page(Integer page, Integer rows, String sort,
			String order) {
		super();
		this.page = page;
		this.rows = rows;
		this.sort = sort;
		this.order = order;
	}


	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


	public List<E> getResultList() {
		return resultList;
	}


	public void setResultList(List<E> resultList) {
		this.resultList = resultList;
	}


	public Integer getRows() {
		return rows;
	}


	public void setRows(Integer rows) {
		this.rows = rows;
	}


	public String getSort() {
		return sort;
	}


	public void setSort(String sort) {
		this.sort = sort;
	}


	public String getOrder() {
		return order;
	}


	public void setOrder(String order) {
		this.order = order;
	}

}
