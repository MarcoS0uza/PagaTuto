/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author MARCOANTONIO
 */
public class Tools {

    public static enum UF {
        AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT,
        MS, MG, PA, PB, PR, PE, PI, RJ, RN, RS, RO,
        RR, SC, SP, SE, TO
    };
    
    
    public Tools() {
    }

    public String getDataAtual() {
        SimpleDateFormat dataAtual = new SimpleDateFormat("dd/MM/yyyy");
        return dataAtual.format(new Date());
    }

    public String getHoraAtual() {
        SimpleDateFormat horaAtual = new SimpleDateFormat("hh:mm:ss");
        return horaAtual.format(new Date());
    }
    
    
    
}
