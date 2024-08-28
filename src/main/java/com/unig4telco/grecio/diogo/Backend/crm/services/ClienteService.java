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
import com.unig4telco.grecio.diogo.Backend.crm.domain.Clientes;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Page<ListClientesDTO> findAll(int page, int perPage, String typeClientId, String document,
            String estadoRegisto, String search) {
        Pageable pageable = PageRequest.of(page - 1, perPage);

        Specification<Clientes> spec = Specification.where(null);

        if (!typeClientId.isEmpty()) {
            spec = spec.and(
                    (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("tipo_cliente_id"), typeClientId));
        }

        if (!document.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("aprovacao_documentacao"),
                    "%" + document + "%"));
        }

        if (!estadoRegisto.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("estado"), estadoRegisto));
        }

        if (!search.isEmpty()) {
            spec = spec
                    .and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + search + "%"));
        }

        Page<Clientes> data = clienteRepository.findAll(spec, pageable);

        return data.map(ListClientesDTO::new);
    }

    public Page<BirthdayPersonList> findBirthdayPerson(int page, int perPage, String typeClientId, String mes,
            String dateBirth, String search) {
        Pageable pageable = PageRequest.of(page - 1, perPage);

        Specification<Clientes> spec = Specification.where(null);

        if (!typeClientId.isEmpty()) {
            spec = spec.and(
                    (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("tipo_cliente_id"), typeClientId));
        }

        if (!mes.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> {
                // Extrai o mês da data de nascimento usando a função MONTH do SQL
                Integer monthValue = Integer.parseInt(mes);
                return criteriaBuilder.equal(criteriaBuilder.function("MONTH", Integer.class, root.get("dataNascimento")), monthValue);
            });            
        }
  
        if (!dateBirth.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> {
                // Converte o parâmetro de data (String) para LocalDate
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate parsedDate = LocalDate.parse(dateBirth, formatter);
                
                // Compara a data de nascimento completa
                return criteriaBuilder.equal(root.get("dataNascimento"), parsedDate);
            });
        }
        
        if (!search.isEmpty()) {
            spec = spec
                    .and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + search + "%"));
        }

        Page<Clientes> data = clienteRepository.findAll(spec, pageable);

        return data.map(BirthdayPersonList::new);
    }

}
