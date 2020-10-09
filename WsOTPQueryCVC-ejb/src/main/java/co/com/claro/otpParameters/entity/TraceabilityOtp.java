/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpParameters.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jimenezelkg
 */
@Entity
@Table(name = "TRACEABILITY_OTP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TraceabilityOtp.findAll", query = "SELECT t FROM TraceabilityOtp t")
    , @NamedQuery(name = "TraceabilityOtp.findByIdTraza", query = "SELECT t FROM TraceabilityOtp t WHERE t.idTraza = :idTraza")
    , @NamedQuery(name = "TraceabilityOtp.findByDocumentTraza", query = "SELECT t FROM TraceabilityOtp t WHERE t.documentTraza = :documentTraza")
    , @NamedQuery(name = "TraceabilityOtp.findByMinTraza", query = "SELECT t FROM TraceabilityOtp t WHERE t.minTraza = :minTraza")
    , @NamedQuery(name = "TraceabilityOtp.findByCvcTraza", query = "SELECT t FROM TraceabilityOtp t WHERE t.cvcTraza = :cvcTraza")
    , @NamedQuery(name = "TraceabilityOtp.findByDescriptionTraza", query = "SELECT t FROM TraceabilityOtp t WHERE t.descriptionTraza = :descriptionTraza")
    , @NamedQuery(name = "TraceabilityOtp.findByFlowTraza", query = "SELECT t FROM TraceabilityOtp t WHERE t.flowTraza = :flowTraza")
    , @NamedQuery(name = "TraceabilityOtp.findByApplicationTraza", query = "SELECT t FROM TraceabilityOtp t WHERE t.applicationTraza = :applicationTraza")
    , @NamedQuery(name = "TraceabilityOtp.findByDataTraza", query = "SELECT t FROM TraceabilityOtp t WHERE t.dataTraza = :dataTraza")
    , @NamedQuery(name = "TraceabilityOtp.findByValueTraza", query = "SELECT t FROM TraceabilityOtp t WHERE t.valueTraza = :valueTraza")
    , @NamedQuery(name = "TraceabilityOtp.findByUserCreate", query = "SELECT t FROM TraceabilityOtp t WHERE t.userCreate = :userCreate")
    , @NamedQuery(name = "TraceabilityOtp.findByDateCreate", query = "SELECT t FROM TraceabilityOtp t WHERE t.dateCreate = :dateCreate")})
public class TraceabilityOtp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRAZA")
    private Long idTraza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DOCUMENT_TRAZA")
    private String documentTraza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "MIN_TRAZA")
    private String minTraza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CVC_TRAZA")
    private String cvcTraza;
    @Size(max = 255)
    @Column(name = "DESCRIPTION_TRAZA")
    private String descriptionTraza;
    @Size(max = 20)
    @Column(name = "FLOW_TRAZA")
    private String flowTraza;
    @Size(max = 50)
    @Column(name = "APPLICATION_TRAZA")
    private String applicationTraza;
    @Size(max = 2000)
    @Column(name = "DATA_TRAZA")
    private String dataTraza;
    @Size(max = 255)
    @Column(name = "VALUE_TRAZA")
    private String valueTraza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USER_CREATE")
    private String userCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_CREATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    public TraceabilityOtp() {
    }

    public TraceabilityOtp(Long idTraza) {
        this.idTraza = idTraza;
    }

    public TraceabilityOtp(Long idTraza, String documentTraza, String minTraza, String cvcTraza, String userCreate, Date dateCreate) {
        this.idTraza = idTraza;
        this.documentTraza = documentTraza;
        this.minTraza = minTraza;
        this.cvcTraza = cvcTraza;
        this.userCreate = userCreate;
        this.dateCreate = dateCreate;
    }

    public Long getIdTraza() {
        return idTraza;
    }

    public void setIdTraza(Long idTraza) {
        this.idTraza = idTraza;
    }

    public String getDocumentTraza() {
        return documentTraza;
    }

    public void setDocumentTraza(String documentTraza) {
        this.documentTraza = documentTraza;
    }

    public String getMinTraza() {
        return minTraza;
    }

    public void setMinTraza(String minTraza) {
        this.minTraza = minTraza;
    }

    public String getCvcTraza() {
        return cvcTraza;
    }

    public void setCvcTraza(String cvcTraza) {
        this.cvcTraza = cvcTraza;
    }

    public String getDescriptionTraza() {
        return descriptionTraza;
    }

    public void setDescriptionTraza(String descriptionTraza) {
        this.descriptionTraza = descriptionTraza;
    }

    public String getFlowTraza() {
        return flowTraza;
    }

    public void setFlowTraza(String flowTraza) {
        this.flowTraza = flowTraza;
    }

    public String getApplicationTraza() {
        return applicationTraza;
    }

    public void setApplicationTraza(String applicationTraza) {
        this.applicationTraza = applicationTraza;
    }

    public String getDataTraza() {
        return dataTraza;
    }

    public void setDataTraza(String dataTraza) {
        this.dataTraza = dataTraza;
    }

    public String getValueTraza() {
        return valueTraza;
    }

    public void setValueTraza(String valueTraza) {
        this.valueTraza = valueTraza;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTraza != null ? idTraza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraceabilityOtp)) {
            return false;
        }
        TraceabilityOtp other = (TraceabilityOtp) object;
        if ((this.idTraza == null && other.idTraza != null) || (this.idTraza != null && !this.idTraza.equals(other.idTraza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.claro.otpParameters.entity.TraceabilityOtp[ idTraza=" + idTraza + " ]";
    }
    
}
