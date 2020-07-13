package mvc.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(value="/all")
	public String defaultMain(Model model) {
		System.out.println("-----------all---------------");
		List<DeptVO>list= deptDao.getDeptList();		
		
		// 나중에 넥사크로의 데이터셋으로 바인딩 될 이름
		DataSet ds = new DataSet("ar"); 
		// 데이터 셋에 들어갈 이름과 자료형이 동일해야 한다.
		ds.addColumn("deptno", DataTypes.INT,10);
		ds.addColumn("dname", DataTypes.STRING,20);
		ds.addColumn("loc", DataTypes.STRING,20);
		for(DeptVO vo : list){
			int row = ds.newRow();
			ds.set(row, "deptno", vo.getDeptno());
			ds.set(row, "dname", vo.getDname());
			ds.set(row, "loc", vo.getLoc());
			//System.out.println(vo.getDeptno() +"/" + vo.getDname() + "/" + vo.getLoc() );
		}
		model.addAttribute("ds", ds);
		return "all";
	}
	



	@RequestMapping(value="/deptAdd")
	public String addDept(DeptVO vo, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("euc-kr");
			String dnamev =URLDecoder.decode(vo.getDname(), "UTF-8");
			String loc = URLDecoder.decode(vo.getLoc(), "UTF-8");
			System.out.println(dnamev);
			System.out.println(loc);
			vo.setDname(dnamev);
			vo.setLoc(loc);
			deptDao.addDept(vo);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//return "success";  입력 성공 확인 후 "redirect:all"
		return "redirect:all";
	}

}
