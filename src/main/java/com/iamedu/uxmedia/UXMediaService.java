package com.iamedu.uxmedia;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class UXMediaService extends Service<UXMediaConfiguration> {
    public static void main(String[] args) throws Exception {
        new UXMediaService().run(args);
    }

    @Override
    public void initialize(Bootstrap<UXMediaConfiguration> bootstrap) {
        bootstrap.setName("ux-wall");
    }

    @Override
    public void run(UXMediaConfiguration configuration,
                    Environment environment) {
    }

}

