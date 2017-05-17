//package poi;
//
//import java.io.OutputStream;
//import java.net.URLEncoder;
//import java.util.List;
//import java.util.Map;
//
//import javax.mail.internet.MimeUtility;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.springframework.web.servlet.view.document.AbstractExcelView;
//
//import com.hhwy.framework.util.StringUtils;
//
//public class ExcelView extends AbstractExcelView{
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	protected void buildExcelDocument(Map<String, Object> model,
//			HSSFWorkbook workbook, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		
//		OutputStream ouputStream = null;
//		
//		try {
//			
//			ExportExcel<Student> exportExcel = new ExportExcel<>();
//			workbook = exportExcel.exportExcel((String[])model.get("headers"), (List<Student>)model.get("dataset"));
//			
//			String filename = "学生信息.xlsx";
//			filename = encodeFilename(filename, request);
//			
//			response.setContentType("application/vnd.ms-excel");         
//			response.setHeader("Content-Disposition", "attachment;filename=" + filename);
//			ouputStream = response.getOutputStream();         
//			 
//			workbook.write(ouputStream);
//			ouputStream.flush();    
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally{
//			if(ouputStream != null){
//				ouputStream.close();  
//			}
//		}  
//	}
//
//	/**
//	 * 设置下载文件中文件的名称
//	 * 
//	 * @param filename
//	 * @param request
//	 * @return
//	 */
//	public String encodeFilename(String filename, HttpServletRequest request) {
//		String agent = request.getHeader("USER-AGENT");
//		try {
//			if ((agent != null) && (-1 != agent.indexOf("MSIE"))) {
//				String newFileName = URLEncoder.encode(filename, "UTF-8");
//				newFileName = StringUtils.replace(newFileName, "+", "%20");
//				if (newFileName.length() > 150) {
//					newFileName = new String(filename.getBytes("GB2312"),
//							"ISO8859-1");
//					newFileName = StringUtils.replace(newFileName, " ", "%20");
//				}
//				return newFileName;
//			}
//			if ((agent != null) && (-1 != agent.indexOf("Mozilla")))
//				return MimeUtility.encodeText(filename, "UTF-8", "B");
//
//			return filename;
//		} catch (Exception ex) {
//			return filename;
//		}
//	}  
//}
