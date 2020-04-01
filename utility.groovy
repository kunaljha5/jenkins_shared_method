def getEnv (stage, environment){
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
