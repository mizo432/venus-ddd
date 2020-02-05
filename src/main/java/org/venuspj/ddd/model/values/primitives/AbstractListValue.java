package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractSingleValue;
import org.venuspj.util.exception.NotSupportedMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.venuspj.util.collect.Lists2.newArrayList;
import static org.venuspj.util.collect.Lists2.unmodifiableList;
import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

public abstract class AbstractListValue<E, ALV extends AbstractListValue<E, ALV>> extends AbstractSingleValue<List<E>, ALV> implements ListValue<E, ALV> {

    protected AbstractListValue() {
        value = newArrayList();
    }

    protected AbstractListValue(Collection<? extends E> anyCollection) {
        this();
        value.addAll(anyCollection);

    }

    @Override
    public List<E> asList() {
        return unmodifiableList(value);

    }

    public Iterator<E> iterator() {
        return value.iterator();
    }

    @Override
    public List<E> getValue() {
        return value;
    }

    @Override
    public int compareTo(ALV o) {
        throw new NotSupportedMethod(this.getClass().getCanonicalName() + "#compareTo(" + o.getClass().getSimpleName() + ")");
    }

    @Override
    public boolean sameValueAs(ALV that) {
        if (this == that) return true;
        if (isNull(that)) return false;
        if (size() != that.size())
            return false;
        for (int index = 0; index < value.size(); index++) {
            if (!equal(value.get(index), that.value.get(index)))
                return false;
        }
        return true;
    }

    protected int size() {
        return value.size();

    }

    /**
     * 判定子を元に合致する物を検索する。
     *
     * @param aPredicate 判定子
     * @return 検索結果
     * @throws ItemNotFoundRuntimeException 見つからない場合に本例外を投げる
     */
    public E findBy(Predicate<E> aPredicate) {
        return findBy(aPredicate, ItemNotFoundRuntimeException::new);

    }

    /**
     * 判定子を元に合致するアイテムを検索する。
     * <pre>
     * 存在しない場合は実行時例外供給子から取得した例外を投げる。
     *
     * </pre>
     *
     * @param aPredicate                判定子
     * @param aRuntimeExceptionSupplier 実行時例外供給子
     * @return 検索結果
     */
    public E findBy(Predicate<E> aPredicate, Supplier<RuntimeException> aRuntimeExceptionSupplier) {
        return value
                .stream()
                .filter(aPredicate)
                .findFirst()
                .orElseThrow(aRuntimeExceptionSupplier);

    }

    protected ArrayList<E> selectBy(Predicate<E> aPredicate) {
        return value
                .stream()
                .filter(aPredicate)
                .collect(Collectors
                        .toCollection(ArrayList::new));

    }

}
