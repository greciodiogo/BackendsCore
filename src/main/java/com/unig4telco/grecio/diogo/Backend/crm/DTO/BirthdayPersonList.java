package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unig4telco.grecio.diogo.Backend.crm.domain.Clientes;

public record BirthdayPersonList(
                Integer id,
                String nome,
                String email,
                String morada,
                String telefone,
                String estado,
                Integer tipo_cliente_id,
                TipoClienteDTO tipoCliente,
                Integer user_id, 
                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
                String data_aniversario,
                Integer mes,
                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
                String data_actual,
                Integer mes_actual,
                String dia_nasc,
                String dia_actual,
                Long dias
                ) {

        public BirthdayPersonList (Clientes cliente){
                this(
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getEmail(),
                        cliente.getMorada(),
                        cliente.getTelefone(),
                        cliente.getEstado(),
                        cliente.getTipo_cliente() != null ? cliente.getTipo_cliente().getId() : null,
                        cliente.getTipo_cliente() != null ? new TipoClienteDTO(cliente.getTipo_cliente()) : null,
                        cliente.getUser_id(),                        
                        formatDate(cliente.getDataNascimento(), "yyyy/MM/dd"), // data_aniversario
                        extractMonth(cliente.getDataNascimento()), // mes
                        formatDate(LocalDate.now(), "yyyy/MM/dd"), // data_actual
                        extractMonth(LocalDate.now()), // mes_actual
                        formatDate(cliente.getDataNascimento(), "dd-MM"), // dia_nasc
                        formatDate(LocalDate.now(), "dd-MM"), // dia_actual
                        calculateDays(cliente.getDataNascimento(), LocalDate.now()) // dias                    
                        );       
        }

        private static String formatDate(LocalDate date, String pattern) {
            return date != null ? date.format(DateTimeFormatter.ofPattern(pattern)) : null;
        }
    
        private static Integer extractMonth(LocalDate date) {
            return date != null ? date.getMonthValue() : null;
        }
    
        private static Long calculateDays(LocalDate birthDate, LocalDate currentDate) {
            return birthDate != null ? ChronoUnit.DAYS.between(currentDate, birthDate) : null;
        }
}
