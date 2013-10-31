/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediatel.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author gkrosnicki
 */
@Entity
public class Operatorzy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ruting_number")
    private String rutingNumber;

    @Column(name = "nazwa_operatora")
    private String nazwaOperatora;

    public String getNazwaOperatora() {
        return nazwaOperatora;
    }

    public void setNazwaOperatora(String nazwaOperatora) {
        this.nazwaOperatora = nazwaOperatora;
    }
        
    public String getRutingNumber() {
        return rutingNumber;
    }

    public void setRutingNumber(String rutingNumber) {
        this.rutingNumber = rutingNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutingNumber != null ? rutingNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operatorzy)) {
            return false;
        }
        Operatorzy other = (Operatorzy) object;
        if ((this.rutingNumber == null && other.rutingNumber != null) || (this.rutingNumber != null && !this.rutingNumber.equals(other.rutingNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mediatel.database.anusiak.Operatorzy[ id=" + rutingNumber + " ]";
    }
    
}
