package ru.kpfu.itis.pdf_generator2.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.pdf_generator2.dto.StatementContentDTO;
import ru.kpfu.itis.pdf_generator2.entities.StatementContent;
import ru.kpfu.itis.pdf_generator2.repositories.PdfGeneratorRepository;
import ru.kpfu.itis.pdf_generator2.services.PdfGeneratorService;

/**
 * @author Roman Leontev
 * 15:02 22.01.2022
 */

@Service
@RequiredArgsConstructor
public class PdfGeneratorImpl implements PdfGeneratorService {

    private final Exchange exchange;
    private final RabbitTemplate rabbitTemplate;
    private final PdfGeneratorRepository pdfGeneratorRepository;
    private final ModelMapper modelMapper;

    @Override
    public byte[] generate(StatementContentDTO statementContentDTO) {
        pdfGeneratorRepository.save(modelMapper.map(statementContentDTO, StatementContent.class));
        return (byte[]) rabbitTemplate.convertSendAndReceive(exchange.getName(),
                statementContentDTO.getStatementType().toString().toLowerCase(),
                statementContentDTO);
    }
}
