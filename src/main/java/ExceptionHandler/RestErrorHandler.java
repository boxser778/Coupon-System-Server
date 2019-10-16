//package ExceptionHandler;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.method.HandlerMethod;
//
//@ControllerAdvice
//public class RestErrorHandler {
//
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ResponseEntity<ValidationErrorDTO> processValidationIllegalError(HttpMessageNotReadableException ex,
//            HandlerMethod handlerMethod, WebRequest webRequest) {
//
//        EnumValidationException exception = (EnumValidationException) ex.getMostSpecificCause();
//
//        ValidationErrorDTO errorDTO = new ValidationErrorDTO();
//        errorDTO.setEnumName(exception.getEnumName());
//        errorDTO.setEnumValue(exception.getEnumValue());
//        errorDTO.setErrorMessage(exception.getEnumValue() + " is an invalid " + exception.getEnumName());
//        return new ResponseEntity<ValidationErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
//    }
//
//}