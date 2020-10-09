/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpQueryCVC.facade;

import co.com.claro.otpQueryCVC.entity.CodigoscvcOtp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jimenezelkg
 */
@Stateless
public class CodigoscvcOtpFacade extends AbstractFacade<CodigoscvcOtp> {

    @PersistenceContext(unitName = "UpdateCase")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CodigoscvcOtpFacade() {
        super(CodigoscvcOtp.class);
    }

    public List<CodigoscvcOtp> searchCode(String code) {
        List<CodigoscvcOtp> cod = (List<CodigoscvcOtp>) em.createQuery("SELECT c FROM CodigoscvcOtp c WHERE c.custcodeAgente='" + code + "'").getResultList();
        return cod;
    }

}
