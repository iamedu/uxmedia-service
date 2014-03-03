package com.iamedu.uxmedia;

import com.yammer.dropwizard.Service;

import com.yammer.dropwizard.assets.AssetsBundle;

import com.yammer.dropwizard.db.DatabaseConfiguration;

import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

import com.yammer.dropwizard.migrations.MigrationsBundle;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;

public class UXMediaService extends Service<UXMediaConfiguration> {
    public static void main(String[] args) throws Exception {
        new UXMediaService().run(args);
    }

    @Override
    public void initialize(Bootstrap<UXMediaConfiguration> bootstrap) {
        bootstrap.setName("ux-wall");
        bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/app/", "/", "index.html"));
        bootstrap.addBundle(new MigrationsBundle<UXMediaConfiguration>() {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(UXMediaConfiguration configuration) {
                return configuration.getDatabaseConfiguration();
            }
        });
    }

    @Override
    public void run(UXMediaConfiguration configuration,
            Environment environment) {
    }

}

