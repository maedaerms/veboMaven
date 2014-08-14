/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Material.java
 *
 * Created on 16/05/2009, 01:41:32
 */

package br.com.vebo.dados.swing;

import br.com.spartafw.exception.DataAccessException;
import br.com.spartafw.hibernate.util.HibernateUtil;
import br.com.vebo.dados.bo.PerfumeBO;
import br.com.vebo.dados.mapeamento.Perfume;
import br.com.vebo.dados.mapeamento.SexoEnum;
import br.com.vebo.dados.swing.table.PerfumeTableModel;
import br.com.vebo.util.DoubleUtil;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mohfus
 */
public class PerfumeJInternalFrame extends javax.swing.JInternalFrame {

    /** Creates new form Material */
    public PerfumeJInternalFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalJPanel = new javax.swing.JPanel();
        tabelaJScrolPane = new javax.swing.JScrollPane();
        perfumeJTable = new javax.swing.JTable();
        lblNome = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtValor = new javax.swing.JFormattedTextField();
        lblEssencia = new javax.swing.JLabel();
        txtEssencia = new javax.swing.JTextField();
        lblPublico = new javax.swing.JLabel();
        cbxPublico = new javax.swing.JComboBox();
        lblDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDescricao = new javax.swing.JTextArea();
        btnLimpar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);
        setTitle("Perfumes");
        setName("Perfume"); // NOI18N

        perfumeJTable.setModel(new br.com.vebo.dados.swing.table.PerfumeTableModel());
        perfumeJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                perfumeJTableMouseClicked(evt);
            }
        });
        tabelaJScrolPane.setViewportView(perfumeJTable);
        atualizaTabela();

        lblNome.setText("Nome");

        lblValor.setText("Valor");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtValor.setVerifyInputWhenFocusTarget(false);

        lblEssencia.setText("Ess�ncia");

        lblPublico.setText("P�blico");

        cbxPublico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MASCULINO", "FEMININO" }));

        lblDescricao.setText("Descri��o");

        txaDescricao.setColumns(20);
        txaDescricao.setLineWrap(true);
        txaDescricao.setRows(5);
        jScrollPane1.setViewportView(txaDescricao);

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout principalJPanelLayout = new javax.swing.GroupLayout(principalJPanel);
        principalJPanel.setLayout(principalJPanelLayout);
        principalJPanelLayout.setHorizontalGroup(
            principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabelaJScrolPane, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                    .addGroup(principalJPanelLayout.createSequentialGroup()
                        .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblEssencia)
                            .addComponent(lblPublico)
                            .addComponent(lblValor)
                            .addComponent(lblDescricao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                            .addComponent(cbxPublico, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEssencia, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalJPanelLayout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)))
                .addContainerGap())
        );
        principalJPanelLayout.setVerticalGroup(
            principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabelaJScrolPane, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEssencia)
                    .addComponent(txtEssencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPublico)
                    .addComponent(cbxPublico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(principalJPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAlterar)
                            .addComponent(btnExcluir)
                            .addComponent(btnNovo)
                            .addComponent(btnLimpar)))
                    .addComponent(lblDescricao))
                .addContainerGap())
        );

        getContentPane().add(principalJPanel, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-698)/2, (screenSize.height-578)/2, 698, 578);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (validaForm()) {

            try {
                Perfume perfume = new PerfumeBO().retrieve(idPerfume);
                perfume.setNomeVebo(txtNome.getText());
                perfume.setNomeEssencia(txtEssencia.getText());
                perfume.setPublico(SexoEnum.valueOf((String)cbxPublico.getSelectedItem()));
                perfume.setDescricao(txaDescricao.getText());
                perfume.setValorEssencia10ml(new DoubleUtil().stringParaDouble(txtValor.getText()));
                HibernateUtil.beginTransaction();
                new PerfumeBO().save(perfume);
                HibernateUtil.commitTransaction();
                JOptionPane.showMessageDialog(this, "Perfume alterado com sucesso", "Mensagem",  JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",  JOptionPane.ERROR_MESSAGE);
            }

            limpaForm();
            atualizaTabela();
            
        }
}//GEN-LAST:event_btnAlterarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        if (validaForm()) {
            Perfume novoPerfume = new Perfume();
            novoPerfume.setNomeVebo(txtNome.getText());
            novoPerfume.setNomeEssencia(txtEssencia.getText());
            novoPerfume.setPublico(SexoEnum.valueOf((String)cbxPublico.getSelectedItem()));
            novoPerfume.setDescricao(txaDescricao.getText());
            novoPerfume.setValorEssencia10ml(new DoubleUtil().stringParaDouble(txtValor.getText()));
            try {
                HibernateUtil.beginTransaction();
                new PerfumeBO().save(novoPerfume);
                HibernateUtil.commitTransaction();
                JOptionPane.showMessageDialog(this, "Perfume inserido com sucesso", "Mensagem",  JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",  JOptionPane.ERROR_MESSAGE);
            }

            limpaForm();
            atualizaTabela();
            
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o perfume selecionado?","Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            int linhaSelecionada = perfumeJTable.getSelectedRow();
            try {
                Perfume perfume = new PerfumeBO().retrieve((Long) perfumeJTable.getValueAt(linhaSelecionada, 0));
                HibernateUtil.beginTransaction();
                new PerfumeBO().delete(perfume);
                HibernateUtil.commitTransaction();
                JOptionPane.showMessageDialog(this, "Perfume excluído com sucesso", "Mensagem",  JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",  JOptionPane.ERROR_MESSAGE);
            }
            atualizaTabela();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void perfumeJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perfumeJTableMouseClicked
        if (evt.getClickCount() > 1) {
            int linhaSelecionada = perfumeJTable.getSelectedRow();
            try {
                Perfume perfume = new PerfumeBO().retrieve((Long) perfumeJTable.getValueAt(linhaSelecionada, 0));
                idPerfume = perfume.getId();
                txtNome.setText(perfume.getNomeVebo());
                txtEssencia.setText(perfume.getNomeEssencia());
                cbxPublico.setSelectedItem(perfume.getPublico().toString());
                txtValor.setText(new DoubleUtil().doubleParaString(perfume.getValorEssencia10ml()));
                txaDescricao.setText(perfume.getDescricao());
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",  JOptionPane.ERROR_MESSAGE);
            }
        }
}//GEN-LAST:event_perfumeJTableMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpaForm();
    }//GEN-LAST:event_btnLimparActionPerformed


    private boolean validaForm() {
        boolean retorno = true;
        StringBuffer mensagensErro = new StringBuffer();
        if (txtNome.getText().isEmpty()) {
            mensagensErro.append("O campo Nome é requerido.\n");
            retorno = false;
        }
        if (txtEssencia.getText().isEmpty()) {
            mensagensErro.append("O campo Essência é requerido.\n");
            retorno = false;
        }
        if (txtValor.getText().isEmpty()) {
            mensagensErro.append("O campo Valor é requerido.\n");
            retorno = false;
        }
        else if (new DoubleUtil().stringParaDouble(txtValor.getText()) == null){
            mensagensErro.append("O campo Valor é inválido. Exemplo: 35,50\n");
            retorno = false;
        }
        if (!retorno) {
            JOptionPane.showMessageDialog(this, mensagensErro.toString(), "Validação",  JOptionPane.ERROR_MESSAGE);
        }
        return retorno;
    }

    private void limpaForm() {
        idPerfume = 0l;
        txtNome.setText("");
        txtEssencia.setText("");
        cbxPublico.setSelectedIndex(0);
        txtValor.setText("");
        txaDescricao.setText("");
    }

    private void atualizaTabela() {

        PerfumeTableModel tableModel = (PerfumeTableModel) perfumeJTable.getModel();
        try {
            tableModel.setPerfumes((List) new PerfumeBO().findAll());
        } catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",  JOptionPane.ERROR_MESSAGE);
        }
        perfumeJTable.updateUI();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox cbxPublico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblEssencia;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPublico;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable perfumeJTable;
    private javax.swing.JPanel principalJPanel;
    private javax.swing.JScrollPane tabelaJScrolPane;
    private javax.swing.JTextArea txaDescricao;
    private javax.swing.JTextField txtEssencia;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
    private Long idPerfume = 0l;
}