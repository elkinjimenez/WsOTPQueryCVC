package co.com.claro.otpParameters.model;

import co.com.claro.otpParameters.entity.ParameterOtp;
import java.util.List;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParameterResponse {

    @Getter
    @Setter
    private List<ParameterOtp> parameters;

    @Getter
    @Setter
    private GenericResponse response;

}
