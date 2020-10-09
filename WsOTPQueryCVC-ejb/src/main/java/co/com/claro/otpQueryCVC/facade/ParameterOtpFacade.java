/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpParameters.facade;

import co.com.claro.otpParameters.entity.ParameterOtp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jimenezelkg
 */
@Stateless
public class ParameterOtpFacade extends AbstractFacade<ParameterOtp> {

    @PersistenceContext(unitName = "UpdateCase")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParameterOtpFacade() {
        super(ParameterOtp.class);
    }

    public List<ParameterOtp> listado() {
        List<ParameterOtp> list = (List<ParameterOtp>) em.createQuery("SELECT p FROM ParameterOtp p").getResultList();
        return list;
    }

}
