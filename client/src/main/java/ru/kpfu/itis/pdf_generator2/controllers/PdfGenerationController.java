package ru.kpfu.itis.pdf_generator2.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.pdf_generator2.dto.StatementContentDTO;
import ru.kpfu.itis.pdf_generator2.services.PdfGeneratorService;

/**
 * @author Roman Leontev
 * 12:07 22.01.2022
 */

@RestController
public class PdfGenerationController {

    private final PdfGeneratorService pdfGeneratorService;

    public PdfGenerationController(PdfGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @PostMapping(value = "/statements", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] generatePdf(@RequestBody StatementContentDTO statementContentDTO) {
        return pdfGeneratorService.generate(statementContentDTO);
    }
}
