package org.surfdynamic.dynamocrud.repository;

import org.springframework.lang.NonNullApi;
import org.surfdynamic.dynamocrud.entity.Usuario;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

    boolean existsByUsuarioId(String id);
    boolean existsByNombre(String nombre);
}
