package com.estoqueapi.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.estoqueapi.dto.EstoqueDTO;
import com.estoqueapi.model.Estoque;
import com.estoqueapi.repository.EstoqueRepository;
import com.estoqueapi.service.EstoqueService;
import com.estoqueapi.util.CoreUtil;

import lombok.AllArgsConstructor;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class EstoqueServiceImpl implements EstoqueService {

	private EstoqueRepository repository;

	/***
	 * Próposito:receber e salvar o estoque
	 * 
	 * @param lista
	 */
	@Transactional
	@Override
	public void save(EstoqueDTO dto) {
		if (CoreUtil.isListNotEmpty(dto.getData())) {
			dto.getData().forEach(i -> validateAndSave(i, dto.getFile()));
		} else {
			validateAndSave(dto, dto.getFile());
		}
	}
	
	@Override
	public void upadte(EstoqueDTO dto) {
		Optional<Estoque> estoqueOpt = this.repository.findById(dto.getId());
		if(estoqueOpt.isPresent()) {
			Estoque estoque = dtoToModelForUpdate(dto,estoqueOpt.get());
			this.repository.save(estoque);			
		}
	}

	@Override
	public void remove(Long id) {
		Optional<Estoque> estoqueOpt = this.repository.findById(id);
		if(estoqueOpt.isPresent()) {
			this.repository.delete(estoqueOpt.get());
		}
	}

	/**
	 * Próposito converter para model
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public Estoque dtoToModel(EstoqueDTO dto) {
				
		return   Estoque.builder()
						.product(dto.getProduct())
						.quantity(dto.getQuantity())
						.type(dto.getType())
						.industry(dto.getIndustry())
						.origin(dto.getOrigin())
						.file(dto.getFile())
						.price(CoreUtil.princeToBigDecimal(dto.getPrice()))
						.build();
	}
	
	/**
	 * Próposito converter para model
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public Estoque dtoToModelForUpdate(EstoqueDTO dto,Estoque estoque) {
				
			estoque.setProduct(dto.getProduct());
			estoque.setQuantity(dto.getQuantity());
			estoque.setType(dto.getType());
			estoque.setIndustry(dto.getIndustry());
			estoque.setOrigin(dto.getOrigin());
			estoque.setFile(dto.getFile());
			estoque.setPrice(CoreUtil.princeToBigDecimal(dto.getPrice()));
			estoque.setFile(dto.getFile());
			estoque.setDataAtualizacao(LocalDateTime.now());
		
		return estoque;
	}

	/**
	 * Próposito converter para model
	 * 
	 * @param dto
	 * @return
	 */
	@Override
	public EstoqueDTO modelToDto(Estoque estoque) {
		
		return    EstoqueDTO.builder()
							.id(estoque.getId())
							.product(estoque.getProduct())
							.quantity(estoque.getQuantity())
							.type(estoque.getType())
							.industry(estoque.getIndustry())
							.origin(estoque.getOrigin())
							.file(estoque.getFile())
							.price(CoreUtil.princeToString(estoque.getPrice()))
							.file(estoque.getFile())
							.build();
	}



	/**
	 * Próposito: verificar se produto existe caso não exista salva
	 * 
	 * @param dto
	 * @param file
	 */
	@Override
	public void validateAndSave(EstoqueDTO dto, String file) {
		BigDecimal price = CoreUtil.princeToBigDecimal(dto.getPrice());
		Optional<Estoque> estoqueOpt = findByProductAndPriceAndQuantity(dto.getProduct(), price, dto.getQuantity());
		if (!estoqueOpt.isPresent()) {
			dto.setFile(file);
			Estoque estoque = dtoToModel(dto);
			estoque.setDataCriacao(LocalDateTime.now());
			this.repository.save(dtoToModel(dto));
		}
	}


	@Override
	public Optional<Estoque> findByProductAndPriceAndQuantity(String product, BigDecimal price, Long quantity) {
		return this.repository.findByProductAndPriceAndQuantity(product, price, quantity);
	}

	@Override
	public List<Estoque> findByProduct(String product) {
		return this.repository.findByProduct(product);
	}




}
