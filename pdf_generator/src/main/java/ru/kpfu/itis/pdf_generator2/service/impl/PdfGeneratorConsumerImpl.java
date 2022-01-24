package ru.kpfu.itis.pdf_generator2.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.pdf_generator2.dto.StatementContentDTO;
import ru.kpfu.itis.pdf_generator2.service.PdfGeneratorConsumer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Roman Leontev
 * 15:43 22.01.2022
 */

@Service
public class PdfGeneratorConsumerImpl implements PdfGeneratorConsumer {

    @RabbitListener(queues = {"budget.requests"})
    public byte[] listenBudgetQueue(StatementContentDTO statementContentDTO) {
        return generateBudgetPdf(statementContentDTO);
    }

    @RabbitListener(queues = {"dayoff.requests"})
    public byte[] listenDayOffQueue(StatementContentDTO statementContentDTO) {
        return generateDayOffPdf(statementContentDTO);
    }

    private byte[] generateDayOffPdf(StatementContentDTO statementContentDTO) {
        Document document = new Document();
        BaseFont bf = null;
        try {
            bf = BaseFont.createFont("pdf_generator/src/main/resources/fonts/times_roman.ttf", BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED);
        } catch (DocumentException | IOException e) {
            throw new IllegalStateException(e);
        }
        Font normal = new Font(bf, 12, Font.NORMAL);
        try {

            PdfWriter.getInstance(document,
                    new FileOutputStream("Statement_DayOff.pdf"));

            document.open();

            Paragraph author = new Paragraph("Генеральному Директору\n" +
                    "ООО \"Арабские Шейхи\"\n" +
                    "O.G. Buda\n" +
                    statementContentDTO.getSecondName() + " " +
                    statementContentDTO.getFirstName(), normal);
            author.setAlignment(Element.ALIGN_RIGHT);
            author.setSpacingAfter(14);
            document.add(author);

            Paragraph title = new Paragraph("Заявление", normal);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(10);
            document.add(title);

            Paragraph text =
                    new Paragraph("Прошу предоставить дни за свой счет с  <__> _______2022  на __ календарных дня.\n",
                            normal);
            text.setSpacingAfter(80);
            document.add(text);

            Paragraph date = new Paragraph("<__> _______2022",
                    normal);
            date.setAlignment(Element.ALIGN_LEFT);
            document.add(date);

            Paragraph signature = new Paragraph("_____________\nПодпись",
                    normal);
            signature.setAlignment(Element.ALIGN_RIGHT);
            document.add(signature);

            document.close();
            return Files.readAllBytes(Paths.get("/Users/romanleontev/Documents/pdf_generator2/Statement_DayOff.pdf"));
        } catch (DocumentException | IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] generateBudgetPdf(StatementContentDTO statementContentDTO) {
        Document document = new Document();
        BaseFont bf = null;
        try {
            bf = BaseFont.createFont("pdf_generator/src/main/resources/fonts/times_roman.ttf", BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED);
        } catch (DocumentException | IOException e) {
            throw new IllegalStateException(e);
        }
        Font normal = new Font(bf, 12, Font.NORMAL);
        try {

            PdfWriter.getInstance(document,
                    new FileOutputStream("Statement_Budget.pdf"));

            document.open();

            Paragraph author = new Paragraph("ВРИО ректора КФУ\n" +
                    "Таюрскому  Д.А.\n" +
                    "от студента очного отделения\n" +
                    "контрактной формы обучения ИТИС\n" +
                    "1 курс, группа 11-101\n" +
                    statementContentDTO.getSecondName() + "a " +
                    statementContentDTO.getFirstName() +
                    "a\n" +
                    "тел. 89177523458\n" +
                    "Адрес: г. Казань, ул. Ленина, д. 5, кв. 15", normal);
            author.setAlignment(Element.ALIGN_RIGHT);
            author.setSpacingAfter(14);
            document.add(author);

            Paragraph title = new Paragraph("Заявление", normal);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(10);
            document.add(title);

            Paragraph text =
                    new Paragraph("Прошу перевести меня, " + statementContentDTO.getSecondName() + "a " + statementContentDTO.getFirstName() + "a " +
                            "с " +
                            "контрактной формы " +
                            "обучения на " +
                            "бюджетную, в связи с отличной успеваемостью (направление подготовки 09.03.04 " +
                            "«Программная инженерия»)", normal);
            text.setSpacingAfter(80);
            document.add(text);

            Paragraph signature = new Paragraph("подпись", normal);
            signature.setAlignment(Element.ALIGN_RIGHT);
            signature.setSpacingAfter(5);
            document.add(signature);

            Paragraph date = new Paragraph("дата", normal);
            date.setAlignment(Element.ALIGN_RIGHT);
            document.add(date);

            document.close();
            return Files.readAllBytes(Paths.get("/Users/romanleontev/Documents/pdf_generator2/Statement_Budget.pdf"));
        } catch (DocumentException | IOException e) {
            throw new IllegalStateException(e);
        }

    }

}
