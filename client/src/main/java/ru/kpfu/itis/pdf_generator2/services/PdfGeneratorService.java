package ru.kpfu.itis.pdf_generator2.services;

import ru.kpfu.itis.pdf_generator2.dto.StatementContentDTO;

/**
 * @author Roman Leontev
 * 15:01 22.01.2022
 * group 11-905
 */

public interface PdfGeneratorService {

    byte[] generate(StatementContentDTO statementContentDTO);
}
