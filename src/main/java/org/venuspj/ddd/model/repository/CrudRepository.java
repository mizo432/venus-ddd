package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.Entity;
import org.venuspj.ddd.model.entity.EntityIdentifier;
import org.venuspj.ddd.model.value.ListValue;

import java.util.Collection;

public interface CrudRepository<E extends Entity<E, EI>, EI extends EntityIdentifier<E, EI>> {

    /**
     * 識別子に該当するエンティティをリポジトリから取得する。
     *
     * @param criteria 判断条件
     * @return エンティティ
     * @throws EntityNotFoundRuntimeException エンティティが見つからなかった場合
     * @throws RepositoryRuntimeException     リポジトリにアクセスできない場合
     */
    E resolve(EntityCriteria<E> criteria);

    /**
     * 識別子に該当するエンティティをリポジトリから取得する。
     *
     * @param identifier 判断条件
     * @return エンティティ
     * @throws EntityNotFoundRuntimeException エンティティが見つからなかった場合
     * @throws RepositoryRuntimeException     リポジトリにアクセスできない場合
     */
    E resolve(EI identifier);


    /**
     * 識別子に該当するエンティティをリポジトリから取得する。
     *
     * @param criteria 判断条件
     * @return エンティティ
     * @throws EntityNotFoundRuntimeException エンティティが見つからなかった場合
     * @throws RepositoryRuntimeException     リポジトリにアクセスできない場合
     */
    Collection<E> resolveAll(EntityCriteria<E> criteria);

    /**
     * 指定した識別子のエンティティが存在するかを返す。
     *
     * @param criteria 判断条件
     * @return 存在する場合はtrue
     * @throws RepositoryRuntimeException リポジトリにアクセスできない場合
     */
    boolean contains(EntityCriteria<E> criteria);

    /**
     * 指定した識別子のエンティティが存在するかを返す。
     *
     * @param identifier 判断条件
     * @return 存在する場合はtrue
     * @throws RepositoryRuntimeException リポジトリにアクセスできない場合
     */
    boolean contains(EI identifier);

    /**
     * エンティティを保存する。
     *
     * @param entities 保存する対象のエンティティ
     * @throws RepositoryRuntimeException リポジトリにアクセスできない場合
     */
    void store(ListValue<E> entities);

    /**
     * エンティティを保存する。
     *
     * @param entity 保存する対象のエンティティ
     * @throws RepositoryRuntimeException リポジトリにアクセスできない場合
     */
    void store(E entity);

    /**
     * 指定したエンティティを削除する。
     *
     * @param entities エンティティ
     * @throws EntityNotFoundRuntimeException 指定された識別子を持つエンティティが見つからなかった場合
     * @throws RepositoryRuntimeException     リポジトリにアクセスできない場合
     */
    void delete(ListValue<E> entities);

    /**
     * 指定した識別子のエンティティを削除する。
     *
     * @param criteria 判断条件
     * @throws IllegalArgumentException       複数件のエンティティが返された場合
     * @throws EntityNotFoundRuntimeException 指定された識別子を持つエンティティが見つからなかった場合
     * @throws RepositoryRuntimeException     リポジトリにアクセスできない場合
     */
    void delete(EntityCriteria<E> criteria);

    /**
     * 指定した識別子のエンティティを削除する。
     *
     * @param identifier 判断条件
     * @throws IllegalArgumentException       複数件のエンティティが返された場合
     * @throws EntityNotFoundRuntimeException 指定された識別子を持つエンティティが見つからなかった場合
     * @throws RepositoryRuntimeException     リポジトリにアクセスできない場合
     */
    void delete(EI identifier);

}
