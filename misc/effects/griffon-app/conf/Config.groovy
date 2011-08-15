// log4j configuration
log4j {
    appender.stdout = 'org.apache.log4j.ConsoleAppender'
    appender.'stdout.layout'='org.apache.log4j.PatternLayout'
    appender.'stdout.layout.ConversionPattern'='[%r] %c{2} %m%n'
    appender.errors = 'org.apache.log4j.FileAppender'
    appender.'errors.layout'='org.apache.log4j.PatternLayout'
    appender.'errors.layout.ConversionPattern'='[%r] %c{2} %m%n'
    appender.'errors.File'='stacktrace.log'
    rootLogger='error,stdout'
    logger {
        griffon='error'
        StackTrace='error,errors'
        org {
            codehaus.griffon.commons='info' // core / classloading
        }
    }
    additivity.StackTrace=false
}

// The following properties have been added by the Upgrade process...
griffon.jars.pack=false // jars were not automatically packed in Griffon 0.0
griffon.jars.sign=true // jars were automatically signed in Griffon 0.0
griffon.extensions.jarUrls = [] // remote jars were not possible in Griffon 0.1
griffon.extensions.jnlpUrls = [] // remote jars were not possible in Griffon 0.1
// may safely be removed, but calling upgrade will restore it
def env = griffon.util.Environment.current.name
signingkey.params.sigfile='GRIFFON' + env
signingkey.params.keystore = "${basedir}/griffon-app/conf/keys/${env}Keystore"
signingkey.params.alias = env
// signingkey.params.storepass = 'BadStorePassword'
// signingkey.params.keyPass = 'BadKeyPassword'
signingkey.params.lazy = true // only sign when unsigned
// you may now tweak memory parameters
//griffon.memory.min='16m'
//griffon.memory.max='64m'
//griffon.memory.maxPermSize='64m'
