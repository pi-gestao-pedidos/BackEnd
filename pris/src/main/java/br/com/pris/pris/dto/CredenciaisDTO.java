package br.com.pris.pris.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredenciaisDTO {
	private String email;
    private String senha;
}
