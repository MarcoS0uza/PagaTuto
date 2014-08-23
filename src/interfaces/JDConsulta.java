/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidade.Cidade;
import entidade.Fornecedor;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MARCOANTONIO
 */
public class JDConsulta<T> extends javax.swing.JDialog {

    T objeto;

    public JDConsulta(java.awt.Frame parent, boolean modal, T objeto) {
        super(parent, modal);
        initComponents();
        this.objeto = objeto;
        if (objeto instanceof Cidade) {
            ArrayList<Cidade> cidades = null;
            cidades = Cidade.getCidades();
            if (cidades == null) {
                JOptionPane.showMessageDialog(this, "Erro ao recuperar os dados");
            } else {
                tabelaCidades(cidades);
            }
        } else if (objeto instanceof Fornecedor) {
            ArrayList<Fornecedor> fornecedor = null;
            fornecedor = Fornecedor.visãoTabela();
            if (fornecedor == null) {
                JOptionPane.showMessageDialog(this, "Erro ao recuperar os dados");
            } else {
                tabelaFornecedores(fornecedor);
            }
        }
    }

    private void tabelaCidades(ArrayList<Cidade> cidades) {
        DefaultTableModel modelo = new DefaultTableModel(new String[]{"CÓDIGO", "NOME", "UF"}, cidades.size());

        for (int i = 0; i < cidades.size(); i++) {
            modelo.setValueAt(cidades.get(i).getCodigo(), i, 0);
            modelo.setValueAt(cidades.get(i).getNome(), i, 1);
            modelo.setValueAt(cidades.get(i).getUf(), i, 2);
        }
        dadosTable0.setModel(modelo);
        dadosTable0.getColumnModel().getColumn(0).setPreferredWidth(70);
        dadosTable0.getColumnModel().getColumn(1).setPreferredWidth(150);
        dadosTable0.getColumnModel().getColumn(2).setPreferredWidth(30);
        setSize(310, getHeight());
        setLocationRelativeTo(this);
    }

    private void tabelaFornecedores(ArrayList<Fornecedor> fornecedor) {
        DefaultTableModel modelo = new DefaultTableModel(new String[]{"CÓDIGO", "NOME", "CPF/CNPJ"}, fornecedor.size());

        for (int i = 0; i < fornecedor.size(); i++) {
            modelo.setValueAt(fornecedor.get(i).getCodigo(), i, 0);
            modelo.setValueAt(fornecedor.get(i).getNome(), i, 1);
            modelo.setValueAt(fornecedor.get(i).getN_documento(), i, 2);
        }
        dadosTable0.setModel(modelo);
        dadosTable0.getColumnModel().getColumn(0).setPreferredWidth(70);
        dadosTable0.getColumnModel().getColumn(1).setPreferredWidth(300);
        dadosTable0.getColumnModel().getColumn(2).setPreferredWidth(130);
        setSize(540, getHeight());
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dadosTable0 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        dadosTable0.setAutoCreateRowSorter(true);
        dadosTable0.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        dadosTable0.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        dadosTable0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dadosTable0KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(dadosTable0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dadosTable0KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dadosTable0KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int linha = dadosTable0.getSelectedRow();
            String codigo_temp;
            int codigo;
            if (objeto instanceof Cidade) {
                codigo_temp = dadosTable0.getValueAt(linha, 0).toString();
                codigo = Integer.parseInt(codigo_temp);
                Cidade cidade = Cidade.getCidade(codigo);
                if (getTitle().equalsIgnoreCase("Cidades")) {
                    jiCadastroFornecedor.cod_cidadeTextField0.setText("" + cidade.getCodigo());
                    jiCadastroFornecedor.cidadeTextField.setText(cidade.getNome());
                    jiCadastroFornecedor.estadoTextField.setText(cidade.getUf());
                    jiCadastroFornecedor.telefoneFormattedTextField.grabFocus();
                    dispose();
                }
                } else if (objeto instanceof Fornecedor) {
                    codigo_temp = dadosTable0.getValueAt(linha, 0).toString();
                    codigo = Integer.parseInt(codigo_temp);
                    Fornecedor fornecedor = Fornecedor.buscarFornecedor(codigo);
                    if (getTitle().equalsIgnoreCase("Fornecedores")) {
                        jiCadastroFornecedor.mostraDados(fornecedor);
                        dispose();
                    }
                }
        }
    }//GEN-LAST:event_dadosTable0KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable dadosTable0;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
