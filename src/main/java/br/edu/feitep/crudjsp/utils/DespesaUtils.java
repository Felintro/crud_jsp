package br.edu.feitep.crudjsp.utils;

import br.com.codandosimples.model.Categoria;
import br.com.codandosimples.model.Despesa;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author allan
 * @Date: 21/09/2024
 */

public class DespesaUtils {

    public static Despesa converteRequestEmDespesa(HttpServletRequest request) {
        String descricaoStr = request.getParameter("descricao");
        String dataStr = request.getParameter("data");
        String valorStr = request.getParameter("valor");
        String categoriaStr = request.getParameter("categoria");

        LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        double valor = Double.parseDouble(valorStr);
        Categoria categoria = Categoria.valueOf(categoriaStr);

        return new Despesa(descricaoStr, data, valor, categoria);
    }

    public static String formatarData(LocalDate data) {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}