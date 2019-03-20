package ru.vitasoft.pilipenko.MIAC_Tables.model.comparison;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/* Operations:
1 - equal
2 - like
3 - between
4 - greater than
5 - less than
6 - start with
*/

public class SearchParams {

    public String firstName;
    public Integer firstNameOperation; //           = , like

    public String lastName;
    public Integer lastNameOperation; //            = , like

    public String patronymicName;
    public Integer patronymicNameOperation;//       = , like

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    public LocalDateTime childBirthTimeDateLeft;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    public LocalDateTime childBirthTimeDateRight;
    public Integer childBirthTimeDateOperation;//   = , > , < , between

    public Integer certSeries;
    public Integer certSeriesOperation;        //   = , like

    public Integer certNumber;
    public Integer certNumberOperation;        //   = , like , start with

    public Integer medCertId;           //Штрих-код
    public Integer medCertIdOperation;        //    = , like

    public String certStatus;
    public Integer certStatusOperation;       //    =

    @JsonFormat(pattern = "dd.MM.yyyy")
    public LocalDate certIssueDateLeft;
    @JsonFormat(pattern = "dd.MM.yyyy")
    public LocalDate certIssueDateRight;
    public Integer certIssueDateOperation;   //     = , > , < , between

    public String certIssueByEmpl;          //Резолюция МИАЦ
    public Integer certIssueByEmplOperation;//      =

    public ArrayList<SearchElement> toArrayList(){

        ArrayList<SearchElement> resultArray = new ArrayList<SearchElement>();

        if (this.firstName != null && this.firstNameOperation != null){
            addNewSearchElement(resultArray,
                                "firstName",
                                firstName,
                                "",
                                "String",
                                firstNameOperation);
        }

        if (this.lastName != null && this.lastNameOperation != null){
            addNewSearchElement(resultArray,
                    "lastName",
                                lastName,
                                "",
                                "String",
                                lastNameOperation);
        }

        if (this.patronymicName != null && this.patronymicNameOperation != null){
            addNewSearchElement(resultArray,
                    "patronymicName",
                                patronymicName,
                                "",
                                "String",
                                patronymicNameOperation);
        }

        if ((this.childBirthTimeDateLeft != null || this.childBirthTimeDateRight != null) && this.childBirthTimeDateOperation != null){
            addNewSearchElement(resultArray,
                    "childBirthTimeDate",
                    childBirthTimeDateLeft,
                    childBirthTimeDateRight,
                    "DateTime",
                    childBirthTimeDateOperation);
        }

        if (this.certSeries != null && this.certSeriesOperation != null) {
            addNewSearchElement(resultArray,
                    "certSeries",
                    certSeries.toString(),
                    "",
                    "Integer",
                    certSeriesOperation);
        }

        if (this.certNumber != null && this.certNumberOperation != null) {
            addNewSearchElement(resultArray,
                    "certNumber",
                    certNumber.toString(),
                    "",
                    "Integer",
                    certNumberOperation);
        }

        if (this.medCertId != null && this.medCertIdOperation != null) {
            addNewSearchElement(resultArray,
                    "medCertId",
                    medCertId.toString(),
                    "",
                    "Integer",
                    medCertIdOperation);
        }

        if (this.certStatus != null && this.certStatusOperation != null) {
            addNewSearchElement(resultArray,
                    "certStatus",
                    certStatus,
                    "",
                    "String",
                    certStatusOperation);
        }

        if ((this.certIssueDateLeft != null || this.certIssueDateRight != null) && this.certIssueDateOperation != null){
            addNewSearchElement(resultArray,
                    "certIssueDate",
                    certIssueDateLeft,
                    certIssueDateRight,
                    "Date",
                    certIssueDateOperation);
        }

        if (this.certIssueByEmpl != null && this.certIssueByEmplOperation != null) {
            addNewSearchElement(resultArray,
                    "certIssueByEmpl",
                    certIssueByEmpl,
                    "",
                    "String",
                    certIssueByEmplOperation);
        }

        return resultArray;
    }

    public void addNewSearchElement(ArrayList<SearchElement> resultArray,
                                    String propertyName,
                                    Object comparisonValue1,
                                    Object comparisonValue2,
                                    String typeOfValue,
                                    Integer operation){

        SearchElement curSearchElement = new SearchElement();

        curSearchElement.propertyName       = propertyName;
        curSearchElement.comparisonValue1   = comparisonValue1;
        curSearchElement.comparisonValue2   = comparisonValue2;
        curSearchElement.typeOfValue        = typeOfValue;
        curSearchElement.operation          = operation;

        resultArray.add(curSearchElement);

    }


}
