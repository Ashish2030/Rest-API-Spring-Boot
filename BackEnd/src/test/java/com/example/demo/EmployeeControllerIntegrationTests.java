package com.example.demo;
import com.example.demo.Model.UserDetails;
import com.example.demo.Model.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest(classes = DemoApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTests 
{
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	@SqlGroup({
			@Sql(scripts = "/schema.sql",
					config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED)),
			@Sql("/data.sql")})
	@Test
	public void testAllUser()
	{
		assertTrue(
				this.restTemplate
					.getForObject("http://localhost:" + port + "/user", Users.class)
					.getUserList().size() == 3);
	}
	@Test
	public void testAddUser() {
		UserDetails user1 = new UserDetails("Lokeesh", "Guupta","8434261111", "howwwtodoinjava@gmail.com");
		ResponseEntity<String> responseEntity = this.restTemplate
			.postForEntity("http://localhost:" + port + "/user", user1, String.class);
		assertEquals(201, responseEntity.getStatusCodeValue());
	}
}
