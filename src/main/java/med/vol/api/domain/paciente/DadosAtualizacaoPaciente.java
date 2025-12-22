package med.vol.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.vol.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco

) {}
