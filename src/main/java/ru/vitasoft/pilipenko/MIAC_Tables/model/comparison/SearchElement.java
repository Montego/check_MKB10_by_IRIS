package ru.vitasoft.pilipenko.MIAC_Tables.model.comparison;

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
    public Comparable comparisonValue1;
    public Comparable comparisonValue2;
    public Integer operation;
    public String parentPropertyName;

}
