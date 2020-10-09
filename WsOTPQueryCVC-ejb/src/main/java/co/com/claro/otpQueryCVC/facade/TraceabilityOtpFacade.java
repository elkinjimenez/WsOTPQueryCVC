/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpParameters.facade;

import co.com.claro.otpParameters.entity.TraceabilityOtp;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jimenezelkg
 */
@Stateless
public class TraceabilityOtpFacade extends AbstractFacade<TraceabilityOtp> {

    @PersistenceContext(unitName = "UpdateCase")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TraceabilityOtpFacade() {
        super(TraceabilityOtp.class);
    }
    
}
