package br.com.alwayspet.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RegistroNaoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> tratarRegistroNaoEncontrado(RegistroNaoEncontradoException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(criarResposta(
                        HttpStatus.NOT_FOUND,
                        "Registro não encontrado",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> tratarValidacao(MethodArgumentNotValidException ex) {
        Map<String, String> campos = new LinkedHashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(erro ->
                campos.put(erro.getField(), erro.getDefaultMessage())
        );

        Map<String, Object> resposta = criarResposta(
                HttpStatus.BAD_REQUEST,
                "Dados inválidos",
                "Existem campos inválidos na requisição"
        );

        resposta.put("campos", campos);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(resposta);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> tratarParametroInvalido(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(criarResposta(
                        HttpStatus.BAD_REQUEST,
                        "Parâmetro inválido",
                        "Verifique se os parâmetros enviados estão no formato correto"
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> tratarErroInterno(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(criarResposta(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "Erro interno",
                        "Não foi possível processar a solicitação"
                ));
    }

    private Map<String, Object> criarResposta(HttpStatus status, String erro, String mensagem) {
        Map<String, Object> resposta = new LinkedHashMap<>();
        resposta.put("timestamp", LocalDateTime.now().toString());
        resposta.put("status", status.value());
        resposta.put("erro", erro);
        resposta.put("mensagem", mensagem);
        return resposta;
    }
}