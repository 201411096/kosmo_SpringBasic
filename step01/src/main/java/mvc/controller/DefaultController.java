package mvc.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
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
	@RequestMapping("/selectwithoption")
	public String selectwithoption(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		// sql parameter로 넘길 hashmap
		HashMap<String, String> map = new HashMap<String, String>();
		// 0, 1, 2로 넘겨질 검색옵션을 db의 컬럼이름으로 변환하는데 사용할 배열
		String selectoptionArray [] = {"dname","deptno", "loc"};
		// encoding 되어서 넘어온 검색어를 디코딩해서 저장
		String searchword = URLDecoder.decode((String)request.getParameter("searchword"), "utf-8");
		// sql parameter로 넘길 hashmap에 저장		
		map.put("selectoption", selectoptionArray[Integer.parseInt(request.getParameter("selectoption"))]);		
		map.put("searchword", searchword);
		// 검색어 검색옵션에 해당하는 부서 리스트를 받아옴
		List<DeptVO> list = deptDao.selectWithOption(map);
		
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
		return "all"; //all.jsp 이동
	}
}
