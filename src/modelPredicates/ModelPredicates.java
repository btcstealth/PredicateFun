package modelPredicates;

import java.util.List;
import java.util.function.Predicate;

public interface ModelPredicates<T> {
    List<T> filter (List<T> collection, Predicate<T> predicate);
}
