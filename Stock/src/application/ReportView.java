package application;

import javax.swing.JFrame;

import java.awt.Container;
import java.util.HashMap;
import javax.swing.JFrame;
import com.mysql.jdbc.Connection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.engine.JasperFillManager;

public class ReportView extends JFrame{

	   public ReportView(String fileName) {
	        this(fileName, null);
	    }

	    public ReportView(String fileName, java.util.HashMap parameter) {
	        super("View Report");

	        try {
	            java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/stockdb", "root", "");
	            net.sf.jasperreports.engine.JasperPrint jp = net.sf.jasperreports.engine.JasperFillManager.fillReport(fileName, parameter, con);
	            net.sf.jasperreports.view.JRViewer jrv = new net.sf.jasperreports.view.JRViewer(jp);
	            if (jp.getPages().isEmpty()) {
	                return;
	            } else {
	                getContentPane().add(jrv);
	                setVisible(true);
	            }
	        } catch (Exception e) {
	            System.err.println(e);
	        }
	        super.setSize(1366, 1024);
	        super.setLocationRelativeTo(null);
	        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    }

}
