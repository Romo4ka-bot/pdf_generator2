package ru.kpfu.itis.pdf_generator2.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.pdf_generator2.entities.enums.StatementType;

import javax.persistence.*;

/**
 * @author Roman Leontev
 * 16:03 22.01.2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "statement_content")
public class StatementContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "statement_type")
    private StatementType statementType;

}
