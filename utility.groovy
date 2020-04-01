def getEnv (stage, environment){
    //a="dev-med"
    //a="dev.example.com"
    //a="prod.example.com"
    //a=getEnv("", a)
    //println(a)
    if(stage){
        println(stage)
    }
    else {
        switch(environment) {
            case ~/^dev-.*$/:
                return "dev-example-01"; 
                break; 
            case ~/^dev.example.com$/: 
                return "dev.example.com"; 
                break;
            case ~/^test-.*$/: 
                return "test-example-01"; 
                break; 
            case ~/prod.example.com/: 
                return "prod.example.com"; 
                break; 
            default: 
                return "FAILED"; 
                break; 
        }
    }
}

def setupHelm (helmVersion) {
    if(helmVersion) {
        sh(returnStdout: true,
           script: """
             echo "getting helm"
             curl -o helm.tar.gz -ks "https://get.helm.sh/helm-${helmVersion}-linux-arm.tar.gz" && \\
             tar -xzvf helm.tar.gz linux-amd64/helm -C . && \\
             rm -rf helm.tar.gz && \\
             mv linux-amd64/helm /usr/bin/helm && \\
             chmod +x /usr/bin/helm && \\
             echo "helm setup completed"
           """)
    }
}

helmVersion="v2.16.5"
setupHelm(helmVersion)



