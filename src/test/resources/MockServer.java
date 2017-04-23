
public class MockServer {
	
	@Test
	public vois test() {
		stubFor(get(urlEqualTo("/an/endpoint"))
	            .willReturn(aResponse()
	                .withHeader("Content-Type", "text/plain")
	                .withStatus(200)
	                .withBody("You've reached a valid WireMock endpoint")));			
	}

}
