eventRunAppEnd = {
println "${runtimeJars.collect {f -> f.absolutePath - jardir.absolutePath}.join(File.pathSeparator)}"
}
