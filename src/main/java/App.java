import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
/**
 * Created by rapa on 12/05/18.
 */
public class App extends Application<SampleConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }


    @Override
    public void initialize(Bootstrap<SampleConfiguration> myConfigurationBootstrap) {
        myConfigurationBootstrap.addBundle(new ConfiguredAssetsBundle("/assets", "/", "index.html"));
    }

    public void run(SampleConfiguration sampleConfiguration, Environment environment) throws Exception {
        environment.jersey().setUrlPattern("/api/*");
        environment.jersey().register(new SupportResource());
    }



}
