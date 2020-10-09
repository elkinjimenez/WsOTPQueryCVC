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
    @Path("searchCode")
    public ParameterResponse searchCode(@QueryParam("code") String code) {
        ParameterResponse response = new ParameterResponse();
        try {
            code = code.replaceAll("\"", "");
            code = code.replaceAll("\'", "");
            List<CodigoscvcOtp> codigos = codigosCVCFacade.searchCode(code);
            if (codigos.size() > 0) {
                GenericResponse responseG = new GenericResponse(true, "Código " + code + " encontrado");
                response.setCodesCVC(codigos);
                response.setResponse(responseG);
            } else {
                GenericResponse responseG = new GenericResponse(false, "El código " + code + " no fue encontrado.");
                response.setResponse(responseG);
            }
        } catch (Exception e) {
            GenericResponse responseG = new GenericResponse(false, "Error inesperado en la consulta: " + e);
            response.setResponse(responseG);
        }
        return response;
    }

}
