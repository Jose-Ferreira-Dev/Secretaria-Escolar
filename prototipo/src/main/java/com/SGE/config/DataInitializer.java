package com.SGE.config;

import com.SGE.model.TipoUsuario;
import com.SGE.model.Usuario;
import com.SGE.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Bean
    public CommandLineRunner initTestUsers(UsuarioRepository usuarioRepo, PasswordEncoder encoder) {
        return args -> {
            // Admin padrão
            if (usuarioRepo.findByUsername("admin").isEmpty()) {
                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin123")); // Senha criptografada
                admin.setTipo(TipoUsuario.ADMIN);
                usuarioRepo.save(admin);
            }

            // Professor padrão
            if (usuarioRepo.findByUsername("professor").isEmpty()) {
                Usuario professor = new Usuario();
                professor.setUsername("professor");
                professor.setPassword(encoder.encode("prof123"));
                professor.setTipo(TipoUsuario.PROFESSOR);
                usuarioRepo.save(professor);
            }

            // Aluno padrão
            if (usuarioRepo.findByUsername("aluno").isEmpty()) {
                Usuario aluno = new Usuario();
                aluno.setUsername("aluno");
                aluno.setPassword(encoder.encode("aluno123"));
                aluno.setTipo(TipoUsuario.ALUNO);
                usuarioRepo.save(aluno);
            }
        };
    }
}