/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediatel.beans;

import com.mediatel.entities.Operatorzy;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gkrosnicki
 */
@Stateless
@LocalBean
public class PersistBean {

    @PersistenceContext(unitName = "persistancenp")
    private EntityManager em;

    public void saveRecord(String rn, String name) {
        System.out.println("in saveRecord: name " + name + ", rn " + rn);
        Operatorzy operator = em.find(Operatorzy.class, rn);
        
        if (operator != null) {
            if (operator.getNazwaOperatora().equals(name)) {
                return;
            } else {
                operator.setNazwaOperatora(name);
            }
        } else {
            operator = new Operatorzy();
            operator.setNazwaOperatora(name);
            operator.setRutingNumber(rn);
            em.persist(operator);
        }
        
    }

    public void updateRecord(String rn, String name) {
        Operatorzy operator = em.find(Operatorzy.class, rn);
        operator.setNazwaOperatora(name);
        em.persist(operator);
    }
}
