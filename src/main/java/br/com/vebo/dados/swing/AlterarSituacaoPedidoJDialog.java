/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UtilizacaoMaterialJDialog.java
 *
 * Created on 17/05/2009, 15:31:48
 */

package br.com.vebo.dados.swing;

import br.com.spartafw.exception.DataAccessException;
import br.com.vebo.dados.bo.PedidoBO;
import br.com.vebo.dados.mapeamento.Pedido;
import br.com.vebo.dados.mapeamento.SituacaoPedidoEnum;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author mohfus
 */
public class AlterarSituacaoPedidoJDialog extends javax.swing.JDialog {

    private SituacoesPorPedidoJInternalFrame situacoesPorPedidoJInternalFrame = null;
    private Pedido pedido = null;

    /** Creates new form UtilizacaoMaterialJDialog */
    public AlterarSituacaoPedidoJDialog(SituacoesPorPedidoJInternalFrame situacoesPorPedidoJInternalFrame, Long idPedido) {
        super(getRootWindow(situacoesPorPedidoJInternalFrame));
        this.situacoesPorPedidoJInternalFrame = situacoesPorPedidoJInternalFrame;
        try {
            pedido = new PedidoBO().retrieve(idPedido);
        }
        catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",  JOptionPane.ERROR_MESSAGE);
        }
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

        jLabel1 = new javax.swing.JLabel();
        cbxSituacaoPedido = new javax.swing.JComboBox();
        btnAtualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Utilização de Material no Cálculo");
        setModal(true);

        jLabel1.setText("Situação do Pedido");

        cbxSituacaoPedido.setModel(new DefaultComboBoxModel(new String[]{"FEITO", "AGUARDANDO_ESSENCIA", "ENTREGUE"}));

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblCodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodigo.setText("código");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSituacaoPedido, 0, 257, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(197, Short.MAX_VALUE)
                        .addComponent(btnAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodigo)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxSituacaoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAtualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(421, 167));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed

        pedido.setSituacaoPedido(SituacaoPedidoEnum.valueOf(cbxSituacaoPedido.getSelectedItem().toString()));
        try {
            new PedidoBO().save(pedido);
            JOptionPane.showMessageDialog(this, "Pedido alterado com sucesso", "Mensagem",  JOptionPane.INFORMATION_MESSAGE);
        }
        catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",  JOptionPane.ERROR_MESSAGE);
        }
        situacoesPorPedidoJInternalFrame.atualizaTabela();
        dispose();
}//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    public static Window getRootWindow(Component c) {
        if (c instanceof Frame) {
            return (Window)c;
        }
        return getRootWindow(c.getParent());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cbxSituacaoPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCodigo;
    // End of variables declaration//GEN-END:variables

}
