import griffon.util.ApplicationHolder
import griffon.core.GriffonApplication

onUncaughtBombException = { x ->
     ApplicationHolder.application.withMVCGroup('dialog') { m, v, c ->
        m.title = 'Somebody setup us the bomb!'
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