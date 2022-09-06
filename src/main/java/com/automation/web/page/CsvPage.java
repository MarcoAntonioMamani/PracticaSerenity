package com.automation.web.page;


import lombok.SneakyThrows;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@DefaultUrl("https://demoqa.com/automation-practice-form")
public class CsvPage extends PageObject {

    @FindBy(id = "firstName")
    private WebElementFacade txtNombre;
    @FindBy(id = "lastName")
    private WebElementFacade txtApellido;
    @FindBy(id = "userEmail")
    private WebElementFacade txtEmail;
    @FindBy(id = "userNumber")
    private WebElementFacade txtTelefono;
    @FindBy(id = "uploadPicture")
    private WebElementFacade btnCargar;

    String CSV_FILE="src/test/resources/data/data.csv";
    @SneakyThrows
    public void ingresarDatos(){
        try {
            Reader reader= Files.newBufferedReader(Paths.get(CSV_FILE));
            CSVParser csvParser=new CSVParser(reader, CSVFormat.DEFAULT.withHeader("nombre","apellido","email"
                    ,"genero","celular","hobbies").withSkipHeaderRecord().withTrim());
            for (CSVRecord  csvRecord:csvParser){
                txtNombre.type(csvRecord.get("nombre"));
                txtApellido.type(csvRecord.get("apellido"));
                txtEmail.type(csvRecord.get("email"));
                txtTelefono.type(csvRecord.get("celular"));
                find("//label[text()='"+csvRecord.get("genero")+"']").click();
                withAction().moveToElement(find("//label[text()='"+csvRecord.get("hobbies")+"']")).perform();
                find("//label[text()='"+csvRecord.get("hobbies")+"']").click();
            }
            upload("src/test/resources/data/imagen.png").to(btnCargar);

            Serenity.takeScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
