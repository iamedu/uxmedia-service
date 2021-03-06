package com.iamedu.uxmedia;

import com.iamedu.uxmedia.data.*;
import com.iamedu.uxmedia.service.*;

import com.yammer.dropwizard.Service;

import com.yammer.dropwizard.assets.AssetsBundle;

import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.jdbi.DBIFactory;

import com.yammer.dropwizard.jdbi.bundles.DBIExceptionsBundle;

import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

import com.yammer.dropwizard.migrations.MigrationsBundle;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.Hazelcast;

import org.skife.jdbi.v2.DBI;

public class UXMediaService extends Service<UXMediaConfiguration> {

    public static void main(String[] args) throws Exception {
        new UXMediaService().run(args);
    }

    @Override
    public void initialize(Bootstrap<UXMediaConfiguration> bootstrap) {
        bootstrap.setName("ux-wall");
        
        bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/app/", "/", "index.html"));
        bootstrap.addBundle(new DBIExceptionsBundle());
        bootstrap.addBundle(new MigrationsBundle<UXMediaConfiguration>() {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(UXMediaConfiguration configuration) {
                return configuration.getDatabaseConfiguration();
            }
        });
    }

    @Override
    public void run(UXMediaConfiguration config,
            Environment environment) throws ClassNotFoundException {
        final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(null);
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDatabaseConfiguration(), "postgresql");
        final UserDAO userDao = jdbi.onDemand(UserDAO.class);
        final UserService userService = new UserService(userDao);


    }

}

