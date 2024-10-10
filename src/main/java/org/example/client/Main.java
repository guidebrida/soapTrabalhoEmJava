package org.example.client;

import org.example.client.service.Order;
import org.example.client.service.OrderService;
import org.example.client.service.OrderServiceService;
import org.example.client.service.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static OrderService orderService;

    public static void main(String[] args) {
        OrderServiceService service = new OrderServiceService();
        orderService = service.getOrderServicePort();

        JFrame menuFrame = new JFrame("Menu Principal");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(400, 200);
        menuFrame.setLayout(new GridLayout(3, 1)); // 3 linhas, 1 coluna

        JButton criarOrdemButton = new JButton("Criar Nova Ordem");
        criarOrdemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarNovaOrdem();
            }
        });

        JButton exibirOrdensButton = new JButton("Exibir Ordens");
        exibirOrdensButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirOrdens();
            }
        });

        JButton excluirOrdemPorId = new JButton("Excluir OS");
        excluirOrdemPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirporId();
            }
        });

        JButton editarStatusButton = new JButton("Editar Status da OS");
        editarStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarStatusOrdem();
            }
        });

        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuFrame.add(criarOrdemButton);
        menuFrame.add(exibirOrdensButton);
        menuFrame.add(excluirOrdemPorId);
        menuFrame.add(editarStatusButton);
        menuFrame.add(sairButton);
        menuFrame.setVisible(true);
    }

    private static void criarNovaOrdem() {
        List<Product> products = new ArrayList<>();

        JFrame frame = new JFrame("Criar Nova Ordem");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel labelProduto = new JLabel("Produto:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        frame.add(labelProduto, gbc);

        JTextField productNameField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(productNameField, gbc);

        JLabel labelQuantidade = new JLabel("Quantidade:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(labelQuantidade, gbc);

        JTextField quantidadeField = new JTextField(5);
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(quantidadeField, gbc);

        JLabel labelEndereco = new JLabel("Endereço:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(labelEndereco, gbc);

        JTextField enderecoField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(enderecoField, gbc);

        JLabel labelStatus = new JLabel("Status:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(labelStatus, gbc);

        JTextField statusField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        frame.add(statusField, gbc);

        JButton jButtonCriarOrdem = new JButton("Criar Ordem");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        frame.add(jButtonCriarOrdem, gbc);

        JButton jButtonRetornar = new JButton("Retornar");
        gbc.gridx = 1;
        gbc.gridy = 4;
        frame.add(jButtonRetornar, gbc);

        jButtonCriarOrdem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = productNameField.getText();
                Integer quantidade = Integer.valueOf(quantidadeField.getText());
                String endereco = enderecoField.getText();
                String status = statusField.getText();

                Product product = new Product();
                product.setProductName(productName);
                product.setId(products.size() + 1);
                product.setQuantidade(quantidade);
                products.add(product);

                Order order = new Order();
                order.setId(obterNovoId());
                order.setEndereco(endereco);
                order.setStatus(status);
                order.getProducts().addAll(products);

                orderService.create(order);
                productNameField.setText("");
                quantidadeField.setText("");
                enderecoField.setText("");
                statusField.setText("");

                JOptionPane.showMessageDialog(frame, "Ordem criada com sucesso!");
            }
        });

        jButtonRetornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    private static int obterNovoId() {
        List<Order> orders = orderService.getAll();
        return orders.stream()
                .mapToInt(Order::getId)
                .max()
                .orElse(0) + 1;
    }

    private static void exibirOrdens() {
        List<Order> orderList = orderService.getAll();

        if (orderList == null || orderList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma ordem criada.");
            return;
        }

        StringBuilder ordens = new StringBuilder();
        for (Order order : orderList) {
            ordens.append("ID: ").append(order.getId()).append("\n");
            ordens.append("Status: ").append(order.getStatus()).append("\n");
            ordens.append("Endereço: ").append(order.getEndereco()).append("\n");
            ordens.append("Produtos:\n");
            for (Product product : order.getProducts()) {
                ordens.append("- ").append(product.getProductName())
                        .append(" (Quantidade: ").append(product.getQuantidade()).append(")\n");
            }
            ordens.append("\n");
        }
        JOptionPane.showMessageDialog(null, ordens.toString(), "Ordens Criadas", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void excluirporId() {
        JFrame frame = new JFrame("Excluir Ordem");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelId = new JLabel("Insira o ID da Ordem a ser excluída:");
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 0; // Linha 0
        gbc.gridwidth = 2; // Abrange duas colunas
        frame.add(labelId, gbc);

        JTextField idField = new JTextField(10);
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 1; // Linha 1
        gbc.gridwidth = 2; // Abrange duas colunas
        frame.add(idField, gbc);

        JButton excluirButton = new JButton("Excluir");
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 2; // Linha 2
        gbc.gridwidth = 1; // Ocupar uma célula
        frame.add(excluirButton, gbc);

        JButton cancelarButton = new JButton("Cancelar");
        gbc.gridx = 1; // Coluna 1
        gbc.gridy = 2; // Linha 2
        gbc.gridwidth = 1; // Ocupar uma célula
        frame.add(cancelarButton, gbc);

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int orderId = Integer.parseInt(idField.getText());

                    orderService.delete(orderId);

                    JOptionPane.showMessageDialog(frame, "Ordem excluída com sucesso!");
                    frame.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "ID inválido. Por favor, insira um número válido.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao excluir a ordem: " + ex.getMessage());
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    private static void editarStatusOrdem() {
        JFrame frame = new JFrame("Editar Status da Ordem");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelId = new JLabel("ID da Ordem:");
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 0; // Linha 0
        frame.add(labelId, gbc);

        JTextField idField = new JTextField(10);
        gbc.gridx = 1; // Coluna 1
        gbc.gridy = 0; // Linha 0
        frame.add(idField, gbc);

        JLabel labelNovoStatus = new JLabel("Novo Status:");
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 1; // Linha 1
        frame.add(labelNovoStatus, gbc);

        JTextField novoStatusField = new JTextField(10);
        gbc.gridx = 1; // Coluna 1
        gbc.gridy = 1; // Linha 1
        frame.add(novoStatusField, gbc);

        JButton editarButton = new JButton("Editar Status");
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 2; // Linha 2
        gbc.gridwidth = 1; // Ocupar uma célula
        frame.add(editarButton, gbc);

        JButton cancelarButton = new JButton("Cancelar");
        gbc.gridx = 1; // Coluna 1
        gbc.gridy = 2; // Linha 2
        gbc.gridwidth = 1; // Ocupar uma célula
        frame.add(cancelarButton, gbc);

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int orderId = Integer.parseInt(idField.getText());
                    String novoStatus = novoStatusField.getText();

                    orderService.updateStatus(orderId, novoStatus);

                    JOptionPane.showMessageDialog(frame, "Status atualizado com sucesso!");
                    frame.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "ID inválido. Por favor, insira um número válido.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao atualizar o status: " + ex.getMessage());
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }



}
