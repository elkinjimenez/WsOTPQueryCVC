/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpParameters.ws;

import co.com.claro.otpParameters.entity.ParameterOtp;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import co.com.claro.otpParameters.facade.ParameterOtpFacade;
import co.com.claro.otpParameters.model.GenericResponse;
import co.com.claro.otpParameters.model.ParameterResponse;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import java.util.List;

/**
 *
 * @author omarMad
 */
@Path("OtpParameters")
@Stateless
@TransactionManagement
public class OtpParametersService {

    @EJB
    private ParameterOtpFacade parameterOTPFacade;

    public OtpParametersService() {
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("queryParametersOTP")
    public ParameterResponse queryParametersOTP() {
        ParameterResponse response = new ParameterResponse();
        try {
            GenericResponse responseG = new GenericResponse(true, "Transacción completa.");
            List<ParameterOtp> listado = parameterOTPFacade.findAll();
            response.setParameters(listado);
            response.setResponse(responseG);
        } catch (Exception e) {
            GenericResponse responseG = new GenericResponse(false, "Error inesperado en la consulta: " + e);
            response.setResponse(responseG);
        }
        return response;
    }

}
