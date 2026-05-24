package br.com.alwayspet.api.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(RegistroNaoEncontradoException.class)
    public ResponseEntity<Map<String,Object>> notFound(RegistroNaoEncontradoException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body(ex.getMessage()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException ex){
        return ResponseEntity.badRequest().body(body("Campos inválidos na requisição"));
    }
    private Map<String,Object> body(String msg){
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("timestamp", LocalDateTime.now().toString());
        map.put("mensagem", msg);
        return map;
    }
}
