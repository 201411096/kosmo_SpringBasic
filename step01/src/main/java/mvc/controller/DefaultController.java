package mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.DataTypes;

import mvc.dao.DeptDao;
import vo.DeptVO;

@Controller
public class DefaultController {
	
	@Autowired
	private DeptDao deptDao;
	
	
	@RequestMapping("/all")
	public String defaultMain(Model model) {
		List<DeptVO> list = deptDao.getDeptList();
		
		//-------------------------
		//DB에서 받아온 값을 넥사크로로 바인딩할 수 있도록 처리
		DataSet ds = new DataSet("ar");
		ds.addColumn("deptno", DataTypes.INT, 10);
		ds.addColumn("dname", DataTypes.STRING, 20);
		ds.addColumn("loc", DataTypes.STRING, 30);
		
		for(DeptVO vo : list) {
			int row = ds.newRow();
			ds.set(row, "deptno", vo.getDeptno());
			ds.set(row, "dname", vo.getDname());
			ds.set(row, "loc", vo.getLoc());
		}
		model.addAttribute("ds", ds);
		return "all"; //all.jsp
	}
}
