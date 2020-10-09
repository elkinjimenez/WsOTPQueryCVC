/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpParameters.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jimenezelkg
 */
@Entity
@Table(name = "PARAMETER_OTP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParameterOtp.findAll", query = "SELECT p FROM ParameterOtp p")
    , @NamedQuery(name = "ParameterOtp.findByIdParameter", query = "SELECT p FROM ParameterOtp p WHERE p.idParameter = :idParameter")
    , @NamedQuery(name = "ParameterOtp.findByIdParentparameter", query = "SELECT p FROM ParameterOtp p WHERE p.idParentparameter = :idParentparameter")
    , @NamedQuery(name = "ParameterOtp.findByNameParameter", query = "SELECT p FROM ParameterOtp p WHERE p.nameParameter = :nameParameter")
    , @NamedQuery(name = "ParameterOtp.findByDescriptionParameter", query = "SELECT p FROM ParameterOtp p WHERE p.descriptionParameter = :descriptionParameter")
    , @NamedQuery(name = "ParameterOtp.findByValueParameter", query = "SELECT p FROM ParameterOtp p WHERE p.valueParameter = :valueParameter")
    , @NamedQuery(name = "ParameterOtp.findByAlterValueparameter", query = "SELECT p FROM ParameterOtp p WHERE p.alterValueparameter = :alterValueparameter")})
public class ParameterOtp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PARAMETER")
    private Integer idParameter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PARENTPARAMETER")
    private int idParentparameter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NAME_PARAMETER")
    private String nameParameter;
    @Size(max = 80)
    @Column(name = "DESCRIPTION_PARAMETER")
    private String descriptionParameter;
    @Size(max = 255)
    @Column(name = "VALUE_PARAMETER")
    private String valueParameter;
    @Size(max = 255)
    @Column(name = "ALTER_VALUEPARAMETER")
    private String alterValueparameter;

    public ParameterOtp() {
    }

    public ParameterOtp(Integer idParameter) {
        this.idParameter = idParameter;
    }

    public ParameterOtp(Integer idParameter, int idParentparameter, String nameParameter) {
        this.idParameter = idParameter;
        this.idParentparameter = idParentparameter;
        this.nameParameter = nameParameter;
    }

    public Integer getIdParameter() {
        return idParameter;
    }

    public void setIdParameter(Integer idParameter) {
        this.idParameter = idParameter;
    }

    public int getIdParentparameter() {
        return idParentparameter;
    }

    public void setIdParentparameter(int idParentparameter) {
        this.idParentparameter = idParentparameter;
    }

    public String getNameParameter() {
        return nameParameter;
    }

    public void setNameParameter(String nameParameter) {
        this.nameParameter = nameParameter;
    }

    public String getDescriptionParameter() {
        return descriptionParameter;
    }

    public void setDescriptionParameter(String descriptionParameter) {
        this.descriptionParameter = descriptionParameter;
    }

    public String getValueParameter() {
        return valueParameter;
    }

    public void setValueParameter(String valueParameter) {
        this.valueParameter = valueParameter;
    }

    public String getAlterValueparameter() {
        return alterValueparameter;
    }

    public void setAlterValueparameter(String alterValueparameter) {
        this.alterValueparameter = alterValueparameter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParameter != null ? idParameter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParameterOtp)) {
            return false;
        }
        ParameterOtp other = (ParameterOtp) object;
        if ((this.idParameter == null && other.idParameter != null) || (this.idParameter != null && !this.idParameter.equals(other.idParameter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.claro.otpParameters.entity.ParameterOtp[ idParameter=" + idParameter + " ]";
    }
    
}
