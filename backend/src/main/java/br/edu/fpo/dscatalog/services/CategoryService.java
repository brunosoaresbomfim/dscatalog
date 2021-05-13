package br.edu.fpo.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fpo.dscatalog.dto.CategoryDTO;
import br.edu.fpo.dscatalog.entities.Category;
import br.edu.fpo.dscatalog.repositories.CategoryRepository;
import br.edu.fpo.dscatalog.services.exceptions.EntityNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		return repository.findAll().stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());				
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> category = repository.findById(id);
		Category entity = category.orElseThrow(() -> new EntityNotFoundException("Category not found!"));
		return new CategoryDTO(entity);
	}
}
