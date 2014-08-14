/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TabelaPrecoJInternalFrame.java
 *
 * Created on 17/05/2009, 22:27:08
 */

package br.com.vebo.dados.swing;

import br.com.vebo.dados.bo.PedidoBO;
import br.com.vebo.dados.bo.RevendedorBO;
import br.com.vebo.dados.enums.MesEnum;
import br.com.vebo.dados.mapeamento.Pedido;
import br.com.vebo.dados.mapeamento.Revendedor;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author mohfus
 */
public class PedidosMensaisPorRevendedorJInternalFrame extends javax.swing.JInternalFrame {

    /** Creates new form TabelaPrecoJInternalFrame */
    public PedidosMensaisPorRevendedorJInternalFrame() {
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

        lblRevendedor = new javax.swing.JLabel();
        cbxRevendedor = new javax.swing.JComboBox();
        btnVisualizar = new javax.swing.JButton();
        lblMes = new javax.swing.JLabel();
        cbxMes = new javax.swing.JComboBox();
        lblAno = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pedidos Mensais Por Revendedor");

        lblRevendedor.setText("Revendedor");

        cbxRevendedor.setModel(new javax.swing.DefaultComboBoxModel());
        atualizaComboBox();

        btnVisualizar.setText("Visualizar");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        lblMes.setText("Mês");

        cbxMes.setModel(new javax.swing.DefaultComboBoxModel(MesEnum.values()));

        lblAno.setText("Ano");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVisualizar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRevendedor)
                            .addComponent(lblMes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cbxMes, 0, 348, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lblAno)
                                .addGap(18, 18, 18)
                                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbxRevendedor, javax.swing.GroupLayout.Alignment.TRAILING, 0, 513, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRevendedor)
                    .addComponent(cbxRevendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMes)
                    .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAno))
                .addGap(18, 18, 18)
                .addComponent(btnVisualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 655, 200);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        
        // Parametros do relatorios
        Map parametros = new HashMap();

        JasperPrint impressao = null;
        try {

            Calendar calendario = new GregorianCalendar();
            calendario.set(Integer.valueOf(txtAno.getText()), ((MesEnum)cbxMes.getSelectedItem()).getNumero(), 1);
            Date dataInicial = calendario.getTime();

            calendario.set(Integer.valueOf(txtAno.getText()), ((MesEnum)cbxMes.getSelectedItem()).getNumero(), calendario.getActualMaximum(calendario.DAY_OF_MONTH));
            Date dataFinal = calendario.getTime();

            Revendedor revendedor = (Revendedor) cbxRevendedor.getSelectedItem();

            parametros.put("revendedor", revendedor.getNome());
            parametros.put("mes", ((MesEnum)cbxMes.getSelectedItem()).getNome()+"/"+txtAno.getText());

            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(new PedidoBO().obterPorRevendedorPeriodo(dataInicial, dataFinal, revendedor));

            impressao = JasperFillManager.fillReport(System.getProperty("user.dir")+"/relatorios/PedidosMensaisPorRevendedor.jasper", parametros, ds);
            JasperViewer viewer = new JasperViewer(impressao, true);
            viewer.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro",  JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_btnVisualizarActionPerformed

    protected void atualizaComboBox() {
        try {
            if(cbxRevendedor.getItemCount() > 0){
                cbxRevendedor.removeAllItems();
            }
            
            for (Revendedor revendedor : new RevendedorBO().findAll()) {
                cbxRevendedor.addItem(revendedor);
            }
            cbxRevendedor.updateUI();
        }
        catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro",  JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JComboBox cbxMes;
    private javax.swing.JComboBox cbxRevendedor;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblRevendedor;
    private javax.swing.JTextField txtAno;
    // End of variables declaration//GEN-END:variables


}
