package com.example.angular.springbootcrudapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.example.angular.springbootcrudapi.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootCrudApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringbootCrudApiApplicationTests {

	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        //return "ENDPOINTURL";
		return "http://localhost:" + port;
    }
	
	@Test
	void contextLoads() {
	}
	
	@Test
    public void testGetAllEmployees() {
    HttpHeaders headers = new HttpHeaders();
       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/employees",
       HttpMethod.GET, entity, String.class);
       System.out.println("employees *****"+ response);
       assertNotNull(response.getBody());
   }
	
	@Test
    public void testGetEmployeeById() {
        Employee employee = restTemplate.getForObject(getRootUrl() + "/api/employees/1", Employee.class);
        System.out.println(employee.getName());
        assertNotNull(employee);
    }

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setEmail("admin@gmail.com");
        employee.setName("admin");
        employee.setDepartment("admin");
        employee.setPhone(98989898);        
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/employees", employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateEmployee() {
        int id = 2;
        Employee employee = restTemplate.getForObject(getRootUrl() + "/api/employees/" + id, Employee.class);
        employee.setName("admin1");
        employee.setDepartment("admin2");
        restTemplate.put(getRootUrl() + "/employees/" + id, employee);
        Employee updatedEmployee = restTemplate.getForObject(getRootUrl() + "/api/employees/" + id, Employee.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void testDeleteEmployee() {
         int id = 2;
         Employee employee = restTemplate.getForObject(getRootUrl() + "/api/employees/" + id, Employee.class);
         assertNotNull(employee);
         restTemplate.delete(getRootUrl() + "/employees/" + id);
         try {
              employee = restTemplate.getForObject(getRootUrl() + "/api/employees/" + id, Employee.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }

}
