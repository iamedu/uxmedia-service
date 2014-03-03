package com.iamedu.uxmedia;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.config.Configuration;

import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;

import javax.validation.constraints.NotNull;
import javax.validation.Valid;

public class UXMediaConfiguration extends Configuration implements AssetsBundleConfiguration {

    @Valid
    @NotNull
    @JsonProperty
    private final AssetsConfiguration assets = new AssetsConfiguration();

    @Valid
    @NotNull
    @JsonProperty
    private DatabaseConfiguration database = new DatabaseConfiguration();

    public DatabaseConfiguration getDatabaseConfiguration() {
        return database;
    }

    @Override
    public AssetsConfiguration getAssetsConfiguration() {
        return assets;
    }
}
