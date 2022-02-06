package fr.nathan818.maven.plugins.source;

import java.util.ArrayList;
import java.util.List;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.source.SourceJarNoForkMojo;
import org.apache.maven.project.MavenProject;

@Mojo(name = "jar-no-fork", defaultPhase = LifecyclePhase.PACKAGE, threadSafe = true)
public class EnhancedSourceJarNoForkMojo extends SourceJarNoForkMojo {

    @Parameter(property = "excludeDefaultSources")
    protected boolean excludeDefaultSources;

    @Parameter(property = "sources")
    protected List<String> sources;

    @Override
    protected List<String> getSources(MavenProject p) {
        List<String> ret = new ArrayList<>();
        if (sources != null) {
            ret.addAll(sources);
        }
        if (!excludeDefaultSources) {
            ret.addAll(super.getSources(p));
        }
        getLog().info("Sources: " + join(", ", ret));
        return ret;
    }

    private static String join(String separator, List<String> elements) {
        StringBuilder ret = new StringBuilder();
        boolean first = true;
        for (String e : elements) {
            if (first) {
                first = false;
            } else {
                ret.append(separator);
            }
            ret.append(e);
        }
        return ret.toString();
    }
}
