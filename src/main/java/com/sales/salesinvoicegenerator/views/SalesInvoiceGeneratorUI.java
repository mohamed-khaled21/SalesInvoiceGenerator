/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.sales.salesinvoicegenerator.views;

import com.sales.salesinvoicegenerator.controllers.InvoiceController;
import com.sales.salesinvoicegenerator.models.Invoice;
import com.sales.salesinvoicegenerator.models.Item;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class SalesInvoiceGeneratorUI extends javax.swing.JFrame implements TableModelListener {

    InvoiceController invoiceController = new InvoiceController();
    Invoice invoice;

    /**
     * Creates new form SalesInvoiceGeneratorUI
     */
    public SalesInvoiceGeneratorUI() {
        initComponents();
        
        itemsTable.getModel().addTableModelListener(this);
        DefaultTableModel model = (DefaultTableModel) itemsTable.getModel();
        
       invoicesTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
                        if (invoicesTable.getSelectedRow() == -1) return;

            // do some actions here, for example
            // print first column value from selected row
//            System.out.println(invoicesTable.getValueAt(invoicesTable.getSelectedRow(), 0).toString());
            // Get invoice object that was tapped on
            for (Invoice x : InvoiceController.invoicesList){
                if (invoicesTable.getValueAt(invoicesTable.getSelectedRow(), 0).toString().equals(""+x.getNumber())){
                    invoice = x;
                }
            }
        invoiceNumberText.setText(String.valueOf(invoice.getNumber()));
        invoiceTotalText.setText(String.valueOf(invoice.getTotal()));
        customerNameTextField.setText(String.valueOf(invoice.getCustomerName()));
        invoiceDateTextField.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        
        //  to set Table 
        for (int i =0; i < 4; i++){
            itemsTable.getModel().setValueAt(null, i, 0);
            itemsTable.getModel().setValueAt(null, i, 1);
            itemsTable.getModel().setValueAt(null, i, 2);
            itemsTable.getModel().setValueAt(null, i, 3);
            itemsTable.getModel().setValueAt(null, i, 4);
        }
        for (int i = 0; i < invoice.getItems().size(); i++){
//            itemsTable.getModel().setValueAt(invoice.getItems().get(i).getNumber(), i, 0);
            itemsTable.getModel().setValueAt(invoice.getItems().get(i).getName(), i, 1);
            itemsTable.getModel().setValueAt(invoice.getItems().get(i).getPrice(), i, 2);
            itemsTable.getModel().setValueAt(invoice.getItems().get(i).getCount(), i, 3);
        }
        }
    });

    }

    double getValueOfTotal(int row) {
        int count = Integer.parseInt(itemsTable.getCellEditor(row, 3).getCellEditorValue().toString());
        double price = Integer.parseInt(itemsTable.getCellEditor(row, 2).getCellEditorValue().toString());
        return count * price;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        fileStatusText = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        invoiceNumberText = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        invoiceTotalText = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        invoiceDateTextField = new javax.swing.JTextField();
        customerNameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        errorHintText = new javax.swing.JLabel();
        hintErrorText = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Invoices table");

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Date", "Customer", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invoicesTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(invoicesTable);
        invoicesTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (invoicesTable.getColumnModel().getColumnCount() > 0) {
            invoicesTable.getColumnModel().getColumn(0).setResizable(false);
            invoicesTable.getColumnModel().getColumn(1).setResizable(false);
            invoicesTable.getColumnModel().getColumn(2).setResizable(false);
            invoicesTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton1.setText("Create New Invoice");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete Invoice");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        fileStatusText.setForeground(new java.awt.Color(0, 153, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileStatusText, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fileStatusText)
                .addContainerGap())
        );

        jLabel3.setText("Invoice Number");

        invoiceNumberText.setText("N/A");

        jLabel6.setText("Invoice Date");

        jLabel8.setText("Customer Name");

        invoiceTotalText.setText("N/A");

        jLabel10.setText("Invoice Total");

        invoiceDateTextField.setEditable(false);
        invoiceDateTextField.setText("N/A");
        invoiceDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceDateTextFieldActionPerformed(evt);
            }
        });

        customerNameTextField.setText("N/A");
        customerNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Invoice Items");

        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "Item Name", "Item Price", "Count", "Item Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemsTable.setColumnSelectionAllowed(true);
        itemsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(itemsTable);
        itemsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (itemsTable.getColumnModel().getColumnCount() > 0) {
            itemsTable.getColumnModel().getColumn(0).setResizable(false);
            itemsTable.getColumnModel().getColumn(1).setResizable(false);
            itemsTable.getColumnModel().getColumn(2).setResizable(false);
            itemsTable.getColumnModel().getColumn(3).setResizable(false);
            itemsTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        errorHintText.setForeground(new java.awt.Color(255, 0, 51));

        hintErrorText.setForeground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerNameTextField))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(invoiceTotalText, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(invoiceNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(invoiceDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errorHintText, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hintErrorText, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceTotalText, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton3)
                        .addComponent(hintErrorText))
                    .addComponent(errorHintText))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jMenu2.setText("File");

        jMenuItem1.setText("Load File");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Save File");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new InvoiceController().createNewInvoice("", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")), 0.0, new ArrayList());
        ((DefaultTableModel) invoicesTable.getModel()).addRow(new Object[]{InvoiceController.invoicesList.get(InvoiceController.invoiceNumber-2).getNumber(),InvoiceController.invoicesList.get(InvoiceController.invoiceNumber-2).getDate() , "", 0.0});
    }//GEN-LAST:event_jButton1ActionPerformed

    private void invoiceDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoiceDateTextFieldActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        // Check that customer name has a value
        if (customerNameTextField.getText().isEmpty()) {
            hintErrorText.setText("Please, Enter customer name");
            return;
        }

        // loop in all rows that has a item no. value
        boolean allRowsHasData = true;
        for (int i = 0; i < itemsTable.getModel().getRowCount(); i++) {
            // check that all column has a value for each row
            if (itemsTable.getModel().getValueAt(i, 4) != null) {
               {
                    if (itemsTable.getModel().getValueAt(i, 1) == null)allRowsHasData = false; // At least there is a missing field in a row
                }
            }
        }
        if (allRowsHasData) {
            hintErrorText.setText("");
            // Create new invoice
            Invoice invoice = new Invoice();
            invoice.setNumber(Integer.parseInt(invoiceNumberText.getText()));
            invoice.setDate(invoiceDateTextField.getText());
            invoice.setCustomerName(customerNameTextField.getText());
            invoice.setTotal(Double.parseDouble(invoiceTotalText.getText()));
            // Create items list with the items 
            List<Item> itemsList = new ArrayList();
            for (int i = 0; i < itemsTable.getModel().getRowCount(); i++) {
                // check that all column has a value for each row
                if (itemsTable.getModel().getValueAt(i, 4) != null && itemsTable.getModel().getValueAt(i, 1) != null) {
                    Item newItem = new Item();
                    newItem.setNumber(Integer.parseInt(itemsTable.getModel().getValueAt(i, 0).toString()));
                    newItem.setName(itemsTable.getModel().getValueAt(i, 1).toString());
                    newItem.setPrice(Double.parseDouble(itemsTable.getModel().getValueAt(i, 2).toString()));
                    newItem.setCount(Integer.parseInt(itemsTable.getModel().getValueAt(i, 3).toString()));
                    itemsList.add(newItem);
                }
            }
            invoice.setItems(itemsList);

            // Save new edits to Invoice to invoices table
            Invoice oldInvoice = null;
            for (Invoice x :InvoiceController.invoicesList){
                if (x.getNumber() == Integer.parseInt(invoiceNumberText.getText())){
                // get old one
                oldInvoice = x;
                }
            }
            // replace old one with new one
            int index = InvoiceController.invoicesList.indexOf(oldInvoice);
            System.out.println("Deleted");
            System.out.println(index);
            // remove from list
            InvoiceController.invoicesList.remove(index);
            // add into index
            InvoiceController.invoicesList.add(index, invoice);
            
            ((DefaultTableModel)invoicesTable.getModel()).getDataVector().clear();
           for (Invoice x : InvoiceController.invoicesList){
           ((DefaultTableModel)invoicesTable.getModel()).addRow(new Object[]{
           x.getNumber(),
           x.getDate(),
           x.getCustomerName(),
           x.getTotal(),
           });
           }
        } else {
            hintErrorText.setText("There is missing values in rows");
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (invoicesTable.getSelectedRow() == -1) {
            return;
        }
        ((DefaultTableModel) invoicesTable.getModel()).removeRow(invoicesTable.getSelectedRow());

    }//GEN-LAST:event_jButton2ActionPerformed

    private void customerNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameTextFieldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        invoiceNumberText.setText("N/A");
        invoiceDateTextField.setText("N/A");
        customerNameTextField.setText("N/A");
        invoiceTotalText.setText("N/A");
        //  to set Table 
        for (int i =0; i < 4; i++){
            itemsTable.getModel().setValueAt(null, i, 0);
            itemsTable.getModel().setValueAt(null, i, 1);
            itemsTable.getModel().setValueAt(null, i, 2);
            itemsTable.getModel().setValueAt(null, i, 3);
            itemsTable.getModel().setValueAt(null, i, 4);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       boolean successful = new InvoiceController().addInvoicesListToCSVFiles();
       if(successful){
       fileStatusText.setText("File Saved Successfully");
       fileStatusText.setForeground(Color.GREEN);
       }
       else {
       fileStatusText.setText("Error in saving file");
       fileStatusText.setForeground(Color.RED);}
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        boolean successful = new InvoiceController().loadInvoicesFromCSVFiles();
       if(successful){
           ((DefaultTableModel)invoicesTable.getModel()).getDataVector().clear();
           for (Invoice invoice : InvoiceController.invoicesList){
           ((DefaultTableModel)invoicesTable.getModel()).addRow(new Object[]{
           invoice.getNumber(),
           invoice.getDate(),
           invoice.getCustomerName(),
           invoice.getTotal(),
           });
           }
       fileStatusText.setText("File Loaded Successfully");
       fileStatusText.setForeground(Color.GREEN);
       }
       else {
       fileStatusText.setText("Error in loading file");
       fileStatusText.setForeground(Color.RED);}
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceGeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceGeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceGeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesInvoiceGeneratorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesInvoiceGeneratorUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField customerNameTextField;
    private javax.swing.JLabel errorHintText;
    private javax.swing.JLabel fileStatusText;
    private javax.swing.JLabel hintErrorText;
    private javax.swing.JTextField invoiceDateTextField;
    private javax.swing.JLabel invoiceNumberText;
    private javax.swing.JLabel invoiceTotalText;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JTable itemsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void tableChanged(TableModelEvent e) {
        hintErrorText.setText("");
        int row = e.getFirstRow();
        int column = e.getColumn(); // columns[2, 3]
        String columnName = itemsTable.getModel().getColumnName(column);
        System.out.println(itemsTable.getModel().getValueAt(row, column));

        // This means that he entered a value in [count or price]
        if (column == 2 || column == 3) {
            // 1- Check if the two cells have values
            if (itemsTable.getModel().getValueAt(row, 2) != null
                    && itemsTable.getModel().getValueAt(row, 3) != null) {
                double itemPrice = Double.parseDouble(itemsTable.getModel().getValueAt(row, 2).toString());
                int itemCount = Integer.parseInt(itemsTable.getModel().getValueAt(row, 3).toString());
                itemsTable.getModel().setValueAt(itemPrice * itemCount, row, 4);
            }
        }
        // Check if item no. has a value or not
        if (itemsTable.getModel().getValueAt(row, 0) == null) {
            itemsTable.getModel().setValueAt(row+1, row, 0);
        }

        // Set total of the invoice
        double invoiceTotal = 0.0;
        for (int i = 0; i < itemsTable.getModel().getRowCount(); i++) {
            if (itemsTable.getModel().getValueAt(i, 4) != null) {
                invoiceTotal += Double.parseDouble(itemsTable.getModel().getValueAt(i, 4).toString());
            }
        }
        invoiceTotalText.setText("" + invoiceTotal);

    }

    private Object InvoiceController() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
