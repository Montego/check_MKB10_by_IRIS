package ru.vitasoft.pilipenko.MIAC_Tables.repository.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertBirth;
import ru.vitasoft.pilipenko.MIAC_Tables.model.comparison.SearchElement;

import javax.persistence.criteria.*;


public class MedCertsSpecification {
    private enum Operations{
        EQUAL,
        LIKE,
        BETWEEN,
        GREATER,
        LESS,
        START
    }

    public static Specification<MedCertBirth> whereAndStart(){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.and();
    }

    public static Specification<MedCertBirth> addSearchElement(final SearchElement searchElement){

        return (Specification<MedCertBirth>) (root, criteriaQuery, criteriaBuilder) -> {

            Expression path;
            Operations curOperation;

            if ("".equals(searchElement.parentPropertyName)){
                path    = root.get(searchElement.propertyName);
            }else{
                path    = root.get(searchElement.parentPropertyName).get(searchElement.propertyName);
            }

            curOperation = Operations.values()[searchElement.operation-1];

            switch (curOperation){
                case EQUAL:
                    return criteriaBuilder.equal(path,searchElement.comparisonValue1);
                case LIKE:
                    return criteriaBuilder.like(path,"%" + searchElement.comparisonValue1.toString() + "%");
                case BETWEEN:
                    return criteriaBuilder.between(path, searchElement.comparisonValue1, searchElement.comparisonValue2);
                case GREATER:
                    return criteriaBuilder.greaterThanOrEqualTo(path,searchElement.comparisonValue1);
                case LESS:
                    return criteriaBuilder.lessThanOrEqualTo(path,searchElement.comparisonValue1);
                case START:
                    return criteriaBuilder.like(path, searchElement.comparisonValue1.toString() + "%");
                default:
                    return criteriaBuilder.and();
            }
        };
    }
}
