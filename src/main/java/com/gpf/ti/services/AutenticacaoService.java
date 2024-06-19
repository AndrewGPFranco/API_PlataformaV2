package com.gpf.ti.services;

import com.gpf.ti.dtos.usuario.UserDto;
import com.gpf.ti.enums.GeneroType;
import com.gpf.ti.enums.LevelType;
import com.gpf.ti.exception.FormatoInvalidoException;
import com.gpf.ti.exception.SenhaComPoucosCaracteresException;
import com.gpf.ti.infra.security.SecurityConfigurations;
import com.gpf.ti.model.Usuario;
import com.gpf.ti.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Autowired
    private SecurityConfigurations security;

    public AutenticacaoService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails detailsUser = repository.findByLogin(username);

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);

        session.setAttribute("login", detailsUser.getUsername());
        session.setAttribute("nomeCompleto", ((Usuario) detailsUser).getNomeCompleto());
        session.setAttribute("admin", ((Usuario) detailsUser).getAdmin());
        session.setAttribute("nivel", ((Usuario) detailsUser).getNivel());
        return detailsUser;
    }

    public Usuario getUser(String login, HttpSession session) throws UsernameNotFoundException {
        UserDetails user1 = loadUserByUsername(login);
        if(login.equals(session.getAttribute("login"))) {
            Usuario user = new Usuario();
            user.setLogin((String) session.getAttribute("login"));
            user.setNomeCompleto((String) session.getAttribute("nomeCompleto"));
            user.setAdmin((Boolean) session.getAttribute("admin"));
            user.setNivel((LevelType) session.getAttribute("nivel"));

            return user;
        }
        throw new UsernameNotFoundException("Usuário não encontrado na sessão!");
    }

    public Usuario getUserWithAdmin(String login) throws UsernameNotFoundException {
        return repository.getUsuarioWithAdmin(login);
    }

    /**
     * Depois de algum tempo consegui encontrar o problema referente as validações...
     * É preciso adicionar as validações no DTO também e eu não estava fazendo isso.
     * Resolvi permancer com o código como esta, pois gostei do modo como é feito.
     * @param dto - Parametro com os dados de registro do usuário
     */
    public void registerUser(@Valid UserDto dto) {
        if (dto.senha().length() < 5) {
            throw new SenhaComPoucosCaracteresException();
        }

        String regex = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$";
        String login = dto.login();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(login);
        if (!matcher.matches()) {
            throw new FormatoInvalidoException("Formato de login inválido");
        }

        String senha = security.passwordEncoder().encode(dto.senha());
        repository.registerUser(dto.login(), senha, dto.admin(), dto.nomeCompleto(), dto.dataNascimento(), dto.genero(), dto.telefone(), LevelType.BRONZE);
    }
}
