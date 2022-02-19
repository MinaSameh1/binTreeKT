# binTreeKT

This is a quick implementation of a binary tree in kotlin to try out github actions and release a lib.

To use this package in your project add this to your `gradle.build.kts` file

you can use JIT then:
[![](https://jitpack.io/v/MinaSameh1/binTreeKT.svg)](https://jitpack.io/#MinaSameh1/binTreeKT)

```kt
repositories {
  maven{
    url = uri("https://jitpack.io")
  }
}
dependencies {
    implementation("com.github.MinaSameh1:binTreeKT:VERSION")
		// You can use this for main branch it will build the package
    //implementation("com.github.MinaSameh1:binTreeKT:main-SNAPSHOT")
}
```

If you don't want to use JIT then:
```kt 
repositories {
    maven {
        name = "GitHubPackages"
				// Repo Link
        url = uri("https://maven.pkg.github.com/MinaSameh1/binTreeKT")
        credentials {
            username = System.getenv("GITHUB_PACKAGES_USERID") ?: "MinaSameh1"
            // Safe to share the password since it is a `read:package` scoped token.
            password = System.getenv("GITHUB_PACKAGES_IMPORT_TOKEN") ?: "READ:PACKAGE from DEV SETTINGS"
        }
    }
}

dependencies {
		// implementation("groupId:artifactId:version")
		// This is an example, check the pom from released packages
    implementation("QuickBinTreeTest:lib:0.1.3") // EXAMPLE
}
```

*Small Note: I know the key is supposed to be safe to share However I don't feel comfortable leaving a key out in the open even if its just read:packages permssions, and since this is a small Project just to test something out I won't put out a key, I left this info however to help others if they want to release their own package.*

## Refrences

1. [github offical docs on releasing gradle package](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry)
2. [Developerlife article](https://developerlife.com/2021/02/06/publish-kotlin-library-as-gradle-dep/)
3. [Understanding Gradle](https://www.youtube.com/watch?v=8z5KFCLZDd0)
