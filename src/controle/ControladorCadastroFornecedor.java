/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidade.Fornecedor;
import interfaces.jPrincipal;
import interfaces.jiCadastroFornecedor;
import java.awt.Dimension;

/**
 *
 * @author MARCOANTONIO
 */
public class ControladorCadastroFornecedor {

    public ControladorCadastroFornecedor() {
        Dimension d = jPrincipal.jDesktopPane1.getSize();
        jiCadastroFornecedor cf = new jiCadastroFornecedor(this);
        jPrincipal.jDesktopPane1.add(cf);
        cf.setLocation((d.width - cf.getSize().width) / 2, ((d.height - cf.getSize().height) / 2) - 100);
        cf.setVisible(true);
    }

    public String inserirFornecedor(Fornecedor fornecedor) {
        Fornecedor fornecedor1;
        String result;
        fornecedor1 = Fornecedor.buscarFornecedor(fornecedor.getCodigo());
        if (fornecedor1 == null) {
            result = Fornecedor.verificaDocCadastro(fornecedor.getN_documento());
            if(result == null){
                return Fornecedor.inserirFornecedor(fornecedor);
            }else{
                return result;
            }          
        } else {
            return "Código já inserido";
        }
        
    }

    public String alterarFornecedor(Fornecedor fornecedor) {
        Fornecedor fornecedor1;
        fornecedor1 = Fornecedor.buscarFornecedor(fornecedor.getCodigo());
        if (fornecedor1 != null) {
            return Fornecedor.alterarFornecedor(fornecedor);
        } else {
            return "Fornecedor não cadastrado";
        }
    }

    public String removerFornecedor(int código) {
        Fornecedor fornecedor1;
        fornecedor1 = Fornecedor.buscarFornecedor(código);
        if (fornecedor1 != null) {
            return Fornecedor.eleminarFornecedor(código);
        } else {
            return "Fornecedor não cadastrado";
        }
    }
}
