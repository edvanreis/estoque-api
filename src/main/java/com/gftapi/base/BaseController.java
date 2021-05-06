package com.gftapi.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.google.common.collect.Lists;

import com.gftapi.dto.ResponseMessageDTO;
import com.gftapi.exception.GftApiException;

/**
 * Classe base para a maioria dos recursos Classe BaseController
 * 
 * @param <T> 05/05/2021
 * @version 1.0
 */
public abstract class BaseController<T extends BaseModel, DTO extends BaseDTO> implements Serializable {

	private static final long serialVersionUID = 210001142281554871L;

	protected static final String NOT_FOUND = "Registro não encontrado";

	private final BaseService<T> service;
	private final Class<DTO> clazz;

	@Autowired
	private ModelMapper modelMapper;

	protected BaseController(BaseService<T> service, Class<DTO> clazz) {
		this.service = service;
		this.clazz = clazz;
	}

	@GetMapping
	protected ResponseEntity<List<DTO>> list() {

		try {
			List<T> obj = Lists.newArrayList(service.getList());
			if (obj != null) {
				return ResponseEntity.ok().body(obj.stream().map(this::toDto).collect(Collectors.toList()));
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (GftApiException ex) {
			throw new GftApiException(ex.getMessage());
		}
	}

	@GetMapping("/{id}")
	protected ResponseEntity<DTO> get(@PathVariable Long id) {
		return Optional.ofNullable(toDto(service.findById(id).get()))
				.map(obj -> new ResponseEntity<>(obj, HttpStatus.OK)).orElse(ResponseEntity.notFound().build());
	}

	/**
	 * Obtem uma lista de Objetos
	 *
	 * @param spec
	 * @param sort
	 * @return Iterable
	 */
	public List<T> getList() {
		List<T> result = new ArrayList<>();
		Iterable<T> ti = service.getList();
		if (ti == null)
			return result;
		ti.forEach(result::add);
		return result;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseMessageDTO> delete(@PathVariable(value = "id") Long id) {

	Optional<T> obj = service.findById(id);
		if (!obj.isPresent()) {
			throw new GftApiException(NOT_FOUND);
		}
		service.removeById(id);
		return ResponseEntity.ok().body(new ResponseMessageDTO(1, "Item removido com sucesso!"));
	} 

	public DTO toDto(BaseModel model) {
		if (model == null)
			return null;
		return modelMapper.map(model, clazz);
	}

}
