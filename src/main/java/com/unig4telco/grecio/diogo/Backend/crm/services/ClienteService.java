package com.unig4telco.grecio.diogo.Backend.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.BirthdayPersonList;
import com.unig4telco.grecio.diogo.Backend.crm.DTO.ListClientesDTO;
import com.unig4telco.grecio.diogo.Backend.crm.DTO.RequestBirthDayListDTO;
import com.unig4telco.grecio.diogo.Backend.crm.DTO.RequestClientListDTO;
import com.unig4telco.grecio.diogo.Backend.crm.domain.Clientes;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Page<ListClientesDTO> findAll(RequestClientListDTO filters) {
        Pageable pageable = PageRequest.of(filters.page() - 1, filters.perPage());

        Specification<Clientes> spec = Specification.where(null);

        if (!filters.typeClientId().isEmpty()) {
            spec = spec.and(
                    (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("tipo_cliente_id"), filters.typeClientId()));
        }

        if (!filters.document().isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("aprovacao_documentacao"),
                    "%" + filters.document() + "%"));
        }

        if (!filters.estadoRegisto().isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("estado"), filters.estadoRegisto()));
        }

        if (!filters.search().isEmpty()) {
            spec = spec
                    .and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + filters.search() + "%"));
        }

        Page<Clientes> data = clienteRepository.findAll(spec, pageable);

        return data.map(ListClientesDTO::new);
    }

    public Page<BirthdayPersonList> findBirthdayPerson(RequestBirthDayListDTO filters) {
        Pageable pageable = PageRequest.of(filters.page() - 1, filters.perPage());

        Specification<Clientes> spec = Specification.where(null);

        if (!filters.tipoClienteId().isEmpty()) {
            spec = spec.and(
                    (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("tipo_cliente_id"), filters.tipoClienteId()));
        }

        if (!filters.mes().isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> {
                // Extrai o mês da data de nascimento usando a função MONTH do SQL
                Integer monthValue = Integer.parseInt(filters.mes());
                return criteriaBuilder.equal(criteriaBuilder.function("MONTH", Integer.class, root.get("dataNascimento")), monthValue);
            });            
        }
  
        if (!filters.dataAniversario().isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> {
                // Converte o parâmetro de data (String) para LocalDate
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate parsedDate = LocalDate.parse(filters.dataAniversario(), formatter);
                
                // Compara a data de nascimento completa
                return criteriaBuilder.equal(root.get("dataNascimento"), parsedDate);
            });
        }
        
        if (!filters.search().isEmpty()) {
            spec = spec
                    .and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + filters.search() + "%"));
        }

        Page<Clientes> data = clienteRepository.findAll(spec, pageable);

        return data.map(BirthdayPersonList::new);
    }

}
