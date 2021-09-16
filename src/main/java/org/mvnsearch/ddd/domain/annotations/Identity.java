package org.mvnsearch.ddd.domain.annotations;

import java.lang.annotation.*;

/**
 * Declares a field of a class to constitute the identity of the corresponding class. Primarily used in
 * {@link DomainAggregate} and {@link DomainEntity} types.
 *
 * @author Oliver Drotbohm
 * @author Stephan Pirnbaum
 * @author Henning Schwentner
 * @see <a href="https://domainlanguage.com/wp-content/uploads/2016/05/DDD_Reference_2015-03.pdf">Domain-Driven Design
 * Reference (Evans) - Entities</a>
 * @since 1.3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Documented
public @interface Identity {
}