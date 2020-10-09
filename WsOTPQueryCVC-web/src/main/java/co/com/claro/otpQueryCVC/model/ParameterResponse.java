package co.com.claro.otpQueryCVC.model;

import co.com.claro.otpQueryCVC.entity.ParameterOtp;
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
