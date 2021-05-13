package br.edu.fpo.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fpo.dscatalog.dto.CategoryDTO;
import br.edu.fpo.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
//		List<Category> list = repository.findAll();
//		
//		List<CategoryDTO> listDTO = new ArrayList<>();
//		for (Category category : list) {
//			listDTO.add(new CategoryDTO(category));
//		}
//		
//		return listDTO;
		return repository.findAll().stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());				
	}
}
