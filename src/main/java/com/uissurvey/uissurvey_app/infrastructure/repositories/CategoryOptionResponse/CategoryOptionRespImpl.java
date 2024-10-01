package com.uissurvey.uissurvey_app.infrastructure.repositories.CategoryOptionResponse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uissurvey.uissurvey_app.application.services.ICategoryOptionResService;
import com.uissurvey.uissurvey_app.domain.entities.CategoryOptionResponse;
import com.uissurvey.uissurvey_app.domain.entities.fkClass.CategoryOptionResponseId;


@Service
public class CategoryOptionRespImpl implements ICategoryOptionResService {

    @Autowired
    private CategoryOptionRespRepository respository;


    @Override
    public List<CategoryOptionResponse> findAll() {
        return (List<CategoryOptionResponse>) respository.findAll();
    }

    @Override
    public Optional<CategoryOptionResponse> findById(CategoryOptionResponseId id) {
        return respository.findById(id);
    }

    @Override
    public CategoryOptionResponse save(CategoryOptionResponse categoryoptresp) {
        return respository.save(categoryoptresp);
    }

    @Override
    public Optional<CategoryOptionResponse> update(CategoryOptionResponseId id, CategoryOptionResponse categoryoptresp) {
        // Verificar si el objeto existe
        Optional<CategoryOptionResponse> existingResponse = respository.findById(id);
        if (existingResponse.isPresent()) {
            // Actualizar el objeto existente
            categoryoptresp.setId(id); // Asegurarse de que el ID sea el mismo
            return Optional.of(respository.save(categoryoptresp));
        }
        return Optional.empty(); // Si no existe, retornar vacío
    }

    @Override
    public Optional<CategoryOptionResponse> delete(CategoryOptionResponseId id) {
        Optional<CategoryOptionResponse> existingResponse = respository.findById(id);
        if (existingResponse.isPresent()) {
            // Eliminar si existe
            respository.deleteById(id);
            return existingResponse; // Retornar el objeto eliminado
        }
        return Optional.empty();
     } // Si no existe, retornar vacío    }

}
