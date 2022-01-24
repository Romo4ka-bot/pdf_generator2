package ru.kpfu.itis.pdf_generator2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.pdf_generator2.entities.StatementContent;

/**
 * @author Roman Leontev
 * 18:53 22.01.2022
 * group 11-905
 */

public interface PdfGeneratorRepository extends JpaRepository<StatementContent, Long> {
}
