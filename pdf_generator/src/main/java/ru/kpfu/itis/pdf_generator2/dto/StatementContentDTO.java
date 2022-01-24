package ru.kpfu.itis.pdf_generator2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.pdf_generator2.dto.enums.StatementType;

import java.io.Serializable;

/**
 * @author Roman Leontev
 * 14:45 22.01.2022
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class StatementContentDTO implements Serializable {
    private String firstName;
    private String secondName;
    private StatementType statementType;
}
