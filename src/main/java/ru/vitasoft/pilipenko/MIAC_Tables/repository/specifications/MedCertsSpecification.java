package ru.vitasoft.pilipenko.MIAC_Tables.repository.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.vitasoft.pilipenko.MIAC_Tables.domain.model.MedCertBirth;
import ru.vitasoft.pilipenko.MIAC_Tables.model.comparison.SearchElement;

import javax.persistence.Convert;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.time.LocalDateTime;

import static java.lang.Integer.parseInt;


public class MedCertsSpecification {

    public static Specification<MedCertBirth> whereAndStart(){
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.and();
    }

    public static Specification<MedCertBirth> addSearchElement(final SearchElement searchElement){

        return new Specification<MedCertBirth>() {
            @Override
            public Predicate toPredicate(Root<MedCertBirth> r, CriteriaQuery<?> cq, CriteriaBuilder cb) {

                switch (searchElement.operation){
                    case 1:
                        return cb.equal(r.get(searchElement.propertyName),searchElement.comparisonValue1);
                    case 2:
                        return cb.like(r.get(searchElement.propertyName),"%" + searchElement.comparisonValue1.toString() + "%");
                    case 3:

                        System.out.println(searchElement.comparisonValue1.getClass().toString());
                        System.out.println(searchElement.comparisonValue1.toString());
                        System.out.println(searchElement.comparisonValue2.toString());

                        return cb.between(r.get(searchElement.propertyName),
                                (LocalDateTime) LocalDateTime.parse(searchElement.comparisonValue1.toString()),
                                (LocalDateTime) LocalDateTime.parse(searchElement.comparisonValue2.toString()));
                    case 4:
                        return cb.greaterThanOrEqualTo(r.get(searchElement.propertyName),(Comparable) searchElement.comparisonValue1);
                    case 5:
                        return cb.lessThanOrEqualTo(r.get(searchElement.propertyName),(Comparable) searchElement.comparisonValue1);
                    case 6:
                        return cb.like(r.get(searchElement.propertyName), searchElement.comparisonValue1.toString() + "%");
                    default:
                        return cb.and();
                }
            }
        };
        //return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("firstName"),firstName);
    }

    public static Specification<MedCertBirth> byLastName(final String lastName,final  Integer operation){
        if (operation == 1){
            return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("lastName"),lastName);
        }else{
            return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("lastName"),"%" + lastName + "%");
        }
    }





}
