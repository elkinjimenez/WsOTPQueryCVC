/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpQueryCVC.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "CODIGOSCVC_OTP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigoscvcOtp.findAll", query = "SELECT c FROM CodigoscvcOtp c")
    , @NamedQuery(name = "CodigoscvcOtp.findByIdRegister", query = "SELECT c FROM CodigoscvcOtp c WHERE c.idRegister = :idRegister")
    , @NamedQuery(name = "CodigoscvcOtp.findByCodAgente", query = "SELECT c FROM CodigoscvcOtp c WHERE c.codAgente = :codAgente")
    , @NamedQuery(name = "CodigoscvcOtp.findByCustcodeAgente", query = "SELECT c FROM CodigoscvcOtp c WHERE c.custcodeAgente = :custcodeAgente")
    , @NamedQuery(name = "CodigoscvcOtp.findByNameAgente", query = "SELECT c FROM CodigoscvcOtp c WHERE c.nameAgente = :nameAgente")
    , @NamedQuery(name = "CodigoscvcOtp.findByCanal", query = "SELECT c FROM CodigoscvcOtp c WHERE c.canal = :canal")
    , @NamedQuery(name = "CodigoscvcOtp.findBySubcanal", query = "SELECT c FROM CodigoscvcOtp c WHERE c.subcanal = :subcanal")
    , @NamedQuery(name = "CodigoscvcOtp.findByCreateuser", query = "SELECT c FROM CodigoscvcOtp c WHERE c.createuser = :createuser")
    , @NamedQuery(name = "CodigoscvcOtp.findByCreatedate", query = "SELECT c FROM CodigoscvcOtp c WHERE c.createdate = :createdate")})
public class CodigoscvcOtp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REGISTER")
    @SequenceGenerator(name = "CODIGOSCVC_OTP_SEQ",
            sequenceName = "CODIGOSCVC_OTP_SEQ",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "CODIGOSCVC_OTP_SEQ")
    private Integer idRegister;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_AGENTE")
    private long codAgente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CUSTCODE_AGENTE")
    private String custcodeAgente;
    @Size(max = 255)
    @Column(name = "NAME_AGENTE")
    private String nameAgente;
    @Size(max = 80)
    @Column(name = "CANAL")
    private String canal;
    @Size(max = 80)
    @Column(name = "SUBCANAL")
    private String subcanal;
    @Size(max = 20)
    @Column(name = "CREATEUSER")
    private String createuser;
    @Column(name = "CREATEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    public CodigoscvcOtp() {
    }

    public CodigoscvcOtp(Integer idRegister) {
        this.idRegister = idRegister;
    }

    public CodigoscvcOtp(Integer idRegister, long codAgente, String custcodeAgente) {
        this.idRegister = idRegister;
        this.codAgente = codAgente;
        this.custcodeAgente = custcodeAgente;
    }

    public Integer getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(Integer idRegister) {
        this.idRegister = idRegister;
    }

    public long getCodAgente() {
        return codAgente;
    }

    public void setCodAgente(long codAgente) {
        this.codAgente = codAgente;
    }

    public String getCustcodeAgente() {
        return custcodeAgente;
    }

    public void setCustcodeAgente(String custcodeAgente) {
        this.custcodeAgente = custcodeAgente;
    }

    public String getNameAgente() {
        return nameAgente;
    }

    public void setNameAgente(String nameAgente) {
        this.nameAgente = nameAgente;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getSubcanal() {
        return subcanal;
    }

    public void setSubcanal(String subcanal) {
        this.subcanal = subcanal;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegister != null ? idRegister.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigoscvcOtp)) {
            return false;
        }
        CodigoscvcOtp other = (CodigoscvcOtp) object;
        if ((this.idRegister == null && other.idRegister != null) || (this.idRegister != null && !this.idRegister.equals(other.idRegister))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.claro.otpQueryCVC.entity.CodigoscvcOtp[ idRegister=" + idRegister + " ]";
    }

}
