package com.joy.informationlyt.module.common.service;

import com.joy.informationlyt.domain.entity.BaseEntity;
import com.joy.informationlyt.module.common.result.JoyResult;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class BaseService<T extends BaseEntity>{
	//在使用了spring 4.x以后；可以使用泛型依赖注入；必须使用@Autowired
	@Autowired
	private Mapper<T> mapper;
	
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseService(){
		//this是当前实例化的对象(**ServiceImpl)--- BaseServiceImpl<**>
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		
		clazz = (Class<T>)pt.getActualTypeArguments()[0];
	}

	
	public List<T> selectAll() {
		return mapper.selectAll();
	}

	
	public T selectByPrimaryKey(Serializable id) {
		return mapper.selectByPrimaryKey(id);
	}

	
	public List<T> select(T t) {
		return mapper.select(t);
	}

	
	public int selectCount(T t) {
		return mapper.selectCount(t);
	}
	
	
	public T selectOne(T t){
		return mapper.selectOne(t);
	}
	
	
//	public List<T> queryListByPage(Integer page, Integer rows) {
//		return mapper.selectAll();
//	}

	
	public void insertSelective(T t) {
		//如果用户在新增时没有指定创建和更新时间时，给与默认的值
		if(t.getCreateTime() == null){
			t.setCreateTime(new Date());

		}
		if(t.getUpdateTime() == null){
			t.setUpdateTime(new Date());
		}
		if(t.getIsDelete() == null){
			t.setIsDelete(false);
		}
		mapper.insertSelective(t);
	}

	
	public int updateByPrimaryKeySelective(T t) {
		if(t.getUpdateTime() == null){
			t.setUpdateTime(new Date());
		}		
		return mapper.updateByPrimaryKeySelective(t);
	}
	
	
	public int deleteByPrimaryKey(Serializable id) {
		return mapper.deleteByPrimaryKey(id);
	}

	
	public int deleteByIds(Serializable[] ids) {
		Example example = new Example(clazz);		
		Criteria criteria = example.createCriteria();		
		criteria.andIn("id", Arrays.asList(ids));		
		return mapper.deleteByExample(example);
	}


}
