plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.kycdemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kycdemo"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
    configurations {
        all {
            exclude(module = "bcprov-jdk15to18")
            exclude(module = "bcutil-jdk18on")
            exclude(module = "bcprov-jdk15on")
            exclude(module = "bcutil-jdk15on")

            resolutionStrategy {
                force("org.web3j:abi:5.0.0")
            }
        }
    }

    dependencies {

        val room_version = "2.5.1"

        // implementation("androidx.core:core-ktx:1.13.1")
        //  implementation("androidx.appcompat:appcompat:1.7.0-beta01")
        implementation("androidx.core:core-ktx:1.10.1")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

        implementation("com.google.android.material:material:1.9.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
        implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
        implementation("androidx.legacy:legacy-support-v4:1.0.0")
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
        implementation("androidx.databinding:databinding-runtime:8.0.1")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

        //Dagger hilt
        implementation("com.google.dagger:hilt-android:2.46.1")
        kapt("com.google.dagger:hilt-android-compiler:2.46.1")

        //Retrofit
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")


        //LifeCycle

        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

        implementation("androidx.lifecycle:lifecycle-common-java8:2.6.1")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
        implementation("android.arch.lifecycle:extensions:1.1.1")
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

        //Dagger hilt
        implementation("com.google.dagger:hilt-android:2.46.1")
        kapt("com.google.dagger:hilt-android-compiler:2.46.1")

        implementation("com.tbuonomo:dotsindicator:5.0")
        //qrcode
        implementation("cash.z.ecc.android:kotlin-bip39:1.0.4")

        //Retrofit
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")


        //Room Database
        implementation("androidx.room:room-runtime:$room_version")
        kapt("androidx.room:room-compiler:$room_version")
        implementation("androidx.room:room-ktx:$room_version")

        implementation("de.hdodenhof:circleimageview:3.1.0")

        //Trust Wallet
        // implementation "com.trustwallet:wallet-core:3.1.29"


        //QR Coder Generator and scanner
        implementation("com.journeyapps:zxing-android-embedded:4.3.0")

        //Glide
        implementation("com.github.bumptech.glide:glide:4.15.1")
        kapt("com.github.bumptech.glide:compiler:4.13.2")
        //  implementation 'com.github.bumptech.glide:okhttp3-integration:4.15.1'
        //  implementation 'com.github.bumptech.glide:glide-svg:4.15.1'

        //chart
        implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")

        //biometric login
        implementation("androidx.biometric:biometric-ktx:1.2.0-alpha05")

        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
        implementation("androidx.activity:activity-ktx:1.4.0")
        implementation("com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava")
        implementation("com.google.android.gms:play-services-drive:17.0.0")

        //firebase auth
        implementation("com.google.firebase:firebase-auth-ktx:22.0.0")
        implementation("com.google.android.gms:play-services-auth:20.5.0")

        //gson
        implementation("com.google.code.gson:gson:2.9.1")

        //Lottie Animat("")on
        implementation("com.airbnb.android:lottie:5.2.0")


        implementation("io.github.g00fy2.quickie:quickie-bundled:1.7.0")

        implementation("com.github.Dimezis:BlurView:version-2.0.3")

        implementation("com.github.SumiMakito:AwesomeQRCode:1.2.0")

        implementation("com.caverock:androidsvg:1.4")

        //showcase view
        implementation("com.github.amlcurran.showcaseview:library:5.4.3")

        // Import the BoM for the Firebase platform
        implementation(platform("com.google.firebase:firebase-bom:32.3.1"))

        // Add the dependencies for the Crashlytics and Analytics libraries
        // When using the BoM, you don't specify versions in Firebase library dependencies
        implementation("com.google.firebase:firebase-crashlytics-ktx")

        //create wallet library
        implementation("com.github.coingrig:cgwallet-android-artifact:0.1.6")

        implementation("com.github.stacrypt:krypto-address-validator:0.0.1")

        implementation("androidx.browser:browser:1.8.0")

        implementation("org.bitcoinj:bitcoinj-core:0.16.2")

        implementation("net.zetetic:android-database-sqlcipher:4.5.3")
        implementation("androidx.sqlite:sqlite-ktx:2.4.0")

        //Compose
        implementation("androidx.navigation:navigation-compose:2.7.7")
        implementation("androidx.compose.ui:ui-android:1.6.4")
        implementation("androidx.compose.ui:ui:1.6.4")
        implementation("androidx.compose.material:material:1.6.4")
        implementation("androidx.compose.ui:ui-tooling-preview:1.6.4")
        implementation("androidx.activity:activity-compose:1.8.2")
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
        implementation("androidx.compose.runtime:runtime:1.6.4")

        //Connect wallet
        implementation(platform("com.walletconnect:android-bom:1.31.3")) {

        }
        implementation("com.walletconnect:android-core")
        implementation("com.walletconnect:web3wallet")
        implementation("com.walletconnect:notify")

        // Ensure the specific version you want is included
        implementation("org.web3j:abi:5.0.0")

        // implementation("org.web3j:abi:5.0.0")

        //web3j
        // implementation 'org.web3j:core:4.8.7-android'
        implementation("org.web3j:core:5.0.0")
        //implementation 'org.web3j:core:5.0.0'

        // Koin for Kotlin apps
        implementation("io.insert-koin:koin-core:3.4.2")
        implementation("io.insert-koin:koin-android:3.4.2")
        implementation("io.insert-koin:koin-android-compat:3.2.0") {
            exclude(group = "org.jetbrains.kotlin", module = "kotlin-reflect")
        }

        // Add Kotlin Reflect if needed
        implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.0")

        implementation("com.github.komputing.Khash:ripemd160:1.1.1") {

        }

        // Glide
        implementation("com.github.skydoves:landscapist-glide:2.1.0")
        implementation("io.coil-kt:coil:2.4.0")

        // MixPanel
        implementation("com.mixpanel.android:mixpanel-android:7.3.1")
        implementation("androidx.webkit:webkit:1.9.0")

        // ReactiveX
        implementation("io.reactivex.rxjava2:rxjava:2.2.21")
        implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
        implementation("com.github.salomonbrys.kotson:kotson:2.5.0")

        //pinView
        implementation("com.chaos.view:pinview:1.4.4")

        //spinner
        implementation("com.github.skydoves:powerspinner:1.2.7")

        implementation("com.github.komputing.kethereum:ens:0.86.0")
        implementation("com.github.komputing.kethereum:rpc:0.86.0")

        //Showing shimmer effect
        implementation("com.facebook.shimmer:shimmer:0.5.0")

        //Card KYC monitor
        implementation("com.kyc.ondato:sdk:2.5.4")


        implementation("com.appsflyer:af-android-sdk:6.12.4")
        implementation("com.android.installreferrer:installreferrer:2.2")

        implementation("com.kyc.ondato:sdk:2.5.4")


    }
}