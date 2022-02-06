# Enhanced Maven Source Plugin

A fork of the Maven Source Plugin with more options.

## Example Configuration

```xml
<plugin>
  <groupId>fr.nathan818.maven.plugins</groupId>
  <artifactId>enhanced-maven-source-plugin</artifactId>
  <executions>
    <execution>
      <phase>package</phase>
      <goals>
        <goal>jar-no-fork</goal>
      </goals>
    </execution>
  </executions>
  <configuration>
    <excludeDefaultSources>true</excludeDefaultSources>
    <sources>
      <source>${project.build.directory}/delombok</source>
    </sources>
  </configuration>
</plugin>
```
