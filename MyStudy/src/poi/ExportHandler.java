//package poi;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.hhwy.customerservice.report.ExcelView;
//import com.hhwy.customerservice.report.Student;
//
//@Controller
//public class ExportHandler {
//	
//	@RequestMapping(value = "/exportExcel")  
//    @ResponseBody  
//    public ModelAndView report(ModelMap model, HttpServletRequest request, HttpServletResponse response) {  
//		
//        String[] headers = { "学号", "姓名", "年龄", "性别", "出生日期" };
//		List<Student> dataset = new ArrayList<Student>();
//		dataset.add(new Student(10000001, "张三", 20, true, new Date()));
//		dataset.add(new Student(20000002, "李四", 24, false, new Date()));
//		dataset.add(new Student(30000003, "王五", 22, true, new Date()));
//        
//		model.put("headers", headers);
//		model.put("dataset", dataset);
//        
//		ExcelView excelView = new ExcelView();
//		
//        return new ModelAndView(excelView, model);       
//    }  
//}
