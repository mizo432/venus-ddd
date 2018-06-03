package org.venuspj.ddd.model.entity;

import org.venuspj.util.objects2.Objects2;

import java.util.UUID;

/**
 * {@link EntityIdentifier}のデフォルト実装。
 *
 * @param <T> エンティティの型。コンパイル時のみ利用。
 */
public final class DefaultEntityIdentifier<T extends Entity<T>> extends AbstractEntityIdentifier<T> implements EntityIdentifier<T> {

    private UUID uuid;

    /**
     * インスタンスを生成する。
     *
     * @param anEntityClass エンティティクラス。カインドにはFQCNが設定される。
     * @param anUuid        UUID
     * @return {@link DefaultEntityIdentifier}
     */
    public DefaultEntityIdentifier(Class<T> anEntityClass, UUID anUuid) {
        this(anEntityClass.getName(), anUuid);
    }

    /**
     * インスタンスを生成する。
     *
     * @param aKind  カインド
     * @param anUuid {@link UUID}
     */
    public DefaultEntityIdentifier(String aKind, UUID anUuid) {
        super(aKind);
        uuid = anUuid;
    }

    public String getKind() {
        return kind;
    }

    public UUID toUUID() {
        return uuid;
    }

    @Override
    public int hashCode() {
        return Objects2.hash(kind, uuid);
    }

    @Override
    public boolean sameValueAs(EntityIdentifier<T> other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o instanceof DefaultEntityIdentifier == false) {
            return false;
        }
        DefaultEntityIdentifier that = (DefaultEntityIdentifier) o;
        if (!Objects2.equal(kind, that.kind)) return false;
        if (!Objects2.equal(uuid, that.uuid)) return false;
        return true;
    }
}
