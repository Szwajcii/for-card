package com.forcard.core.shared.utils;

public interface MapperService<T, T1> {

    T simplifyToRestObject(T1 domain);

    T1 simplifyToDomainObject(T rest);

    T mapFromDomainObject(T1 domain, T rest);

    T1 mapToDomainObject(T1 domain, T rest);

}
