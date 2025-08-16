package com.group2.library_management.exception;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Bắt và xử lý tất cả các ngoại lệ EntityNotFoundException
     * được ném ra từ bất kỳ đâu trong ứng dụng.
     * @param ex Ngoại lệ bị bắt.
     * @param model Model để truyền thông báo lỗi đến view.
     * @return Tên của template lỗi sẽ được render.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleEntityNotFound(EntityNotFoundException ex, Model model) {
        log.warn("Resource not found requested: {}", ex.getMessage());
        model.addAttribute("errorMessage", "Rất tiếc, tài nguyên bạn tìm kiếm không tồn tại.");
        return "error/404"; // Trỏ đến view error/404.html
    }
}
