package nl.inholland.myfirstapi;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class MyStepdefs {

  private ResponseEntity<String> responseEntity;

  @When("I call get all cars")
  public void iCallGetAllCars() throws URISyntaxException {
    RestTemplate template = new RestTemplate();
    URI uri = new URI("http://localhost:8080/api/cars");
    responseEntity = template.getForEntity(uri,String.class);

  }

  @Then("return status {int}")
  public void returnStatus(int status) {
    Assert.assertEquals(responseEntity.getStatusCode(), status);
  }
}
