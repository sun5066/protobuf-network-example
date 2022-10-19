import com.google.protobuf.gradle.id

plugins {
    java
    idea
    kotlin("jvm") version "1.5.30"
    id("com.google.protobuf") version "0.9.1"
}

group = "com.github.sun5066"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.grpc:grpc-netty-shaded:1.49.2")
    implementation("io.grpc:grpc-protobuf:1.49.2")
    implementation("io.grpc:grpc-stub:1.49.2")
    implementation("com.google.protobuf:protobuf-kotlin:3.21.7")
    compileOnly("org.apache.tomcat:annotations-api:6.0.53")

    implementation("io.netty:netty-all:4.1.63.Final")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

sourceSets {
    main {
        proto {
            // In addition to the default 'src/main/proto'
            srcDir("src/main/protobuf")
            srcDir("src/main/protocolbuffers")
            // In addition to the default '**/*.proto' (use with caution).
            // Using an extension other than 'proto' is NOT recommended,
            // because when proto files are published along with class files, we can
            // only tell the type of a file from its extension.
            include("**/*.protodevel")
        }
    }
    test {
        proto {
            // In addition to the default 'src/test/proto'
            srcDir("src/test/protocolbuffers")
        }
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.21.7"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.49.2"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
            }
            it.builtins {
                id("kotlin")
            }
        }
    }
}

idea {
    module {
        sourceDirs.plus(file("${projectDir}/build/generated/source/proto/main/java"))
        sourceDirs.plus(file("${projectDir}/build/generated/source/proto/main/grpc"))
    }
}