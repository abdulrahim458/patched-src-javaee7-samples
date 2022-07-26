withMaven(jdk: CFG.jdk, options: [artifactsPublisher(disabled: true)]) {
    sh """mvn -B -V -ff -e clean install --strict-checksums \
                -Djavax.net.ssl.trustStore=${env.JAVA_HOME}/jre/lib/security/cacerts \
                -Djavax.xml.accessExternalSchema=all -Dpayara.version=${CFG.'build.version'} \
                -Dpayara_domain=${CFG.domain_name} \
                -Duse.cnHost=true -Dsurefire.useFile=false \
                -Ppayara-server-remote,stable,payara4"""
}