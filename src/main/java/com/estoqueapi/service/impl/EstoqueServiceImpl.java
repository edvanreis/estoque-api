package com.estoqueapi.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.estoqueapi.convert.ConverterForUpdate;
import com.estoqueapi.convert.impl.ConvertEstoqueDtoToModel;
import com.estoqueapi.convert.impl.ConvertEstoqueDtoToModelForUpdate;
import com.estoqueapi.convert.impl.ConvertEstoquelToDto;
import com.estoqueapi.dto.ProdutosDTO;
import org.springframework.stereotype.Service;

import com.estoqueapi.dto.EstoqueDTO;
import com.estoqueapi.exception.EstoqueApiException;
import com.estoqueapi.model.Estoque;
import com.estoqueapi.repository.EstoqueRepository;
import com.estoqueapi.service.EstoqueService;
import com.estoqueapi.util.CoreUtil;
import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.2
 */
@Service
@AllArgsConstructor
public class EstoqueServiceImpl implements EstoqueService {

	private final EstoqueRepository repository;

	private final ConvertEstoquelToDto convertModelToDto;

	private final ConvertEstoqueDtoToModel convertDtoToModel;

	private final ConvertEstoqueDtoToModelForUpdate converterForUpdate;


	@Transactional
	@Override
	public EstoqueDTO save(EstoqueDTO dto) {
		var estoque = convertDtoToModel.convert(dto);
		return convertModelToDto.convert(this.repository.save(estoque));
	}

	@Override
	public void saveAll(ProdutosDTO dto) {
		if (CoreUtil.isListNotEmpty(dto.getData())) {
			dto.getData().forEach(i -> validateAndSave(i, dto.getFile()));
		}
	}
	
	@Override
	public void update(EstoqueDTO dto) {
		var estoqueOpt = this.repository.findById(dto.getId());
		estoqueOpt.ifPresent(e->{
			var estoque = converterForUpdate.convert(e,dto);
			this.repository.save(estoque);
		});
	}

	@Override
	public void remove(String id) {
		var estoqueOpt = this.repository.findById(id);
		estoqueOpt.ifPresent(e->{
			this.repository.delete(e);
		});
	}


	/**
	 * Próposito: verificar se produto existe caso não exista salva
	 * 
	 * @param dto
	 * @param file
	 */
	@Override
	public void validateAndSave(EstoqueDTO dto, String file) {
		var price = CoreUtil.princeToBigDecimal(dto.getPrice());
		var estoqueOpt = findByProductAndPriceAndQuantity(dto.getProduct(), price, dto.getQuantity());
		if (!estoqueOpt.isPresent()) {
			//dto.setFile(file);
		    save(dto);
		}
	}


	@Override
	public Optional<Estoque> findByProductAndPriceAndQuantity(String product, BigDecimal price, Long quantity) {
		return this.repository.findByProductAndPriceAndQuantity(product, price, quantity);
	}

	@Override
	public List<Estoque> findByProduct(String product) {
		var obj = this.repository.findByProduct(product);
		if(CoreUtil.isListNotEmpty(obj)) {
			return obj;
		}
		throw new EstoqueApiException("Não existem dados para esta pesquisa!");
	}
	
	@Override
	public List<EstoqueDTO> findAll() {
		var obj = Lists.newArrayList(this.repository.findAll());
		if(CoreUtil.isListNotEmpty(obj)) {
			return obj.stream().map(e->{
				return convertModelToDto.convert(e);
			}).collect(Collectors.toList());
		} else {
			throw new EstoqueApiException("Não existem dados para esta pesquisa!");
		}

	}




}
