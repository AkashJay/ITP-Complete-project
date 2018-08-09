package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import com.mysql.jdbc.Connection;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;




public class PrintReport extends JFrame {
	 
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
 
    public void showReport() throws JRException, ClassNotFoundException, SQLException {
    	
    	Connection c=(Connection) DBcon.ConnerDb();
 
       String reportSrcFile = "‪‪F:\\JavaFX\\Stock\\report\\report9.jrxml";
      // JasperDesign jd=JRXmlLoader.load(reportSrcFile);
      // String query="Select * From add111 where eid='EID102'";
       //JRDesignQuery jq=new JRDesignQuery();
       //jq.setText(query);
      // jd.setQuery(jq);
        // First, compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        System.out.println("a");
     //
      //  JasperReport l = showReport();
        JasperPrint print = JasperFillManager.fillReport(jasperReport, null, c);
        System.out.println("b");
        JRViewer viewer = new JRViewer(print);
        System.out.println("cc");
        viewer.setOpaque(true);
        viewer.setVisible(true);
        System.out.println("cc1");
        this.add(viewer);
        System.out.println("cc2");
        this.setSize(700, 500);
        System.out.println("cc3");
        this.setVisible(true);
        System.out.print("Done!");
 
    }
 
}