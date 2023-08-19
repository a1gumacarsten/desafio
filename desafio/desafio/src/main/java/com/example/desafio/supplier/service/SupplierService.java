package com.example.desafio.supplier.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.desafio.telephone.Telephone;
import com.example.desafio.telephone.dto.TelephoneDTO;
import com.example.desafio.supplier.dto.SupplierDTO;
import com.example.desafio.supplier.entity.Supplier;
import com.example.desafio.supplier.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository repository;

	public List<SupplierDTO> getAll() {
		Sort sort = Sort.by(Sort.Order.desc("favorite"));
		List<Supplier> listFornecedores = this.repository.findAll(sort);
		List<SupplierDTO> list = new ArrayList<>();

		for (Supplier fornecedor : listFornecedores) {
			list.add(this.convertToFornecedorDTO(fornecedor));
		}

		return list;
	}

	public SupplierDTO create(SupplierDTO fornecedorDTO) {
		Supplier supplier = new Supplier();
		supplier.setName(fornecedorDTO.getName());
		supplier.setEmail(fornecedorDTO.getEmail());
		supplier.setType(fornecedorDTO.getType());
		supplier.setObservation(fornecedorDTO.getObservation());

		List<Telephone> telefones = new ArrayList<>();
		for (TelephoneDTO dto : fornecedorDTO.getTelephones()) {
			Telephone telephone = new Telephone();
			telephone.setNumber(dto.getNumber());
			telephone.setSupplier(supplier);
			telefones.add(telephone);
		}

		supplier.setTelephones(telefones);

		this.repository.save(supplier);

		return fornecedorDTO;
	}

	public SupplierDTO update(Long id, SupplierDTO fornecedorDTO) {
		Optional<Supplier> optionalSupplier = this.repository.findById(id);

		if (optionalSupplier.isPresent()) {
			Supplier supplier = optionalSupplier.get();
			supplier.setName(fornecedorDTO.getName());
			supplier.setEmail(fornecedorDTO.getEmail());
			supplier.setType(fornecedorDTO.getType());
			supplier.setObservation(fornecedorDTO.getObservation());

			List<Telephone> telefones = new ArrayList<>();
			if (fornecedorDTO.getTelephones() == null || fornecedorDTO.getTelephones().isEmpty()) {
				Telephone telefone = new Telephone();
				telefone.setNumber("00000000");
				telefone.setSupplier(supplier);
				telefones.add(telefone);
			} else {
				for (TelephoneDTO telefoneDTO : fornecedorDTO.getTelephones()) {
					Telephone telefone = new Telephone();
					telefone.setNumber(telefoneDTO.getNumber());
					telefone.setSupplier(supplier);
					telefones.add(telefone);
				}
			}

			supplier.setTelephones(telefones);
			this.repository.save(supplier);

			return fornecedorDTO;
		} else {
			throw new EntityNotFoundException("Fornecedor com ID " + id + " não encontrado.");
		}
	}

	public void delete(List<Long> ids) {
		this.repository.deleteAllById(ids);
	}

	public void favorite(Long id) {
		Optional<Supplier> optionalFornecedor = this.repository.findById(id);

		if (optionalFornecedor.isPresent()) {
			Supplier fornecedor = optionalFornecedor.get();
			fornecedor.setFavorite(!fornecedor.getFavorite());

			this.repository.save(fornecedor);
		} else {
			throw new EntityNotFoundException("Fornecedor com ID " + id + " não encontrado.");
		}
	}

	public SupplierDTO getFornecedorById(Long id) {
		return this.convertToFornecedorDTO(this.repository.findById(id).get());
	}

	public SupplierDTO convertToFornecedorDTO(Supplier fornecedor) {
		SupplierDTO dto = new SupplierDTO();
		dto.setId(fornecedor.getId());
		dto.setName(fornecedor.getName());
		dto.setEmail(fornecedor.getEmail());
		dto.setTelephones(convertToTelefoneDTOs(fornecedor.getTelephones()));
		dto.setType(fornecedor.getType());
		dto.setObservation(fornecedor.getObservation());
		dto.setFavorite(fornecedor.getFavorite());
		return dto;
	}

	private List<TelephoneDTO> convertToTelefoneDTOs(List<Telephone> telefones) {
		List<TelephoneDTO> telefoneDTOs = new ArrayList<>();
		for (Telephone telefone : telefones) {
			TelephoneDTO telefoneDTO = new TelephoneDTO();
			telefoneDTO.setNumber(telefone.getNumber());
			telefoneDTOs.add(telefoneDTO);
		}

		return telefoneDTOs;
	}
}