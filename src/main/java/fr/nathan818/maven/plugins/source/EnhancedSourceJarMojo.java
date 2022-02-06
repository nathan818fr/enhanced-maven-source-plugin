package fr.nathan818.maven.plugins.source;

import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "jar", defaultPhase = LifecyclePhase.PACKAGE, threadSafe = true)
@Execute(phase = LifecyclePhase.GENERATE_SOURCES)
public class EnhancedSourceJarMojo extends EnhancedSourceJarNoForkMojo {}
