/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.pdsw.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joselima
 */
public class FormataData {

    public Date formata(String dataString) {
        SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date data_formatada = formatarData.parse(dataString);
            return data_formatada;
        } catch (ParseException ex) {
            Logger.getLogger(FormataData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public String formataString(Date data) {
        SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");

        String dataStringFormat = formatarData.format(data);
        return dataStringFormat;

    }

}
