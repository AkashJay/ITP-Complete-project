package application;



import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class JasperUtil {
	/* public static void main(String[] args) {
	        JasperUtil js = new JasperUtil();
	        js.generateReport("‪C:\\report\\report9.jrxml");
	    }*/
	    public void generateReport(String source) {
	      
	        try {
	           Connection con = DBcon.ConnerDb();
	            Map<String, Object> params = new HashMap<>();
	            JasperReport jasperReport = JasperCompileManager.compileReport(source);
	            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
	            JasperViewer.viewReport(jasperPrint, true);
	        } catch (Exception e) {
	           // e.printStackTrace();
	            System.out.println(e);
	        }
	    }
	    
	    public void generateSalaryReport(String source, String param) {
	    	
	        try {
	            Connection con=DBcon.ConnerDb();
	          //  con = j.getCon();
	            Map<String, Object> params = new HashMap<String, Object>();
	            params.put("month", param);
	            JasperReport jasperReport = JasperCompileManager.compileReport(source);

	            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);

	            JasperViewer.viewReport(jasperPrint, false);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
}
