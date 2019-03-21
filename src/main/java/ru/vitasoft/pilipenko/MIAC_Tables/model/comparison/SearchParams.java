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

    //region  Входные параметры отбора

    //свойства основого сертификата

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

    //свойства сертификата по ссылке

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

    //endregion

    public ArrayList<SearchElement> toArrayList(){

        ArrayList<SearchElement> resultArray = new ArrayList<>();

        if (this.firstName != null && this.firstNameOperation != null){
            addNewSearchElement(resultArray,
                                "firstName",
                                firstName,
                                "",
                                firstNameOperation,
                    "");
        }

        if (this.lastName != null && this.lastNameOperation != null){
            addNewSearchElement(resultArray,
                    "lastName",
                                lastName,
                                "",
                                lastNameOperation,
                    "");
        }

        if (this.patronymicName != null && this.patronymicNameOperation != null){
            addNewSearchElement(resultArray,
                    "patronymicName",
                                patronymicName,
                                "",
                                patronymicNameOperation,
                    "");
        }

        if ((this.childBirthTimeDateLeft != null || this.childBirthTimeDateRight != null) && this.childBirthTimeDateOperation != null){
            addNewSearchElement(resultArray,
                    "childBirthTimeDate",
                    childBirthTimeDateLeft,
                    childBirthTimeDateRight,
                    childBirthTimeDateOperation,
                    "");
        }

        if (this.certSeries != null && this.certSeriesOperation != null) {
            addNewSearchElement(resultArray,
                    "certSeries",
                    certSeries.toString(),
                    "",
                    certSeriesOperation,
                    "medCertId");
        }

        if (this.certNumber != null && this.certNumberOperation != null) {
            addNewSearchElement(resultArray,
                    "certNumber",
                    certNumber.toString(),
                    "",
                    certNumberOperation,
                    "medCertId");
        }

        if (this.medCertId != null && this.medCertIdOperation != null) {
            addNewSearchElement(resultArray,
                    "medCertId",
                    medCertId.toString(),
                    "",
                    medCertIdOperation,
                    "medCertId");
        }

        if (this.certStatus != null && this.certStatusOperation != null) {
            addNewSearchElement(resultArray,
                    "certStatus",
                    certStatus,
                    "",
                    certStatusOperation,
                    "medCertId");
        }

        if ((this.certIssueDateLeft != null || this.certIssueDateRight != null) && this.certIssueDateOperation != null){
            addNewSearchElement(resultArray,
                    "certIssueDate",
                    certIssueDateLeft,
                    certIssueDateRight,
                    certIssueDateOperation,
                    "medCertId");
        }

        if (this.certIssueByEmpl != null && this.certIssueByEmplOperation != null) {
            addNewSearchElement(resultArray,
                    "certIssueByEmpl",
                    certIssueByEmpl,
                    "",
                    certIssueByEmplOperation,
                    "medCertId");
        }

        return resultArray;
    }

    public void addNewSearchElement(ArrayList<SearchElement> resultArray,
                                    String propertyName,
                                    Comparable comparisonValue1,
                                    Comparable comparisonValue2,
                                    Integer operation,
                                    String parentPropertyName){

        SearchElement curSearchElement = new SearchElement();

        curSearchElement.propertyName       = propertyName;
        curSearchElement.comparisonValue1   = comparisonValue1;
        curSearchElement.comparisonValue2   = comparisonValue2;
        curSearchElement.operation          = operation;
        curSearchElement.parentPropertyName = parentPropertyName;

        resultArray.add(curSearchElement);

    }


}
