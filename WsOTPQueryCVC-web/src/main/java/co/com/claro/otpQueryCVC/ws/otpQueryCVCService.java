/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpQueryCVC.ws;

import co.com.claro.otpQueryCVC.entity.CodigoscvcOtp;
import co.com.claro.otpQueryCVC.facade.CodigoscvcOtpFacade;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import co.com.claro.otpQueryCVC.model.GenericResponse;
import co.com.claro.otpQueryCVC.model.ParameterResponse;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import java.util.List;

/**
 *
 * @author omarMad
 */
@Path("otpQueryCVC")
@Stateless
@TransactionManagement
public class otpQueryCVCService {

    @EJB
    private CodigoscvcOtpFacade codigosCVCFacade;

    public otpQueryCVCService() {
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("codesCVC")
    public ParameterResponse codesCVC() {
        ParameterResponse response = new ParameterResponse();
        try {
            GenericResponse responseG = new GenericResponse(true, "Transacción completa.");
            List<CodigoscvcOtp> listado = codigosCVCFacade.findAll();
            response.setCodesCVC(listado);
            response.setResponse(responseG);
        } catch (Exception e) {
            GenericResponse responseG = new GenericResponse(false, "Error inesperado en la consulta: " + e);
            response.setResponse(responseG);
        }
        return response;
    }

}
