package finalproject.com.Clinica_Odontologica.dto.request;

import finalproject.com.Clinica_Odontologica.utils.GsonProvider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurnoRequestDto {
    private Integer paciente_id;
    private Integer odontologo_id;
    private String fecha;
    @Override
    public String toString() {
        return GsonProvider.getGson().toJson(this);
    }
}

