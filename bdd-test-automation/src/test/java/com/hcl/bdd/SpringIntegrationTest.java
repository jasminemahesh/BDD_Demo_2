package com.hcl.bdd;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration
public class SpringIntegrationTest {
    
   /* RestTemplate restTemplate;
    Response response=null;
    
    public void execute(String url, HttpMethod httpMethod)
    {
	restTemplate=new RestTemplate();  
	ResponseExtractor<Response> responseExtractor=new ResponseExtractor<Response>() {
	    
	    public Response extractData(ClientHttpResponse httpResponse) throws IOException{
		return new Response(httpResponse);
	    }
	};
	response= restTemplate.execute(url, httpMethod, getRequestCallBack(), responseExtractor, new Object[]{});
    }

    private RequestCallback getRequestCallBack()
    {
	final Map<String, String> httpHeaders=new HashMap<String, String>();
	httpHeaders.put(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE);
	return new RequestCallback() {
	    
	    //@Override
	    public void doWithRequest(ClientHttpRequest request) throws IOException {
		request.getHeaders().setAll(httpHeaders);
		
	    }
	};
    }
   */
}
