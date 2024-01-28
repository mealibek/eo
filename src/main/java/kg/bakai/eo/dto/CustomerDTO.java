package kg.bakai.eo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CustomerDTO {
    @NotNull(message = "surname must not be null")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String surname;
    @NotNull(message = "customerName must not be null")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String customerName;
    private String otchestvo;
    private Byte sex;
    @NotNull(message = "Identification number must not be null")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String identificationNumber;
    private Integer nationalityId;
    private Boolean resident;
    private LocalDate dateOfBirth;
    private Integer birthCountryId;
    private String birthCityName;
    private String birthCountryName;
    private AddressInfoDTO registrationAddress;
    private AddressInfoDTO residenceAddress;
}
