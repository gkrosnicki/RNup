/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediatel.beans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
//import org.apache.commons.io.FileUtils;

/**
 *
 * @author gkrosnicki
 */
@Stateless
@LocalBean
public class DownloadBean {

    public InputStream getRemoteFile(){
        URL url=null;
        InputStream is = null;
        try {
            url = new URL("http://www.uke.gov.pl/files/?id_plik=12166");
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(DownloadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            /*
            File file = new File("rn.xls");        
            try {
                FileUtils.copyURLToFile(url, file);
            } catch (IOException ex) {
                Logger.getLogger(DownloadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            return file;
            */
            is = url.openStream();
        } catch (IOException ex) {
            Logger.getLogger(DownloadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return is;
    }
    
}
