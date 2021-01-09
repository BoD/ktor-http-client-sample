enableFeaturePreview("GRADLE_METADATA")

rootProject.name = "ktor-http-client-sample"

include(":library")

// Include all the sample modules from the "samples" directory
file("samples").listFiles()!!.forEach { dir ->
    include(dir.name)
    project(":${dir.name}").projectDir = dir
}
