package ma.hmzelidrissi.springbootmvcmicroserviceboilerplate.exception;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
