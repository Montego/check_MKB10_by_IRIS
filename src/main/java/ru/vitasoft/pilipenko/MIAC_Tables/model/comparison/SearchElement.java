package ru.vitasoft.pilipenko.MIAC_Tables.model.comparison;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

/* Operations:
1 - equal
2 - like
3 - between
4 - greater than
5 - less than
6 - start with
*/

public class SearchElement {

    public String propertyName;
    public Object comparisonValue1;
    public Object comparisonValue2;
    public String typeOfValue;
    public Integer operation;

    public void addElemToArrayList(ArrayList<SearchElement> resultList){
        resultList.add(this);
    }
}
