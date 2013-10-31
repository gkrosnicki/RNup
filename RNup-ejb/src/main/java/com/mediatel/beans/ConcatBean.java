/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediatel.beans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 *
 * @author gkrosnicki
 */
@Stateless
@LocalBean
public class ConcatBean {

    @EJB
    DownloadBean downloadBean;
    @EJB
    PersistBean persistBean;

    public void copyTable() {
        InputStream is = downloadBean.getRemoteFile();
        HSSFWorkbook workbook = null;
        try {
            workbook = new HSSFWorkbook(is);
        } catch (IOException ex) {
            Logger.getLogger(ConcatBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator iter = sheet.iterator();
        while (iter.hasNext()) {
            HSSFRow row = (HSSFRow) iter.next();
            if (row != null && row.getRowNum()>3) {
                if (row.getCell(4) != null) {
                    String name = row.getCell(4).getStringCellValue();
                    String rn = row.getCell(6).getStringCellValue();
                    if(rn.length()>=5){
                        rn = rn.substring(0, 5);
                    if (name.length() != 0) {
                        System.out.println("name " + name + ", rn " + rn);
                        persistBean.saveRecord(rn, name);
                    }}
                    //System.out.println("name " + name + ", rn " + rn);
                } else {
                }
            }
        }

    }
}
