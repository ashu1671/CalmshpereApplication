plugins {
    alias(libs.plugins.androidApplication)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.calmshperef1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.calmshperef1"
        minSdk = 34
        targetSdk = 34
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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

//    //Firebase
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.auth)

//    // Firebase-
//    implementation("com.google.android.gms:play-services-auth:19.0.0")
//    implementation("com.google.firebase:firebase-auth:20.0.2")
//    implementation("com.google.firebase:firebase-storage:19.2.1")
//    implementation("com.google.firebase:firebase-firestore:22.1.0")
//    implementation("com.firebaseui:firebase-ui-firestore:4.3.1")
//    implementation("com.google.firebase:firebase-messaging:17.3.4")
//
//    // Outside libraries
//    implementation("com.github.captain-miao:optroundcardview:1.0.0")
//    implementation("de.hdodenhof:circleimageview:3.1.0")
//    implementation("com.github.bumptech.glide:glide:4.12.0")


    // Firebase
    implementation("com.google.firebase:firebase-firestore:25.0.0")
    implementation("com.google.firebase:firebase-auth:23.0.0")
    implementation("com.google.firebase:firebase-storage:21.0.0")
    implementation("com.google.firebase:firebase-messaging:24.0.0")

    // FirebaseUI Firestore
    implementation("com.firebaseui:firebase-ui-firestore:8.0.0")

    // Google Play Services
    implementation("com.google.android.gms:play-services-auth:21.1.1")

    // External libraries
    implementation("com.github.captain-miao:optroundcardview:1.0.0")
    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation("com.github.bumptech.glide:glide:4.12.0")
//    implementation("com.theartofdev.edmodo:android-image-cropper:2.8.0")
    implementation("com.android.volley:volley:1.2.1")

// For payments
    implementation("com.razorpay:checkout:1.6.33")



}

