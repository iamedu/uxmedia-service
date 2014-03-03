package com.iamedu.uxmedia.data;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

public interface UserDAO {
    @SqlUpdate("insert into people (username, password) values (:username, :password)")
    void insert(@Bind("username") String username, @Bind("password") String password);

    @SqlQuery("select password from people where username = :username")
    String findPasswordByUsername(@Bind("username") String username);
}
