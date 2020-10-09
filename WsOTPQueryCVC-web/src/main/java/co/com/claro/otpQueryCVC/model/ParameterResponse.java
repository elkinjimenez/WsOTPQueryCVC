package co.com.claro.otpQueryCVC.model;

import co.com.claro.otpQueryCVC.entity.CodigoscvcOtp;
import java.util.List;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParameterResponse {

    @Getter
    @Setter
    private List<CodigoscvcOtp> codesCVC;

    @Getter
    @Setter
    private GenericResponse response;

}
