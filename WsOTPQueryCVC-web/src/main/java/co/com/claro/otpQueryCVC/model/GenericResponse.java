package co.com.claro.otpQueryCVC.model;

import lombok.Getter;
import lombok.Setter;

public class GenericResponse {

    @Getter
    @Setter
    private Boolean isValid;
    @Getter
    @Setter
    private String description;

    public GenericResponse() {
    }

    public GenericResponse(Boolean isValid, String description) {
        this.isValid = isValid;
        this.description = description;
    }

}
