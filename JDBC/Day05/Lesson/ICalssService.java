package com.ychs.service.inter;

import java.util.List;
import java.util.Map;

import com.ychs.bean.Clazz;

/**
 * 服务层的接口
 * @author asus
 *
 */
public interface IClassService {
	public boolean  insertClass(Clazz clazz);

	public boolean updateClass(Clazz clazz);

	public boolean delClass(int id);

	public List<Clazz> getClass(Map<String, Object> map);


}
