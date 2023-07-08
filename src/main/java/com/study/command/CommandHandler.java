package com.study.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CommandHandler 인터페이스는 명령어 처리기의 기본 메서드를 정의합니다.
 */
public interface CommandHandler {
    /**
     * 요청과 응답에 대한 처리를 수행하고 결과를 반환합니다.
     *
     * @param request  HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @return 뷰 페이지의 URI
     * @throws Exception 예외가 발생한 경우
     */
    public String process(HttpServletRequest request, HttpServletResponse response)
            throws Exception;
}
