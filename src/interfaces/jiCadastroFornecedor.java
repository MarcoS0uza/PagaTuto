/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import controle.ControladorCadastroFornecedor;
import controle.Tools;
import controle.buscaCEP;
import entidade.Cidade;
import entidade.Fornecedor;
import entidade.Visão;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.border.TitledBorder;

/**
 *
 * @author MARCOANTONIO
 */
public class jiCadastroFornecedor extends javax.swing.JInternalFrame {

    ControladorCadastroFornecedor controlador;
    private String tipo;//armazena o tipo do fornecedor(Fisica ou Juridica)
    ArrayList<Fornecedor> fornecedores;//armazena fornecedores filtrados
    int cont = 0; // controla a navegação no array de fornecedor
    Tools tools = new Tools();

    public jiCadastroFornecedor(ControladorCadastroFornecedor controlador) {
        initComponents();
        this.controlador = controlador;
        salvarButton.setVisible(false);
        buscarButton.setVisible(false);
        cancelaButton.setEnabled(false);
        limpa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pessoabuttonGroup = new javax.swing.ButtonGroup();
        dadosPanel = new javax.swing.JPanel();
        codigoLabel = new javax.swing.JLabel();
        cpfcnpjLabel = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();
        codigoTextField = new javax.swing.JTextField();
        nomeTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        botoesPanel = new javax.swing.JPanel();
        eliminarButton = new javax.swing.JButton();
        novoButton = new javax.swing.JButton();
        selecionarButton = new javax.swing.JButton();
        gravarButton = new javax.swing.JButton();
        editarButton = new javax.swing.JButton();
        salvarButton = new javax.swing.JButton();
        cancelaButton = new javax.swing.JButton();
        buscarButton = new javax.swing.JButton();
        tipo_pessoaLabel = new javax.swing.JLabel();
        fisicaRadioButton = new javax.swing.JRadioButton();
        juridicaRadioButton = new javax.swing.JRadioButton();
        cnpjCpfFormattedTextField = new javax.swing.JFormattedTextField();
        enderecoPanel = new javax.swing.JPanel();
        ruaLabel = new javax.swing.JLabel();
        ruaTextField = new javax.swing.JTextField();
        numeroLabel = new javax.swing.JLabel();
        numeroTextField = new javax.swing.JTextField();
        bairroLabel = new javax.swing.JLabel();
        bairroTextField = new javax.swing.JTextField();
        cidadeLabel = new javax.swing.JLabel();
        estadoLabel = new javax.swing.JLabel();
        cepLabel = new javax.swing.JLabel();
        cepFormattedTextField = new javax.swing.JFormattedTextField();
        telefoneLabel = new javax.swing.JLabel();
        telefoneFormattedTextField = new javax.swing.JFormattedTextField();
        buscacepjLabel = new javax.swing.JLabel();
        cepProgressBar = new javax.swing.JProgressBar();
        cod_cidadeTextField0 = new javax.swing.JTextField();
        cidadeTextField = new javax.swing.JTextField();
        estadoTextField = new javax.swing.JTextField();
        dataFormattedTextField = new javax.swing.JFormattedTextField();
        dataLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        primeiroButton = new javax.swing.JButton();
        atrasButton = new javax.swing.JButton();
        frenteButton = new javax.swing.JButton();
        ultimoButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro Fornecedor");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        dadosPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        codigoLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        codigoLabel.setText("Codigo");

        cpfcnpjLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cpfcnpjLabel.setText("CPF");

        nomeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nomeLabel.setText("Nome");

        codigoTextField.setEditable(false);
        codigoTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        codigoTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        codigoTextField.setEnabled(false);
        codigoTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoTextFieldKeyPressed(evt);
            }
        });

        nomeTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nomeTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nomeTextField.setEnabled(false);
        nomeTextField.setFocusCycleRoot(true);
        nomeTextField.setSelectedTextColor(new java.awt.Color(255, 204, 0));

        emailLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        emailLabel.setText("Email");

        emailTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        emailTextField.setEnabled(false);

        eliminarButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        eliminarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excluir.png"))); // NOI18N
        eliminarButton.setToolTipText("Excluir");
        eliminarButton.setEnabled(false);
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        novoButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        novoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novo.png"))); // NOI18N
        novoButton.setToolTipText("Novo");
        novoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoButtonActionPerformed(evt);
            }
        });

        selecionarButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        selecionarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/selecionar.png"))); // NOI18N
        selecionarButton.setToolTipText("Selecionar");
        selecionarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionarButtonActionPerformed(evt);
            }
        });

        gravarButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        gravarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gravar.png"))); // NOI18N
        gravarButton.setToolTipText("Gravar");
        gravarButton.setEnabled(false);
        gravarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gravarButtonActionPerformed(evt);
            }
        });

        editarButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        editarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        editarButton.setToolTipText("Editar");
        editarButton.setEnabled(false);
        editarButton.setMaximumSize(new java.awt.Dimension(63, 23));
        editarButton.setMinimumSize(new java.awt.Dimension(63, 23));
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });

        salvarButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        salvarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvar.png"))); // NOI18N
        salvarButton.setToolTipText("Salvar");
        salvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarButtonActionPerformed(evt);
            }
        });

        cancelaButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cancelaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        cancelaButton.setToolTipText("Cancelar");
        cancelaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaButtonActionPerformed(evt);
            }
        });

        buscarButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buscarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        buscarButton.setToolTipText("Buscar");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botoesPanelLayout = new javax.swing.GroupLayout(botoesPanel);
        botoesPanel.setLayout(botoesPanelLayout);
        botoesPanelLayout.setHorizontalGroup(
            botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(novoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selecionarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gravarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        botoesPanelLayout.setVerticalGroup(
            botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesPanelLayout.createSequentialGroup()
                .addGroup(botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gravarButton)
                    .addComponent(editarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salvarButton)
                    .addComponent(eliminarButton)
                    .addComponent(novoButton)
                    .addComponent(cancelaButton)
                    .addComponent(buscarButton)
                    .addComponent(selecionarButton))
                .addGap(0, 0, 0))
        );

        tipo_pessoaLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tipo_pessoaLabel.setText("Pessoa");

        fisicaRadioButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fisicaRadioButton.setText("Fisica");
        fisicaRadioButton.setActionCommand("F");
        fisicaRadioButton.setEnabled(false);
        fisicaRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fisicaRadioButtonActionPerformed(evt);
            }
        });

        juridicaRadioButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        juridicaRadioButton.setText("Juridica");
        juridicaRadioButton.setActionCommand("J");
        juridicaRadioButton.setEnabled(false);
        juridicaRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juridicaRadioButtonActionPerformed(evt);
            }
        });

        try {
            cnpjCpfFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cnpjCpfFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cnpjCpfFormattedTextField.setEnabled(false);
        cnpjCpfFormattedTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        enderecoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 10))); // NOI18N

        ruaLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ruaLabel.setText("Rua");

        ruaTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ruaTextField.setEnabled(false);

        numeroLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        numeroLabel.setText("Nº");

        numeroTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        numeroTextField.setEnabled(false);

        bairroLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bairroLabel.setText("Bairro");

        bairroTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        bairroTextField.setEnabled(false);

        cidadeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cidadeLabel.setText("Cidade");

        estadoLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        estadoLabel.setText("UF");

        cepLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cepLabel.setText("Cep");

        try {
            cepFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cepFormattedTextField.setEnabled(false);

        telefoneLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        telefoneLabel.setText("Fone");

        try {
            telefoneFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telefoneFormattedTextField.setEnabled(false);

        buscacepjLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buscacepjLabel.setForeground(new java.awt.Color(0, 0, 255));
        buscacepjLabel.setText("Buscar Endereço");
        buscacepjLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        buscacepjLabel.setEnabled(false);
        buscacepjLabel.setText("<html><u>Buscar Endereço</u></html>");
        buscacepjLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscacepjLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buscacepjLabelMouseEntered(evt);
            }
        });

        cod_cidadeTextField0.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cod_cidadeTextField0.setEnabled(false);
        cod_cidadeTextField0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cod_cidadeTextField0KeyPressed(evt);
            }
        });

        cidadeTextField.setEditable(false);
        cidadeTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cidadeTextField.setEnabled(false);

        estadoTextField.setEditable(false);
        estadoTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        estadoTextField.setEnabled(false);

        javax.swing.GroupLayout enderecoPanelLayout = new javax.swing.GroupLayout(enderecoPanel);
        enderecoPanel.setLayout(enderecoPanelLayout);
        enderecoPanelLayout.setHorizontalGroup(
            enderecoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enderecoPanelLayout.createSequentialGroup()
                .addGroup(enderecoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(enderecoPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(enderecoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefoneLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ruaLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cepLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(cidadeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(enderecoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(enderecoPanelLayout.createSequentialGroup()
                        .addComponent(telefoneFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(bairroLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bairroTextField))
                    .addGroup(enderecoPanelLayout.createSequentialGroup()
                        .addGroup(enderecoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(enderecoPanelLayout.createSequentialGroup()
                                .addComponent(cepFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(buscacepjLabel)
                                .addGap(18, 18, 18)
                                .addComponent(cepProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(enderecoPanelLayout.createSequentialGroup()
                                .addComponent(ruaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numeroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(enderecoPanelLayout.createSequentialGroup()
                                .addComponent(cod_cidadeTextField0, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estadoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estadoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        enderecoPanelLayout.setVerticalGroup(
            enderecoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enderecoPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(enderecoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cepProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscacepjLabel)
                    .addComponent(cepFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cepLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(enderecoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruaLabel)
                    .addComponent(ruaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroLabel)
                    .addComponent(numeroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(enderecoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadoLabel)
                    .addComponent(cidadeLabel)
                    .addComponent(cod_cidadeTextField0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(enderecoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefoneLabel)
                    .addComponent(telefoneFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bairroLabel)
                    .addComponent(bairroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        dataFormattedTextField.setEditable(false);
        dataFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        dataFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dataFormattedTextField.setEnabled(false);
        dataFormattedTextField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        dataLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dataLabel.setText("Data de Cadastro");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "0 de 0", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_BOTTOM, new java.awt.Font("Tahoma", 0, 10))); // NOI18N

        primeiroButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        primeiroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/primeiro.png"))); // NOI18N
        primeiroButton.setToolTipText("Primeiro");
        primeiroButton.setEnabled(false);
        primeiroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primeiroButtonActionPerformed(evt);
            }
        });

        atrasButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        atrasButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        atrasButton.setToolTipText("Anterior");
        atrasButton.setEnabled(false);
        atrasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasButtonActionPerformed(evt);
            }
        });

        frenteButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        frenteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/frente.png"))); // NOI18N
        frenteButton.setToolTipText("Próximo");
        frenteButton.setEnabled(false);
        frenteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frenteButtonActionPerformed(evt);
            }
        });

        ultimoButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ultimoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ultimo.png"))); // NOI18N
        ultimoButton.setToolTipText("Ultimo");
        ultimoButton.setEnabled(false);
        ultimoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultimoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(primeiroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atrasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frenteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ultimoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ultimoButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(frenteButton)
                                .addComponent(atrasButton)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(primeiroButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout dadosPanelLayout = new javax.swing.GroupLayout(dadosPanel);
        dadosPanel.setLayout(dadosPanelLayout);
        dadosPanelLayout.setHorizontalGroup(
            dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dadosPanelLayout.createSequentialGroup()
                        .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tipo_pessoaLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(codigoLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dadosPanelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(fisicaRadioButton)
                                .addGap(0, 0, 0)
                                .addComponent(juridicaRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(cpfcnpjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cnpjCpfFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dadosPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codigoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataLabel)
                                .addGap(4, 4, 4)
                                .addComponent(dataFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(dadosPanelLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(dadosPanelLayout.createSequentialGroup()
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(emailLabel))
                    .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(botoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enderecoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dadosPanelLayout.setVerticalGroup(
            dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosPanelLayout.createSequentialGroup()
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(codigoLabel))
                    .addGroup(dadosPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dataLabel))
                    .addGroup(dadosPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(dataFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadosPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(codigoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(nomeLabel))
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fisicaRadioButton)
                        .addComponent(tipo_pessoaLabel))
                    .addComponent(juridicaRadioButton)
                    .addGroup(dadosPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpfcnpjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cnpjCpfFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(emailLabel))
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enderecoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscacepjLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscacepjLabelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_buscacepjLabelMouseEntered

    private void buscacepjLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscacepjLabelMouseClicked
        if (buscacepjLabel.isEnabled()) {
            new SwingWorker() {

                @Override
                protected Object doInBackground() throws Exception {
                    cepProgressBar.setIndeterminate(true);
                    String cep = cepFormattedTextField.getText().replace(".", "").replace("-", "");
                    if (cep.equals("        ")) {
                        JOptionPane.showMessageDialog(null, "CEP não informado");
                    } else {
                        try {
                            if (buscaCEP.existe(cep)) {
                                String cidade = buscaCEP.getCidade(cep);
                                String uf = buscaCEP.getUF(cep);
                                
                                ruaTextField.setText(buscaCEP.getEndereco(cep));
                                String result = Fornecedor.buscaCodCidade(cidade, uf);
                                if(result!=null){
                                    cidadeTextField.setText(cidade);
                                    estadoTextField.setText(uf);
                                    cod_cidadeTextField0.setText(result);
                                }else{
                                    JOptionPane.showMessageDialog(null, "Cidade não encontrada");
                                }
                                
                                bairroTextField.setText(buscaCEP.getBairro(cep));
                                numeroTextField.grabFocus();
                            } else {
                                JOptionPane.showMessageDialog(null, "Cep " + cep + " não encontrado ");
                            }
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Erro ao buscar endereço: " + ex);
                        }

                    }
                    return 0;
                }

                @Override
                protected void done() {
                    cepProgressBar.setIndeterminate(false);
                }
            }.execute();
        }
    }//GEN-LAST:event_buscacepjLabelMouseClicked

    private void juridicaRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juridicaRadioButtonActionPerformed
        if (juridicaRadioButton.isSelected()) {
            cpfcnpjLabel.setText("CNPJ");//muda nome do Label
            cnpjCpfFormattedTextField.setValue("");// apaga conteúdo anterior
            //muda mascara do campo
            try {
                cnpjCpfFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_juridicaRadioButtonActionPerformed

    private void fisicaRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fisicaRadioButtonActionPerformed
        if (fisicaRadioButton.isSelected()) {
            cpfcnpjLabel.setText("CPF");//muda nome do Label
            cnpjCpfFormattedTextField.setValue("");// apaga conteúdo anterior
            //muda mascara do campo
            try {
                cnpjCpfFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_fisicaRadioButtonActionPerformed

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        cont = 0;
        if (!codigoTextField.getText().isEmpty()) {
            Fornecedor cliente = Fornecedor.buscarFornecedor(Integer.parseInt(codigoTextField.getText()));
            if (cliente == null) {
                JOptionPane.showMessageDialog(this, "Fornecedor não encontrado", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                mostraDados(cliente);
                selecionarButton.setVisible(true);
                buscarButton.setVisible(false);
                botoesNavegacao(false);
            }
        } else {
            botoesNavegacao(true);
            int cod, numero, cod_cidade;
            if (juridicaRadioButton.isSelected()) {
                tipo = juridicaRadioButton.getActionCommand();
            } else if (fisicaRadioButton.isSelected()) {
                tipo = fisicaRadioButton.getActionCommand();
            } else {
                tipo = null;
            }

            if (codigoTextField.getText().isEmpty()) {
                cod = -1;
            } else {
                cod = Integer.parseInt(codigoTextField.getText());
            }

            if (numeroTextField.getText().isEmpty()) {
                numero = 0;
            } else {
                numero = Integer.parseInt(numeroTextField.getText());
            }

            if (cidadeTextField.getText().isEmpty()) {
                cod_cidade = -1;
            } else {
                cod_cidade = Integer.parseInt(cod_cidadeTextField0.getText());
            }
            //cria objeto fornecedor com os dados do jFrame
            try {
                Fornecedor fornecedor = new Fornecedor(numero, new Cidade(cidadeTextField.getText(),cod_cidade), nomeTextField.getText(), retiraMask(cnpjCpfFormattedTextField.getText()),
                        ruaTextField.getText(), bairroTextField.getText(), retiraMask(telefoneFormattedTextField.getText()),
                        retiraMask(cepFormattedTextField.getText()), estadoTextField.getText(), emailTextField.getText(),
                        dataFormattedTextField.getText(), tipo);

                if (dadosOK(fornecedor)) {
                    fornecedor = null;
                }
                fornecedores = Fornecedor.buscarTodosFornecedor(fornecedor);
                if (fornecedores.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Fornecedor não encontrado", "Atenção", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (fornecedores.size() == 1) {
                        botoesNavegacao(false);
                    }
                    mostraDados(fornecedores.get(0));
                    selecionarButton.setVisible(true);
                    buscarButton.setVisible(false);
                    novoButton.setEnabled(true);
                    codigoTextField.setEditable(false);
                    setTextoBorda("1 de "+fornecedores.size());

                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_buscarButtonActionPerformed
    private String retiraMask(String s) {
        return s.replaceAll("[^0-9 ]", "").trim();
    }
    private void cancelaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaButtonActionPerformed
        limpa();
        setAtivo(false);
        novoButton.setEnabled(true);
        selecionarButton.setEnabled(true);
        cancelaButton.setEnabled(false);
        gravarButton.setEnabled(false);
        selecionarButton.setVisible(true);
        buscarButton.setVisible(false);
        codigoTextField.setEditable(false);
        codigoTextField.setEnabled(false);
        editarSalvar();
        cont = 0;
        botoesNavegacao(false);
        setTextoBorda("0 de 0");
    }//GEN-LAST:event_cancelaButtonActionPerformed

    private void salvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarButtonActionPerformed
                //captura o tipo do fornecedor
                if (juridicaRadioButton.isSelected()) {
                    tipo = juridicaRadioButton.getText();
                } else if (fisicaRadioButton.isSelected()) {
                    tipo = fisicaRadioButton.getText();
                } else {
                    tipo = null;
                }
                String sexo, cod_cidade, uf;
                int cod, numero;
        
                //captura o sexo do fornecedor, caso seja juridica sexo = "9"
                if (cpfcnpjLabel.getText().equalsIgnoreCase("Cnpj")) {
                    sexo = "9";
                } else {
                    if (sexoComboBox.getSelectedIndex() == -1) {
                        sexo = null;
                    } else {
                        sexo = sexoComboBox.getSelectedItem().toString();
                    }
                }
        
                if (cod_clienteTextField.getText().isEmpty()) {
                    cod = -1;
                } else {
                    cod = Integer.parseInt(cod_clienteTextField.getText());
                }
        
                if (numeroTextField.getText().isEmpty()) {
                    numero = -1;
                } else {
                    numero = Integer.parseInt(numeroTextField.getText());
                }
        
                if (estadoComboBox.getSelectedIndex() == -1) {
                    uf = null;
                } else {
                    uf = estadoComboBox.getSelectedItem().toString();
                }
                if (cidadeTextField.getSelectedIndex() == -1) {
                    cod_cidade = null;
                } else {
                    cod_cidade = String.valueOf(cidadeTextField.getSelectedIndex()) + "-" + cidadeTextField.getSelectedItem().toString();
                }
        
                //cria objeto fornecedor com os dados do jFrame
                Cliente fornecedor = new Cliente(tipo, sexo,
                        cod,//convert int
                        numero,//convert int
                        nome_clienteTextField.getText(), dataFormattedTextField.getText(),
                        cnpjCpfFormattedTextField.getText().replace(".", "").replace("/", "").replace("-", "")/*replace() retira mascara*/, ruaTextField.getText(),
                        bairroTextField.getText(), telefoneFormattedTextField.getText().replace("(", "").replace(")", "").replace("-", "")/*replace() retira mascara*/,
                        cepFormattedTextField.getText().replace(".", "").replace("-", "")/*replace() retira mascara*/, uf,
                        cod_cidade, email_clienteTextField.getText());
        
                String mensagem_erro = null;
                String s = notNull(fornecedor);
                if (s != null) {//verificada se tem campos em branco
                    JOptionPane.showMessageDialog(this, s, "ANTEÇÃO", JOptionPane.WARNING_MESSAGE);
                } else {
                    mensagem_erro = controlador.alterarCliente(fornecedor);
                    fornecedores.set(cont, fornecedor);
                }
        
                //trata retorno do inserirCliente(fornecedor)
                if (mensagem_erro != null) {
                    JOptionPane.showMessageDialog(this, mensagem_erro, "ERRO", JOptionPane.ERROR_MESSAGE);
                } else if (s == null) {
                    setEdição(false);
                    editarSalvar();
                }
    }//GEN-LAST:event_salvarButtonActionPerformed

    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed
        botoesNavegacao(false);
        gravarButton.setEnabled(false);
        editarButton.setVisible(false);
        salvarButton.setVisible(true);
        codigoTextField.setEditable(false);
        nomeTextField.grabFocus();
        setEdição(true);
    }//GEN-LAST:event_editarButtonActionPerformed

    private void gravarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gravarButtonActionPerformed
                selecionarButton.setEnabled(true);
        
                String mensagem_erro = null;
        
                //captura o tipo do fornecedor
                if (juridicaRadioButton.isSelected()) {
                    tipo = juridicaRadioButton.getActionCommand();
                } else if (fisicaRadioButton.isSelected()) {
                    tipo = fisicaRadioButton.getActionCommand();
                } else {
                    tipo = null;
                }
                int cod, numero,cod_cidade;
        
                if (codigoTextField.getText().isEmpty()) {
                    cod = 0;
                } else {
                    cod = Integer.parseInt(codigoTextField.getText());
                }
        
                if (numeroTextField.getText().isEmpty()) {
                    numero = -1;
                } else {
                    numero = Integer.parseInt(numeroTextField.getText());
                }
                if (cod_cidadeTextField0.getText().isEmpty()) {
                    cod_cidade = -1;
                } else {
                    cod_cidade = Integer.parseInt(cod_cidadeTextField0.getText());
                }
                
//cria objeto fornecedor com os dados do jFrame
                Fornecedor fornecedor = new Fornecedor(numero, new Cidade(cidadeTextField.getText(),cod_cidade), nomeTextField.getText(), retiraMask(cnpjCpfFormattedTextField.getText()),
                        ruaTextField.getText(), bairroTextField.getText(), retiraMask(telefoneFormattedTextField.getText()),
                        retiraMask(cepFormattedTextField.getText()), estadoTextField.getText(), emailTextField.getText(),
                        dataFormattedTextField.getText(), tipo);
        
                String s = notNull(fornecedor);
                if (s != null) {//verificada se tem campos em branco
                    JOptionPane.showMessageDialog(this, s, "ERRO", JOptionPane.WARNING_MESSAGE);
                } else {
                    mensagem_erro = controlador.inserirFornecedor(fornecedor);//executa sql
                }
        
                //trata retorno do inserirCliente(fornecedor)
                if (mensagem_erro != null) {
                    JOptionPane.showMessageDialog(this, mensagem_erro, "ERRO", JOptionPane.ERROR_MESSAGE);
                } else if (s == null) {
                    setAtivo(false);
                    novoButton.setEnabled(true);
                    pessoabuttonGroup.clearSelection();
                    setEdição(false);
                    editarButton.setEnabled(true);
                    cancelaButton.setEnabled(false);
        
                }
    }//GEN-LAST:event_gravarButtonActionPerformed

    private void selecionarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionarButtonActionPerformed
        limpa();
        setAtivo(true);
        setEdição(true);
        cancelaButton.setEnabled(true);
        codigoTextField.grabFocus();
        selecionarButton.setVisible(false);
        buscarButton.setVisible(true);
        codigoTextField.setEditable(true);
        codigoTextField.setEnabled(true);
        novoButton.setEnabled(false);
        eliminarButton.setEnabled(false);
        editarButton.setEnabled(false);
        gravarButton.setEnabled(false);
    }//GEN-LAST:event_selecionarButtonActionPerformed

    private void novoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoButtonActionPerformed
                codigoTextField.setEditable(false);
                setEdição(true);
                editarSalvar();
                tipo = fisicaRadioButton.getText();
                fisicaRadioButton.setSelected(true);
                limpa();
                setAtivo(true);
                dataFormattedTextField.setText(tools.getDataAtual());
                nomeTextField.grabFocus();
                novoButton.setEnabled(false);
                eliminarButton.setEnabled(false);
                selecionarButton.setEnabled(false);
                editarButton.setEnabled(false);
                cancelaButton.setEnabled(true);
                codigoTextField.setText(Fornecedor.id());
    }//GEN-LAST:event_novoButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
                //mensagem de sim ou não
                int eliminar = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar este registro", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (eliminar == JOptionPane.YES_OPTION) {//se sim
                    String mensagem_erro = controlador.removerFornecedor(Integer.parseInt(codigoTextField.getText()));//sql delete
        
                    //trata retorno .removerCliente()
                    if (mensagem_erro != null) {
                        JOptionPane.showMessageDialog(this, mensagem_erro, "ERRO", JOptionPane.ERROR_MESSAGE);
                    } else {
                        fornecedores.remove(cont);
                        mostraDados(fornecedores.get(cont));
                        eliminarButton.setEnabled(false);
                        editarButton.setEnabled(false);
                        setTextoBorda(cont+1+" de "+fornecedores.size());
                    }
                }
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void codigoTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            JDConsulta<Fornecedor> consulta = new JDConsulta<Fornecedor>(null,true,new Fornecedor());
            consulta.setTitle("Fornecedores");//muda o titulo da janela, para identificar a classe chamadora
            consulta.setVisible(true);
        }else if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String cod = codigoTextField.getText();
            if(!cod.isEmpty()){
               Fornecedor fornecedor = Fornecedor.buscarFornecedor(Integer.parseInt(cod));
                mostraDados(fornecedor);
            }
            
        }
        
    }//GEN-LAST:event_codigoTextFieldKeyPressed

    private void primeiroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primeiroButtonActionPerformed
        mostraDados(fornecedores.get(0));
        cont = 0;
        setTextoBorda(cont + 1 + " de " + fornecedores.size());
    }//GEN-LAST:event_primeiroButtonActionPerformed

    private void atrasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasButtonActionPerformed
        if (cont != 0) {
            mostraDados(fornecedores.get(cont - 1));
            cont--;
            setTextoBorda(cont + 1 + " de " + fornecedores.size());
        }
    }//GEN-LAST:event_atrasButtonActionPerformed

    private void frenteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frenteButtonActionPerformed
        if (cont < fornecedores.size()) {
            mostraDados(fornecedores.get(cont + 1));
            cont++;
            setTextoBorda(cont + 1 + " de " + fornecedores.size());
        }
    }//GEN-LAST:event_frenteButtonActionPerformed

    private void ultimoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimoButtonActionPerformed
        mostraDados(fornecedores.get(fornecedores.size() - 1));
        cont = fornecedores.size() - 1;
        setTextoBorda(cont + 1 + " de " + fornecedores.size());
    }//GEN-LAST:event_ultimoButtonActionPerformed

    private void setTextoBorda(String txt) {
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, txt,
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.BELOW_BOTTOM,
                new java.awt.Font("Tahoma", 0, 10)));
    }
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        cont = 0;
        jPrincipal.controleFornecedor = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void cod_cidadeTextField0KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cod_cidadeTextField0KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            JDConsulta<Cidade> consulta = new JDConsulta<Cidade>(null,true,new Cidade());
            consulta.setTitle("Cidades");
            consulta.setVisible(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            String cod_cidade = cod_cidadeTextField0.getText();
            if(!cod_cidade.isEmpty()){
               Cidade cidade = Cidade.getCidade(Integer.parseInt(cod_cidade));
               cidadeTextField.setText(cidade.getNome());
               estadoTextField.setText(cidade.getUf());
               telefoneFormattedTextField.grabFocus();
            }
            
        }
    }//GEN-LAST:event_cod_cidadeTextField0KeyPressed

    //apaga o conteúdo dos jtextfield
    public static void limpa() {
        dataFormattedTextField.setText("");
        codigoTextField.setText("");
        nomeTextField.setText("");
        cnpjCpfFormattedTextField.setText("");
        emailTextField.setText("");
        ruaTextField.setText("");
        numeroTextField.setText("");
        bairroTextField.setText("");
        cepFormattedTextField.setText("");
        telefoneFormattedTextField.setText("");
        cidadeTextField.setText("");
        estadoTextField.setText("");
        pessoabuttonGroup.clearSelection();
        cod_cidadeTextField0.setText("");
    }

    //controla se o elemento vai ser editavel ou não
    public static void setEdição(boolean estado) {
        codigoTextField.setEditable(estado);
        nomeTextField.setEditable(estado);
        cnpjCpfFormattedTextField.setEditable(estado);
        emailTextField.setEditable(estado);
        ruaTextField.setEditable(estado);
        numeroTextField.setEditable(estado);
        bairroTextField.setEditable(estado);
        estadoTextField.setEditable(estado);
        cepFormattedTextField.setEditable(estado);
        telefoneFormattedTextField.setEditable(estado);
        fisicaRadioButton.setEnabled(estado);
        juridicaRadioButton.setEnabled(estado);
        buscacepjLabel.setEnabled(estado);
        cidadeTextField.setEditable(estado);
        cod_cidadeTextField0.setEditable(estado);

    }

    //controla se o elemento vai ficar ativo ou não
    public static void setAtivo(boolean estado) {
        codigoTextField.setEnabled(estado);
        dataFormattedTextField.setEnabled(estado);
        fisicaRadioButton.setEnabled(estado);
        juridicaRadioButton.setEnabled(estado);
        nomeTextField.setEnabled(estado);
        cnpjCpfFormattedTextField.setEnabled(estado);
        emailTextField.setEnabled(estado);
        ruaTextField.setEnabled(estado);
        numeroTextField.setEnabled(estado);
        bairroTextField.setEnabled(estado);
        estadoTextField.setEnabled(estado);
        cepFormattedTextField.setEnabled(estado);
        telefoneFormattedTextField.setEnabled(estado);
        editarButton.setEnabled(estado);
        eliminarButton.setEnabled(estado);
        gravarButton.setEnabled(estado);
        buscacepjLabel.setEnabled(estado);
        cidadeTextField.setEnabled(estado);
        cod_cidadeTextField0.setEnabled(estado);
    }

    //controla a visibilidade dos botões editar e salvar
    public static void editarSalvar() {
        salvarButton.setVisible(false);
        editarButton.setVisible(true);
    }
    public static String notNull(Fornecedor fornecedor) {
        String s = null;
        if (fornecedor.getNome().equals("")) {
            s += " Nome\n";
        }
        if (fornecedor.getN_documento().trim().equals("")) {
            s += " CNPJ/CPF\n";
        }
        if (fornecedor.getCodigo() == -1) {
            s += " Código\n";
        }
        if (fornecedor.getCidade().getCodigo() == -1) {
            s += " Cidade\n";
        }
        if (fornecedor.getEstado().equals("")) {
            s += " Estado\n";
        }
        if (fornecedor.getTipo_pessoa()== null) {
            s += " Tipo\n";
        }
        if (s == null) {
            return null;
        } else {
            return "Campo(s) Obrigatórios:\n" + s.replace("null", "");
        }
    }

    //preenche os campos do jFrame, com o objeto fornecedor criado na JanelaConsultaCliente
    static public void mostraDados(Fornecedor fornecedor) {
        limpa();
        setAtivo(true);
        cnpjCpfFormattedTextField.setText(fornecedor.getN_documento());
        gravarButton.setEnabled(false);
        codigoTextField.setText(String.valueOf(fornecedor.getCodigo()));
        dataFormattedTextField.setText(fornecedor.getData_cadastro());
        nomeTextField.setText(fornecedor.getNome());
        emailTextField.setText(fornecedor.getEmail());
        ruaTextField.setText(fornecedor.getEndereço());
        numeroTextField.setText(String.valueOf(fornecedor.getNumero()));
        bairroTextField.setText(fornecedor.getBairro());
        estadoTextField.setText(fornecedor.getEstado());
        cepFormattedTextField.setText(fornecedor.getCep());
        telefoneFormattedTextField.setText(fornecedor.getTelefone());
        cod_cidadeTextField0.setText(""+fornecedor.getCidade().getCodigo());
        cidadeTextField.setText(fornecedor.getCidade().getNome());
        if (null != fornecedor.getTipo_pessoa()) {
            switch (fornecedor.getTipo_pessoa()) {
                case "F":
                    pessoabuttonGroup.setSelected(fisicaRadioButton.getModel(), true);
                    try {
                        cnpjCpfFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
                    } catch (ParseException ex) {
                        JOptionPane.showConfirmDialog(null, ex.getMessage());
                    }
                    cpfcnpjLabel.setText("CPF");
                    cnpjCpfFormattedTextField.setText(fornecedor.getN_documento());
                    break;
                case "J":
                    pessoabuttonGroup.setSelected(juridicaRadioButton.getModel(), true);
                    try {
                        cnpjCpfFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
                    } catch (ParseException ex) {
                        JOptionPane.showConfirmDialog(null, ex.getMessage());
                    }
                    cpfcnpjLabel.setText("CNPJ");
                    cnpjCpfFormattedTextField.setText(fornecedor.getN_documento());
                    break;
            }
        }

        setEdição(false);
        editarSalvar();
        selecionarButton.setVisible(true);
        buscarButton.setVisible(false);
        editarButton.grabFocus();

    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {
        cont = 0;
        jPrincipal.controleFornecedor = null;
    }

    private void botoesNavegacao(boolean estado) {
        frenteButton.setEnabled(estado);
        atrasButton.setEnabled(estado);
        ultimoButton.setEnabled(estado);
        primeiroButton.setEnabled(estado);
    }

    //verifica se se há campos em branco, se tiver retorna false senão true
    public static boolean dadosOK(Fornecedor fornecedores) {
        System.out.println(fornecedores.toString());
        return (fornecedores.getNome().equals(""))
                && (fornecedores.getN_documento().trim().equals(""))
                && (fornecedores.getTipo_pessoa() == null)
                && (fornecedores.getData_cadastro().equals(""))
                && (fornecedores.getEmail().equals(""))
                && (fornecedores.getEndereço().equals(""))
                && (fornecedores.getBairro().equals(""))
                && (fornecedores.getNumero() == -1)
                && (fornecedores.getCep().trim().equals(""))
                && (fornecedores.getTelefone().trim().equals(""))
                && (fornecedores.getCidade().getCodigo() == -1)
                && (fornecedores.getEstado().equals(""));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasButton;
    private javax.swing.JLabel bairroLabel;
    public static javax.swing.JTextField bairroTextField;
    private javax.swing.JPanel botoesPanel;
    public static javax.swing.JLabel buscacepjLabel;
    public static javax.swing.JButton buscarButton;
    public static javax.swing.JButton cancelaButton;
    public static javax.swing.JFormattedTextField cepFormattedTextField;
    private javax.swing.JLabel cepLabel;
    public static javax.swing.JProgressBar cepProgressBar;
    private javax.swing.JLabel cidadeLabel;
    public static javax.swing.JTextField cidadeTextField;
    public static javax.swing.JFormattedTextField cnpjCpfFormattedTextField;
    public static javax.swing.JTextField cod_cidadeTextField0;
    private javax.swing.JLabel codigoLabel;
    public static javax.swing.JTextField codigoTextField;
    public static javax.swing.JLabel cpfcnpjLabel;
    private javax.swing.JPanel dadosPanel;
    public static javax.swing.JFormattedTextField dataFormattedTextField;
    private javax.swing.JLabel dataLabel;
    public static javax.swing.JButton editarButton;
    public static javax.swing.JButton eliminarButton;
    private javax.swing.JLabel emailLabel;
    public static javax.swing.JTextField emailTextField;
    private javax.swing.JPanel enderecoPanel;
    private javax.swing.JLabel estadoLabel;
    public static javax.swing.JTextField estadoTextField;
    public static javax.swing.JRadioButton fisicaRadioButton;
    private javax.swing.JButton frenteButton;
    public static javax.swing.JButton gravarButton;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JRadioButton juridicaRadioButton;
    private javax.swing.JLabel nomeLabel;
    public static javax.swing.JTextField nomeTextField;
    public static javax.swing.JButton novoButton;
    private javax.swing.JLabel numeroLabel;
    public static javax.swing.JTextField numeroTextField;
    public static javax.swing.ButtonGroup pessoabuttonGroup;
    private javax.swing.JButton primeiroButton;
    private javax.swing.JLabel ruaLabel;
    public static javax.swing.JTextField ruaTextField;
    public static javax.swing.JButton salvarButton;
    public static javax.swing.JButton selecionarButton;
    public static javax.swing.JFormattedTextField telefoneFormattedTextField;
    private javax.swing.JLabel telefoneLabel;
    public static javax.swing.JLabel tipo_pessoaLabel;
    private javax.swing.JButton ultimoButton;
    // End of variables declaration//GEN-END:variables

}
