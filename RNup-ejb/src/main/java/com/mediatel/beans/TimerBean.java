/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediatel.beans;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import org.apache.log4j.Logger;

/**
 *
 * @author gkrosnicki
 */
@Stateless
@LocalBean
public class TimerBean {
    private static final Logger logger = Logger.getLogger(TimerBean.class.getName());
    @EJB
    ConcatBean concatBean;
    
    @Schedule(minute="30", hour="12", dayOfWeek="*")
    public void automaticTimeout() {
        System.out.println("Automatic timeout occured !!!!!!!!!!!!!!!!!!!!");
        concatBean.copyTable();
        //logger.info("Automatic timeout occured");
    }
    
}
