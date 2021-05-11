package com.estoqueapi.service;

import java.util.List;

import com.estoqueapi.dto.LojaDTO;
import com.estoqueapi.model.Estoque;

/**
 * Data de Criação:05/05/2021
 * 
 * @author endr
 * @version 1.0
 */
public interface ProductDeliverySevice {

	public List<LojaDTO> getInventoryByStore(String product,Integer qtdStore); 
	
	public List<LojaDTO> createStore(Integer qtdStore);
	
	public List<LojaDTO>  setProduct(Integer qtdStore, List<Estoque> produtos, List<LojaDTO> lojas);
	
	public List<LojaDTO> calcOneStore(List<Estoque> produtos, List<LojaDTO> lojas);


}
