package com.estoqueapi.service.impl;

import com.estoqueapi.convert.impl.ConvertEstoqueDtoToModel;
import com.estoqueapi.convert.impl.ConvertEstoqueDtoToModelForUpdate;
import com.estoqueapi.convert.impl.ConvertEstoquelToDto;
import com.estoqueapi.convert.impl.ConvertTypeToDto;
import com.estoqueapi.dto.EstoqueDTO;
import com.estoqueapi.dto.ProdutosDTO;
import com.estoqueapi.dto.TypeDTO;
import com.estoqueapi.exception.EstoqueApiException;
import com.estoqueapi.model.Estoque;
import com.estoqueapi.repository.EstoqueRepository;
import com.estoqueapi.repository.TypeRepository;
import com.estoqueapi.service.EstoqueService;
import com.estoqueapi.util.CoreUtil;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Data de Criação:15/09/2022
 * 
 * @author endr
 * @version 1.2
 */
@Service
@AllArgsConstructor
public class TypeServiceImpl  implements TypeService {

	private final TypeRepository repository;

	private final ConvertTypeToDto convertModelToDto;

	//@Override
	public List<TypeDTO> findAll() {
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
