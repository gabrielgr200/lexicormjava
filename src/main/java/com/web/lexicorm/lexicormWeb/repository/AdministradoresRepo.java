package com.web.lexicorm.lexicormWeb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.web.lexicorm.lexicormWeb.models.Administrador;

public interface AdministradoresRepo extends CrudRepository<Administrador, Integer> {
    @Query(value = "select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END from cadastros where id = :id", nativeQuery = true)
    public boolean exist(int id);
}
