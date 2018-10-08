### Build e deploy

Para realizar rodar os testes,  *build* e gerar uma imagem docker da aplicação execute o comando

```
./mvnw install dockerfile:build
```

Para subir a aplicação execute

```
docker-compose up
```

### API

```
http://localhost:8080/tracks?city=Campinas
```

ou

```
http://localhost:8080/tracksByCoordinates?lat=51.508530&lon=-0.076132
```

### Detalhes de implementação

- Feign e Hystrix foram utilizados pois facilitam a comunicação com outros microserviços e providenciam fallbacks
caso necessário (Hystrix).
- Utilizado Redis pra cache das requisições vindas do spotify, pois:
    - requisições serão em grande parte repetidas (temos apenas 5 tipos de playlists)
    - API do spotify as vezes é lenta.
- Utilizado spring-cloud-starter-oauth2 para configurar obtenção do token oauth para o serviço do spotify. Como consequencia
é necessário criar uma configuração mínima para o WebSecurity


### Problemas conhecidos
- Resultado do fallback do PlaylistClient (spotify) está sendo cacheado
