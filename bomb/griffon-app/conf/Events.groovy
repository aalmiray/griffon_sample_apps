import griffon.util.ApplicationHolder
import griffon.core.GriffonApplication

onUncaughtBombException = { x ->
    withMvcGroup('dialog') { m, v, c ->
        m.message = """
            Oops! An unexpected error occurred and we do not
            know what to do with it. However instead of
            crashing we thought you would like to know that
            the problem was caused by a
        
            $x
        
            Also, look at the logging information printed in
            your console.
        
            For great justice!
        """.stripIndent(12)
        c.show()
    }
}

withMvcGroup = { String type, Closure callback ->
    GriffonApplication app = ApplicationHolder.application
    try {
        callback(*app.createMVCGroup(type))
    } finally {
        app.destroyMVCGroup(type)
    }
}