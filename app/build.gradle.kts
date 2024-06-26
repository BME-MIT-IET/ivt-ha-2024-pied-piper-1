plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")//linking to firebase
}

android {
    namespace = "com.example.mypractice"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.mypractice"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            enableUnitTestCoverage = true
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
        viewBinding =  true
    }
}

dependencies {

    //firebase bom
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))

    implementation("com.google.firebase:firebase-analytics-ktx")

    //add depeendencies for firebase products
    implementation ("com.google.firebase:firebase-auth:21.0.1") //authentication
    implementation ("com.google.firebase:firebase-firestore-ktx")//firestore
    implementation ("com.google.firebase:firebase-storage:20.0.0")//storage
    implementation ("com.google.firebase:firebase-messaging:23.0.0")//cloud messaging
    implementation ("com.firebaseui:firebase-ui-auth:8.0.0")//UI
    implementation ("com.firebaseui:firebase-ui-firestore:8.0.0")


    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    implementation("androidx.test.espresso:espresso-intents:3.5.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation( "junit:junit:4.13")
    testImplementation ("org.robolectric:robolectric:4.5.1")
    testImplementation ("org.mockito:mockito-core:3.11.2")
    testImplementation ("org.mockito:mockito-android:3.11.2")
    testImplementation ("org.mockito:mockito-inline:3.11.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test:rules:1.4.0")



}