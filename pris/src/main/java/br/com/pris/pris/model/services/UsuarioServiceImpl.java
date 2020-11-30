package br.com.pris.pris.model.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.pris.pris.exceptions.SenhaInvalidaException;
import br.com.pris.pris.model.entities.Empreendedor;
import br.com.pris.pris.model.entities.Usuario;
import br.com.pris.pris.model.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UserDetailsService {
	@Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UsuarioRepository repository;
    
    @Autowired
    private EmpreendedorService empreendedorService;

    @Transactional
    public Usuario salvar(Usuario usuario){
    	Usuario newUsuario = repository.save(usuario);
    	Empreendedor empreendedor = new Empreendedor();
    	empreendedor.setEmail(newUsuario.getEmail());
    	empreendedor.setNome(newUsuario.getNome());
    	empreendedor.setUsuario(newUsuario);
    	empreendedorService.addEmpreendedor(empreendedor);
    	newUsuario = this.repository.findById(newUsuario.getId()).get();
    	newUsuario.setPessoa(empreendedor);
        return repository.save(newUsuario);
    }
    
    
	public Integer loadUserByEmail(String email) throws UsernameNotFoundException {
		Usuario usuario = repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Email ou senha inválidos"));
		
		return usuario.getId();
	}
	

    public UserDetails autenticar( Usuario usuario ){
        UserDetails user = loadUserByUsername(usuario.getEmail());
        boolean senhasBatem = encoder.matches( usuario.getSenha(), user.getPassword() );

        if(senhasBatem){
            return user;
        }

        throw new SenhaInvalidaException();
    }
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email ou senha inválidos"));

        String[] roles = usuario.isAdmin() ?
                new String[]{"ADMIN", "USER"} : new String[]{"USER"};

        return User
                .builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .roles(roles)
                .build();
    }


	public Usuario changeUsuario(@Valid Usuario usuario, String email) {
		Usuario oldUsuario = repository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Não foi possível completar a solicitação."));
		usuario.setId(oldUsuario.getId());
		usuario.setIdPessoa(oldUsuario.getIdPessoa());
		repository.save(usuario);
		Empreendedor empreendedor = this.empreendedorService.findEmpreendedorByEmail(usuario.getEmail());
		empreendedor.setEmail(usuario.getEmail());
    	empreendedor.setNome(usuario.getNome());
    	empreendedor.setUsuario(usuario);
    	empreendedorService.addEmpreendedor(empreendedor);
		return usuario;
	}
}
