package com.sist.web;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
///fbgf
@Configuration
public class ElasticSearchConfiguration
{
	/*
	 *    Http 호출을 위한 새로운 인터페이스인 RestClient이 나왔다. 
	 *    RestClient는 개발자가 Http 호출을 더 간편하게 할 수 있도록 설계되었으며, 
	 *    스프링에서 제공하던 RestTemplate과 WebClient에 이은 세 번째 옵션이다.
	 */
    @Bean
    public RestClient getRestClient() {
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200)).build();
        return restClient;
    }
    
    // 클라이언트에서 Query 전송 
    @Bean
    public  ElasticsearchTransport getElasticsearchTransport() {
        return new RestClientTransport(
                getRestClient(), new JacksonJsonpMapper());
    }

    // 클라이언트에서 elastic으로부터 데이터를 받는 역할 
    @Bean
    public ElasticsearchClient getElasticsearchClient(){
        ElasticsearchClient client = new ElasticsearchClient(getElasticsearchTransport());
        return client;
    }

}