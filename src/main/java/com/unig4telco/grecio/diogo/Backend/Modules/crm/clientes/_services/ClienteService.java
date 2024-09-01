package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.Clientes;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._repositories.ClienteRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteAniversarianteListar.DTO.BirthdayPersonList;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteAniversarianteListar.DTO.RequestBirthDayListDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteListar.DTO.ListClientesDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteListar.DTO.RequestClientListDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Page<ListClientesDTO> findAll(RequestClientListDTO filters) {
        int page = (filters.page() != null) ? filters.page() : 1;
        int perPage = (filters.perPage() != null) ? filters.perPage() : 5;
        
        Pageable pageable = PageRequest.of(page - 1, perPage);

        Specification<Clientes> spec = Specification.where(null);

        if (filters.typeClientId() != null && !filters.typeClientId().isEmpty()) {
            spec = spec.and(
                    (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("tipo_cliente_id"), filters.typeClientId()));
        }

        if (filters.document() != null && !filters.document().isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("aprovacao_documentacao"),
                    "%" + filters.document() + "%"));
        }

        if (filters.estadoRegisto() != null && !filters.estadoRegisto().isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("estado"), filters.estadoRegisto()));
        }

        if (filters.search() != null && !filters.search().isEmpty()) {
            spec = spec
                    .and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + filters.search() + "%"));
        }
        // Adicionando a condição de whereIn para o campo "estado"
        if (filters.status() != null) {
            spec = spec.and((root, query, criteriaBuilder) -> {
                String estado = filters.status();
                if ("2".equals(estado)) {
                    return criteriaBuilder.in(root.get("estado")).value("2");
                } else {
                    return criteriaBuilder.equal(root.get("estado"), estado);
                }
            });
        }


        Page<Clientes> data = clienteRepository.findAll(spec, pageable);

        return data.map(ListClientesDTO::new);
    }

    public Page<BirthdayPersonList> findBirthdayPerson(RequestBirthDayListDTO filters) {
        int page = (filters.page() != null) ? filters.page() : 1;
        int perPage = (filters.perPage() != null) ? filters.perPage() : 5;
        
        Pageable pageable = PageRequest.of(page - 1, perPage);
        Specification<Clientes> spec = Specification.where(null);

        if (filters.tipoClienteId() != null && !filters.tipoClienteId().isEmpty()){
            spec = spec.and(
                    (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("tipo_cliente_id"), filters.tipoClienteId()));
        }

        if (filters.mes() != null && !filters.mes().isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> {
                // Extrai o mês da data de nascimento usando a função MONTH do SQL
                Integer monthValue = Integer.parseInt(filters.mes());
                return criteriaBuilder.equal(criteriaBuilder.function("MONTH", Integer.class, root.get("dataNascimento")), monthValue);
            });            
        }
  
        if (filters.dataAniversario() != null && !filters.dataAniversario().isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> {
                // Converte o parâmetro de data (String) para LocalDate
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate parsedDate = LocalDate.parse(filters.dataAniversario(), formatter);
                
                // Compara a data de nascimento completa
                return criteriaBuilder.equal(root.get("dataNascimento"), parsedDate);
            });
        }
        
        if (filters.search() != null && !filters.search().isEmpty()) {
            spec = spec
                    .and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + filters.search() + "%"));
        }

        Page<Clientes> data = clienteRepository.findAll(spec, pageable);

        return data.map(BirthdayPersonList::new);
    }

}
