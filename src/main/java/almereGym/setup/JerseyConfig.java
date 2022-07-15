package almereGym.setup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("restservices")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("almereGym.sporten.webservices","almereGym.setup","almereGym.sporten.Security");
        register(RolesAllowedDynamicFeature.class);
    }

}

