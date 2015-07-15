/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.apaebrasil.spag.infraestrutura.autorizacao;

import br.org.apaebrasil.spag.dominio.Profissional;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fbc
 */
@WebFilter("*.xhtml")
public class AutorizacaoFilter implements Filter {

    @Inject
    private Profissional profissional;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        profissional = new Profissional();
        profissional.setNome("Pedro");
        
        if (profissional.getNome() == null && !request.getRequestURI().endsWith("/index.xhtml")
                && !request.getRequestURI().contains("/javax.faces.resource/")) {
            response.sendRedirect(request.getContextPath() + "/index.xhtml");
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
