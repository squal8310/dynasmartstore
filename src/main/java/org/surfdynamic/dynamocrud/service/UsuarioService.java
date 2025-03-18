package org.surfdynamic.dynamocrud.service;

import lombok.extern.slf4j.Slf4j;
import org.surfdynamic.dynamocrud.dto.UsuarioDto;
import org.surfdynamic.dynamocrud.entity.Direccion;
import org.surfdynamic.dynamocrud.entity.Usuario;
import org.surfdynamic.dynamocrud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surfdynamic.dynamocrud.utils.UtilsDto;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Iterable<Usuario> lista(){
        return usuarioRepository.findAll();
    }

    public Usuario getOne(String usuarioId){
        return usuarioRepository.findById(usuarioId).get();
    }

    public Usuario save(UsuarioDto dto){
        Usuario usuario =
                Usuario.builder().usuarioId(UtilsDto.getNumberId()).nombre(dto.getNombre())
                .direccion
                        (Direccion.builder()
                                .ciudad(dto.getDireccion().getCiudad()).calle(dto.getDireccion().getCalle()).cp(dto.getDireccion().getCp()).build()).build();

        return usuarioRepository.save(usuario);
    }

    public Usuario update(UsuarioDto dto){
        Usuario usuario = usuarioRepository.findById(dto.getId()).get();
        usuario.setUsuarioId(dto.getId());
        usuario.setNombre(dto.getNombre());
        usuario.setDireccion(Direccion.builder()
                .ciudad(dto.getDireccion().getCiudad()).calle(dto.getDireccion().getCalle()).cp(dto.getDireccion().getCp()).build());
        return usuarioRepository.save(usuario);
    }

    public void delete(String usuarioId){
        usuarioRepository.deleteById(usuarioId);
    }

    public boolean existsId(String usuarioId){
        return usuarioRepository.existsByUsuarioId(usuarioId);
    }

    public boolean existsNombre(String nombre){
        return usuarioRepository.existsByNombre(nombre);
    }
}
