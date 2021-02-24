package br.com.emanuelgabriel.service.exception;

import feign.FeignException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletResponse;


@RestControllerAdvice
public class ApiGlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public String handleFeignStatusException(FeignException e, HttpServletResponse response) {
        response.setStatus(e.status());
        return "feignError";
    }

    @ExceptionHandler(CategoriaNaoEncontradaException.class)
    public String handleCategoriaNaoEncontradaFeignStatusException(CategoriaNaoEncontradaException e, HttpServletResponse response) {
        response.setStatus(e.getStatus());
        return "Categoria não encontrada";
    }

}
