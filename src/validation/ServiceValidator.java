package validation;

public interface ServiceValidator<T> {
    void canAccess(T object);

    void canCreate(T object);

    void canUpdate(T object);

    void canDelete(T object);
}
