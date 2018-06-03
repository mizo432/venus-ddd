package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.Entities;
import org.venuspj.ddd.model.entity.Entity;
import org.venuspj.ddd.model.entity.EntityIdentifier;

import java.util.List;

public interface CrudRepository<E extends Entity<E>> {

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
    E resolve(EntityIdentifier<E> identifier);


    /**
     * 識別子に該当するエンティティをリポジトリから取得する。
     *
     * @param criteria 判断条件
     * @return エンティティ
     * @throws EntityNotFoundRuntimeException エンティティが見つからなかった場合
     * @throws RepositoryRuntimeException     リポジトリにアクセスできない場合
     */
    List<E> resolveAll(EntityCriteria<E> criteria);

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
     * @param entity 判断条件
     * @return 存在する場合はtrue
     * @throws RepositoryRuntimeException リポジトリにアクセスできない場合
     */
    boolean contains(E entity);

    /**
     * 指定した識別子のエンティティが存在するかを返す。
     *
     * @param identifier 判断条件
     * @return 存在する場合はtrue
     * @throws RepositoryRuntimeException リポジトリにアクセスできない場合
     */
    boolean contains(EntityIdentifier<E> identifier);

    /**
     * エンティティを保存する。
     *
     * @param entities 保存する対象のエンティティ
     * @throws RepositoryRuntimeException リポジトリにアクセスできない場合
     */
    void store(Entities<E> entities);

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
    void delete(Entities<E> entities);

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
    void delete(EntityIdentifier<E> identifier);

    /**
     * 指定した識別子のエンティティを削除する。
     *
     * @param entity エンティティ
     * @throws IllegalArgumentException       複数件のエンティティが返された場合
     * @throws EntityNotFoundRuntimeException 指定された識別子を持つエンティティが見つからなかった場合
     * @throws RepositoryRuntimeException     リポジトリにアクセスできない場合
     */
    void delete(E entity);
}
