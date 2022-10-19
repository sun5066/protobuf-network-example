import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.proto

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.protobuf")
    idea
}

android {
    namespace = "com.github.sun5066.protobuf_client"
    compileSdk = 32

    defaultConfig {
        applicationId = "com.github.sun5066.protobuf_client"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/INDEX.LIST"
            excludes += "google/protobuf/*.proto"
        }
    }
    sourceSets {
        getByName("main") {
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
        getByName("test") {
            proto {
                // In addition to the default 'src/test/proto'
                srcDir("src/test/protocolbuffers")
            }
        }
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.21.7"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.50.0"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
            }
            it.builtins {
                id("java")
                id("kotlin")
            }
        }
    }
}

dependencies {
    
    val composeVersion = "1.1.1"
    val lifecycleVersion = "2.6.0-alpha01"
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.material:material:1.1.1")

    implementation("io.netty:netty-all:4.1.63.Final")

    implementation("io.grpc:grpc-okhttp:1.50.0")
    implementation("io.grpc:grpc-protobuf:1.50.0")
    implementation("io.grpc:grpc-stub:1.50.0")
    implementation("com.google.protobuf:protobuf-kotlin:3.21.7")
    compileOnly("org.apache.tomcat:annotations-api:6.0.53")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
}

idea {
    module {
        sourceDirs.plus(file("${projectDir}/build/generated/source/proto/main/java"))
        sourceDirs.plus(file("${projectDir}/build/generated/source/proto/main/grpc"))
    }
}