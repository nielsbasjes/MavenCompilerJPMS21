Testing JPMS

What?
===
I have a problem with a very basic JPMS application in Java 21.

Tests
====
Assumes you have toolchains setup with atleast Java 17 and 21.

I'm using Ubuntu 22.04 LTS

Java 17
===
run this

    mvn clean package -DUseJavaVersion=17

output:

    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------

Java 21
===
run this

    mvn clean package -DUseJavaVersion=21

output:

    [ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:testCompile (default-testCompile) on project jpms-test: Execution default-testCompile of goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:testCompile failed: Unsupported class file major version 65 -> [Help 1]

debug output:

    Caused by: java.lang.IllegalArgumentException: Unsupported class file major version 65
        at org.objectweb.asm.ClassReader.<init> (ClassReader.java:199)
        at org.objectweb.asm.ClassReader.<init> (ClassReader.java:180)
        at org.objectweb.asm.ClassReader.<init> (ClassReader.java:166)
        at org.objectweb.asm.ClassReader.<init> (ClassReader.java:287)
        at org.codehaus.plexus.languages.java.jpms.AsmModuleInfoParser.parse (AsmModuleInfoParser.java:51)
        at org.codehaus.plexus.languages.java.jpms.AbstractBinaryModuleInfoParser.getModuleDescriptor (AbstractBinaryModuleInfoParser.java:50)
        at org.codehaus.plexus.languages.java.jpms.AbstractBinaryModuleInfoParser.getModuleDescriptor (AbstractBinaryModuleInfoParser.java:38)
        at org.codehaus.plexus.languages.java.jpms.LocationManager.getMainModuleDescriptor (LocationManager.java:338)
        at org.codehaus.plexus.languages.java.jpms.LocationManager.resolvePaths (LocationManager.java:155)
        at org.apache.maven.plugin.compiler.TestCompilerMojo.preparePaths (TestCompilerMojo.java:257)
        at org.apache.maven.plugin.compiler.AbstractCompilerMojo.execute (AbstractCompilerMojo.java:854)
        at org.apache.maven.plugin.compiler.TestCompilerMojo.execute (TestCompilerMojo.java:199)
        at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:126)
        at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute2 (MojoExecutor.java:328)
        at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute (MojoExecutor.java:316)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:212)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:174)
        at org.apache.maven.lifecycle.internal.MojoExecutor.access$000 (MojoExecutor.java:75)
        at org.apache.maven.lifecycle.internal.MojoExecutor$1.run (MojoExecutor.java:162)
