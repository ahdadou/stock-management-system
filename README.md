# USING CONSUL AS DISCOVERY

#### RUN CMD
    consul  agent  -server  -bootstrap-expect=1  -data-dir=consul-data  -ui  -bind=192.168.197.138consul  agent  -server  -bootstrap-expect=1  -data-dir=consul-data  -ui  -bind=192.168.197.138
#### dependencies
For microservices you should add :

    implementation 'org.springframework.cloud:spring-cloud-starter-consul-discovery'  

# USING CONSUL AS CONFIG

#### dependencies

    implementation 'org.springframework.cloud:spring-cloud-starter-consul-config'
#### yaml

    spring:  
	   application:  
		    name: suppliers  
	   config:  
		    import: optional:consul:http://192.168.197.138:8500

# USING VAULT  AS CONFIG

#### RUN CMD "dev"

    vault server -dev
    
#### dependencies 

    implementation 'org.springframework.cloud:spring-cloud-starter-vault-config'

#### yaml

    spring:  
      cloud.vault:  
        token: hvs.M45WEW4CxHXTG1wTvVMvxzMW  
        scheme: http  
        kv.enabled: true  
      config.import: vault://

#### some cmd exemples

for add a new secrect key=value

    vault kv put secret/api-suppliers user.username=brahim user.password=123456
