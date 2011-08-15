Sample Griffon application that demonstrates the usage of the UncaughtException
handler event mechanism. An exception is triggered by a controller action, it's
then caught by the framework and published as an event. There's an event handler
that pops out a dialog with further information. The exception is also logged to
the console automatically.
