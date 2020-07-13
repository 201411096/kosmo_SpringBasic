package mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.DeptVO;

@Repository
public class DeptDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public List<DeptVO> getDeptList() {
		return ss.selectList("dept.list");
	}
}
