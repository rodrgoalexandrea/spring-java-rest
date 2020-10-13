# spring-java-rest

Dentro da pasta raiz do projeto executar o seguinte comando:
	mvnw spring-boot:run

Para realização dos testes deve ser passado json nos seguinted formatos:
Pesquis por range de preço
{
    "productSearchType":"PRICE_RANGE",
    "initialPrice": 0.67,
    "finalPrice":4.84,
    "pageNumber":0,
    "pageSize":10
}

pesquisa pelo nome do produto
{
    "name":"UTX",
    "productSearchType":"NAME",
    "pageNumber":0,
    "pageSize":10
}


URL´s
endpoint de pesquisa requisição POST
http://localhost:8080/product/find


endpoint reimportar dados
http://localhost:8080/product/reimportData
